package Threads;

import java.util.concurrent.locks.ReentrantLock;
import Vehicle.Vehicle;

public class PrintModelPriceLocked implements Runnable{
    private ReentrantLock locker;
    private Vehicle veh;
    public PrintModelPriceLocked(ReentrantLock l, Vehicle v){
        locker = l;
        veh = v;
    }
    @Override
    public void run(){
        locker.lock();
        try{
            for(double d : veh.getAllModelPrices()){
                System.out.println("Price: " + d);
            }
        }
        finally{
            locker.unlock();
        }
    }
}
