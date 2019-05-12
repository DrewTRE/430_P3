/* 
Author: Drew Kwak
Date: 5/12/2019
Description: Driver for the tests of the threads.    
*/
import java.util.Date;

public class Test3 extends Thread {
  private final static String cpuTest = "TestThread3a";
  private final static String ioTest  = "TestThread3b";
  private int pairs;

  public Test3() {
    pairs = 1;
  }

  public Test3(String[] args) {
    pairs = Integer.parseInt(args[0]);
  }

  @Override
  public void run() {
  // Timer Start.
  Date stop, start = new Date();
  // Thread ID.
  int tid;           

  // Execute pairs of threads. 
  for (int i = 0; i < pairs; i++) {
    SysLib.exec(SysLib.stringToArgs(cpuTest));
    SysLib.exec(SysLib.stringToArgs(ioTest));
  }

  // Wait on threads to finish. 
  for (int i = 0; i < pairs * 2; i++) {
    tid  = SysLib.join();
    stop = new Date();
  }

  // Stop the Timer. 
  stop = new Date();

  SysLib.cout("\nElapsed time: " + (stop.getTime() - start.getTime()) + " ms\n");
  SysLib.exit();
  }
}