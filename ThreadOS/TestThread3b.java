/* 
Author: Drew Kwak
Date: 5/12/2019
Description: Simple IO intensive test.    
*/
public class TestThread3b extends Thread {
  private final static int BLOCK_QTY  = 1000;
  private final static int BLOCK_SIZE = 512; 
  private byte[] data;

  public TestThread3b() {
    data = new byte[BLOCK_SIZE];
  }

  public void run() {
    data = new byte[BLOCK_SIZE];
    for (int i = 0; i < BLOCK_QTY; i++) {
        SysLib.rawwrite(i, data);
        SysLib.rawread(i, data);
    }
  SysLib.cout("TestThread3b Finished\n");
  SysLib.sync(); 
  SysLib.exit();
  }
}