package Threads;
import Vehicle.Vehicle;

public class PrintModelName extends Thread{
    private Vehicle veh;
    public PrintModelName(Vehicle v){
        veh = v;
    }

    @Override
    public void run(){
        String[] names = veh.getAllModelNames();
        for(String n : names){
            System.out.println("Модель: "+ n);
        }
    }
}