import java.util.Vector;


public class QueueNode {
  private Vector<Integer> pidQ;  

  // Default Constructor. 
  // Vector will hold the thread nodes in a vector. 
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
    int newInt = this.pidQ.remove(0).intValue();
      return newInt;
  }

  // Wakes up a thread with notify(). 
  public synchronized void wakeup(int tid) {
    this.pidQ.add(tid);
    // Wake up the parent. 
    notify();
  } 
} 