import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import MyTransport.Car;
import MyTransport.Motorbike;
import MyTransport.QuadBike;
import MyTransport.Scooter;
import Threads.PrintMarkExecutor;
import Threads.PrintModelName;
import Threads.PrintModelNameLocked;
import Threads.PrintModelNameRunnable;
import Threads.PrintModelPrice;
import Threads.PrintModelPriceLocked;
import Threads.PrintModelPriceRunnable;
import Threads.ReadFileRunnable;
import Threads.TransportSynchronizer;
import Vehicle.Vehicle;


public class mainClass {
    public static void main(String[] args) throws Exception{
        //!task1
        Car car1 = new Car("Lada", 3);
        PrintModelName t1 = new PrintModelName(car1);
        PrintModelPrice t2 = new PrintModelPrice(car1);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        // t2.start();
        // t1.start();
        
        //!task2
        TransportSynchronizer t = new TransportSynchronizer(car1);
        Thread t3 = new Thread(new PrintModelNameRunnable(t));
        Thread t4 = new Thread(new PrintModelPriceRunnable(t));
        t3.start();
        t4.start();

        //!task3
        ReentrantLock locker = new ReentrantLock();
        Thread t5 = new Thread(new PrintModelNameLocked(locker, car1));
        Thread t6 = new Thread(new PrintModelPriceLocked(locker , car1));
        // t6.start();
        // t5.start();

        //!task4
        Car car2 = new Car("a", 5);
        Motorbike bike1 = new Motorbike("b", 5);
        QuadBike bike2 = new QuadBike("c", 5);
        Scooter scooter1 = new Scooter("d", 5);
        ExecutorService ex = Executors.newFixedThreadPool(2);
        // ex.submit(new PrintMarkExecutor(car2));
        // ex.submit(new PrintMarkExecutor(bike1));
        // ex.submit(new PrintMarkExecutor(bike2));
        // ex.submit(new PrintMarkExecutor(scooter1));
        // ex.shutdown();

        //!task5
        BlockingQueue<Vehicle> bq = new ArrayBlockingQueue<>(2);
        Thread t7 = new Thread(new ReadFileRunnable(bq, "lib\\car1.txt"));
        Thread t8 = new Thread(new ReadFileRunnable(bq, "lib\\car2.txt"));
        Thread t9 = new Thread(new ReadFileRunnable(bq, "lib\\car3.txt"));
        Thread t10 = new Thread(new ReadFileRunnable(bq, "lib\\car4.txt"));
        Thread t11 = new Thread(new ReadFileRunnable(bq, "lib\\car5.txt"));
        // t7.start();
        // t8.start();
        // t9.start();
        // t10.start();
        // t11.start();
        // for(int i = 0; i < 5; i++){
        //     System.out.println(bq.take().getMark());
        // }
    }
}
