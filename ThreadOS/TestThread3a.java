/* 
Author: Drew Kwak
Date: 5/12/2019
Description: Going by what I found online, searching for a factorial is pretty CPU intensive.   
*/
import java.math.BigInteger; 

public class TestThread3a extends Thread {
  int MAX_CALC = 3000; 
  BigInteger factorial; 

  public TestThread3a() {
    factorial = new BigInteger("1");
  }

  public void run() {
    for (BigInteger i = BigInteger("1"); i.compareTo(MAX_CALC) <= 0; i.add(BigInteger("1"))) {
       factorial = factorial.multiply(BigInteger.valueOf(i));
    }         
    SysLib.cout("TestThread3a Finished\n");
    SysLib.exit();
  }
}