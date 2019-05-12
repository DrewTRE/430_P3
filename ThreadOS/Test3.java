import java.util.Date;

public class Test3 extends Thread {
    private int pairs;

    public Test3(String[] args){
        this.pairs = Integer.parseInt(args[0]);
    }

    public void run(){
        String [] argA = SysLib.stringToArgs("TestThread3 A");
        String [] argB = SysLib.stringToArgs("TestThread3 B");
        long initTime =  (new Date()).getTime();

        for (int i = 0; i < this.pairs ; i++){
            SysLib.exec(argA);
            SysLib.exec(argB);
        }

        for (int i = 0; i < (2 * this.pairs); i++){
            SysLib.join();
        }

        long finishTime = (new Date()).getTime();
        SysLib.cout("elapsed time: " + (finishTime - initTime) + " ms\n");
        SysLib.exit();
    }

}