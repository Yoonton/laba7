package Threads;

import Vehicle.Vehicle;
public class PrintMarkExecutor implements Runnable{
    private Vehicle veh;
    public PrintMarkExecutor(Vehicle v){
        veh = v;
    }

    @Override
    public void run(){
        System.out.println("Mark: " + veh.getMark());
    }
} 
