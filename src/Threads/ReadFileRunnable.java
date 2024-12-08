package Threads;

import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

import MyTransport.Car;
import Vehicle.Vehicle;

public class ReadFileRunnable implements Runnable{
    private String path;
    private BlockingQueue<Vehicle> blockQueue;
    public ReadFileRunnable(BlockingQueue<Vehicle> ab, String p){
        path = p;
        blockQueue = ab;
    }

    @Override
    public void run(){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader(path));
            String mark = scanner.nextLine();
            Vehicle v = new Car(mark, 5);
            blockQueue.put(v);
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
        finally{
            scanner.close();
        }
    }
}
