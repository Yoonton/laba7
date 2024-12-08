package Threads;

import Vehicle.Vehicle;

public class TransportSynchronizer {
    private Vehicle v;
    private volatile int current = 0;
    private Object lock = new Object();
    private boolean set = true;

    public TransportSynchronizer(Vehicle v){
        this.v = v;
    }

    public void printPrice() throws InterruptedException {
        double val;
        synchronized(lock){
            double[] p = v.getAllModelPrices();
            if(!canPrintPrice()) throw new InterruptedException();
            while(!set) lock.wait();
            val = p[current];
            System.out.println("Print price: "+ val);
            set = false;
            lock.notifyAll();
        }
    }

    public void printModel() throws InterruptedException {
        synchronized(lock){
            String[] s = v.getAllModelNames();
            if(!canPrintModel()) throw new InterruptedException();
            while(set) lock.wait();
            System.out.println("Print Model: " + s[current++]);
            set = true;
            lock.notifyAll();
        }
    }

    public boolean canPrintPrice(){
        return (set && current < v.getSize()) || (!set && current < v.getSize() - 1);
    }
    public boolean canPrintModel(){
        return (current < v.getSize());
    }
}
