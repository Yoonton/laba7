package Threads;
import Vehicle.Vehicle;

public class PrintModelPrice extends Thread{
    private Vehicle veh;
    public PrintModelPrice(Vehicle v){
        veh = v;
    }
    @Override
    public void run(){
        double[] prices = veh.getAllModelPrices();
        for(double pr : prices){
            System.out.println("Цена: " + pr);
        }
    }
}