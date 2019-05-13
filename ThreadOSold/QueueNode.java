/*
Author: Drew Kwak
Date: 5/10/2019
Description: Holds a vector of TIDs. Threads put in this queue,
are asleep till woken up when a condition is met. 
*/

import java.util.Vector;

public class QueueNode {
  private Vector<Integer> pidQ;  

  // Default Constructor. 
  // Vector will hold the thread nodes in a vector. 
  // Creates an empty vector. 
  public QueueNode() {
    this.pidQ = new Vector<Integer>();
  } 
    
  // Puts a thread to sleep using wait() until a thread wakes up that thread. 
  public synchronized int sleep() {
    // Sleep until a thread is woken up. 
    if (this.pidQ.isEmpty()) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } 
    // Remove the first TID which is the child of the thread that woke
    // up the thread. 
    int newInt = this.pidQ.remove(0).intValue();
      return newInt;
  }

  // Wakes up a thread with notify(). 
  public synchronized void wakeup(int tid) {
    // Add to Waking TIDs. 
    this.pidQ.add(tid);
    // Wake up the parent. 
    notify();
  } 
} 