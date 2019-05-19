/* 
Author: Drew Kwak
Date: 5/12/2019
Description: Simple IO intensive test.    
*/
public class TestThread3b extends Thread {
  private final static int BLOCK_QTY  = 1000;
  private final static int BLOCK_SIZE = 512; 
  private final static int WORK       = 100; 
  private byte[] data;

  public TestThread3b() {
    data = new byte[BLOCK_SIZE];
  }

  public void run() {
    for (int i = 0; i < WORK; i++) {
      for(int j = 0; j < BLOCK_SIZE; j++) {
        data[j] = (byte)(j * WORK);    
      }
      SysLib.rawwrite(i, data);
      SysLib.rawread(i, data);
    }
    SysLib.sync(); 
    SysLib.cout("TestThread3b Finished\n");
    SysLib.exit();
    SysLib.cout("TestThread3b Exited\n");
  }
}