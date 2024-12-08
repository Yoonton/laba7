package Vehicle;
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Scanner;

import MyTransport.Car;
import MyTransport.Moped;
import MyTransport.Motorbike;
import MyTransport.QuadBike;
import MyTransport.Scooter;

public class VehicleStatic {
    public static double arithmeticMean(Vehicle vehicle){
        double averagePrice = 0;
        for(int i = 0; i < vehicle.getSize(); i++){
            averagePrice += vehicle.getAllModelPrices()[i];
        }
        return averagePrice/vehicle.getSize();
    }
    public static void printAllModelWithPrice(Vehicle vehicle){
        for(int i = 0; i < vehicle.getSize(); i++){
            System.out.println("Название: " + vehicle.getAllModelNames()[i] + " Стоимость: " + vehicle.getAllModelPrices()[i]);
        }
        System.out.println();
    }
    public static void outputVehicle(Vehicle v, OutputStream out) throws IOException{
        DataOutputStream outStream = new DataOutputStream(out);
        byte[] bytes = v.getClass().toString().getBytes();
        outStream.writeInt(bytes.length);
        outStream.write(bytes);
        bytes = v.getMark().getBytes();
        outStream.writeInt(bytes.length);
        outStream.write(bytes);
        outStream.writeInt(v.getSize());
        String[] models = v.getAllModelNames();
        double[] prices = v.getAllModelPrices();
        for(int i = 0; i < v.getSize(); i++){
            bytes = models[i].getBytes();
            outStream.writeInt(bytes.length);
            outStream.write(bytes);
            outStream.writeDouble(prices[i]);
        }
    }
    public static Vehicle inputVehicle(InputStream in) throws IOException{
        Vehicle v = null;
        DataInputStream inStream = new DataInputStream(in);
        byte[] bytes = new byte[inStream.readInt()];
        for(int i = 0; i < bytes.length; i++){
            bytes[i] = inStream.readByte();
        }
        String vehicleClass = new String(bytes);
        bytes = new byte[inStream.readInt()];
        for(int i = 0; i < bytes.length; i++){
            bytes[i] = inStream.readByte();
        }
        String mark = new String(bytes);
        String[] models = new String[inStream.readInt()];
        double[] prices = new double[models.length];
        for(int i = 0; i < models.length;i++){
            bytes = new byte[inStream.readInt()];
            for(int j = 0; j < bytes.length;j++){
                bytes[j] = inStream.readByte();
            }
            models[i] = new String(bytes);
            prices[i] = inStream.readDouble();
        }
        switch (vehicleClass) {
            case "class Motorbike":
                v = new Motorbike(mark, models, prices);
                break;
            case "class Car":
                v = new Car(mark, models, prices);
                break;
            case "class Scooter":
                v = new Scooter(mark, models, prices);
                break;
            case "class QuadBikeModel":
                v = new QuadBike(mark, models, prices);
                break;
            case "class Moped":
                v = new Moped(mark, models, prices);
                break;
        }
        return v;
    }
    public static void writeVehicle(Vehicle vehicle, Writer out){
        PrintWriter printWriter = new PrintWriter(out);
        printWriter.printf("%s%n", vehicle.getClass());
        printWriter.printf("%s%n", vehicle.getMark());
        printWriter.printf("%d%n", vehicle.getSize());
        String[] models = vehicle.getAllModelNames();
        double[] prices = vehicle.getAllModelPrices();
        for(int i = 0; i < vehicle.getSize(); i++){
            printWriter.printf("%s%n", models[i]);
            printWriter.printf("%.2f%n", prices[i]);
        }
        printWriter.flush();
    }
    public static Vehicle readVehicle(Reader in)throws IOException{
        Scanner scanner = new Scanner(in);
        Vehicle v = null;
        String vehicleClass = scanner.nextLine();
        String vehicleName = scanner.nextLine();
        int size = scanner.nextInt();
        scanner.nextLine();
        String[] models = new String[size];
        double[] prices = new double[size];
        for(int i = 0; i < size; i++){
            models[i] = scanner.nextLine();
            prices[i] = scanner.nextDouble();
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
        scanner.close();
        switch (vehicleClass) {
            case "class Motorbike":
                v = new Motorbike(vehicleName, models, prices);
                break;
            case "class Car":
                v = new Car(vehicleName, models, prices);
                break;
            case "class Scooter":
                v = new Scooter(vehicleName, models, prices);
                break;
            case "class QuadBikeModel":
                v = new QuadBike(vehicleName, models, prices);
                break;
            case "class Moped":
                v = new Moped(vehicleName, models, prices);
                break;
        }
        return v;
    }
    public static Vehicle createVehicle(String name, int size, Vehicle veh) {
       try{
           Class clazz = veh.getClass();
           Constructor constructor = clazz.getConstructor(String.class, int.class);
           Vehicle vehicle = (Vehicle)constructor.newInstance(name, size);
           return vehicle;

       }
       catch(Exception e){
        return null;
       }
    } 

    public static double arithmeticMean(Vehicle... veh){
        double allPrice = 0;
        int vehCount = 0;
        for(Vehicle vehicle : veh){
            double[] vehPrices = vehicle.getAllModelPrices();
            vehCount += vehicle.getSize();
            for(double price : vehPrices){
                allPrice += price;
            }
        }
        return vehCount == 0 ? 0 : allPrice/vehCount;
    }
}
