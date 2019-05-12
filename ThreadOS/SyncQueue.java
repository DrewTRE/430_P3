public class SyncQueue {
  // Default condition number. 
  private final static int COND_MAX = 10;     
  // Queue for sleeping threads.
  private QueueNode[] queue;  

  // Creates a queue with the default
  public SyncQueue() {
    queue = new QueueNode[COND_MAX];
  } 

  public SyncQueue(int condDefined) {
    if (condDefined > 0) {
      this.queue = new QueueNode[condDefined];
    } else {
      this.queue = new QueueNode[COND_MAX];
    }
  } 

  public int enqueueAndSleep(int myTid) {
    myTid = myTid % queue.length;
    
    if (queue[myTid] == null) {
        this.queue[myTid] = new QueueNode();
    } 
    
    return this.queue[myTid].sleep();
  } 
  public void dequeueAndWakeup(int hisTid, int myTid) {
    myTid = myTid % queue.length;
    if (queue[myTid] != null) {
        this.queue[myTid].wakeup(myTid);
    }
  }
  public void dequeueAndWakeup(int myTid) {
    myTid = myTid % queue.length;
    if (queue[myTid] != null) {
        this.queue[myTid].wakeup(0);
    } 
  } 
}