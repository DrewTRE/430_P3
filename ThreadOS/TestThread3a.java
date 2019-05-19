/* 
Author: Drew Kwak
Date: 5/12/2019
Description: Going by what I found online, searching for a factorial is pretty CPU intensive.   
*/
import java.math.BigInteger; 

public class TestThread3a extends Thread {
  int MAX_CALC = 99999;
  BigInteger factorial; 

  public TestThread3a() {
    factorial = new BigInteger("1");
  }

  public void run() {
    for (int i = MAX_CALC; i > 0; i--) {
      factorial = factorial.multiply(BigInteger.valueOf(i)); 
    }
    SysLib.cout("TestThread3a Finished\n");
    SysLib.exit();
    SysLib.cout("TestThread3a Exited\n");
  }
}
