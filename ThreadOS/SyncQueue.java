/* 
Author: Drew Kwak
Date: 5/10/2019
Description: Monitor for queueing threads that are waiting on some condition.
Parent moves to sleep in the queeu until it's child is done with it's task.
Child then notifies the parent that it's done and wakes up the parent 
(Like children often do). I named the conditions and such based on the 
slides just for readability for myself. 
*/

public class SyncQueue {
  // Default condition number. 
  private final static int COND_MAX = 10;     
  // Queue for sleeping threads.
  private QueueNode[] queue;  

  // Creates a queue with the default condition. 
  public SyncQueue() {
    this.queue = new QueueNode[COND_MAX];
  } 

  // Constructor creates a queue of a defined condition. 
  public SyncQueue(int conDefined) {
    if (conDefined > 0) {
      this.queue = new QueueNode[conDefined];
    } else {
      this.queue = new QueueNode[COND_MAX];
    }
  } 

  // Puts thread to sleep in until condition is satisfied. 
  public int enqueueAndSleep(int myTid) {
    // Check if within bounds of the queue. 
    if ((myTid >= 0) && (myTid < this.queue.length)) {
        this.queue[myTid] = new QueueNode();
    } 
    return this.queue[myTid].sleep();
  }

  // Wakes up thread waiting for the given condition. 
  // Passes the Tid of the calling thread. 
  public void dequeueAndWakeup(int myTid, int hisTid) {
    // Check if within bounds of the queue. 
    if ((myTid >= 0) && (myTid < this.queue.length)) {
        this.queue[myTid].wakeup(hisTid);
    }
  } 

  // Wakes up thread waiting for the given condition. 
  public void dequeueAndWakeup(int myTid) {
    dequeueAndWakeup(myTid, 0);
  } 
}