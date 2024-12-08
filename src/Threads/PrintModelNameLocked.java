package Threads;

import java.util.concurrent.locks.ReentrantLock;
import Vehicle.Vehicle;

public class PrintModelNameLocked implements Runnable{
    private ReentrantLock locker;
    private Vehicle veh;
    public PrintModelNameLocked(ReentrantLock l, Vehicle v){
        locker = l;
        veh = v;
    }
    @Override
    public void run(){
        locker.lock();
        try{
            for(String s : veh.getAllModelNames()){
                System.out.println("Name: "+ s);
            }
        }
        finally{
            locker.unlock();
        }
    }
}
