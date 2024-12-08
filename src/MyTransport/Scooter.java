package MyTransport;
import java.util.HashMap;
import java.util.Random;

import Exceptions.DuplicateModelNameException;
import Exceptions.ModelPriceOutOfBoundsException;
import Exceptions.NoSuchModelNameException;
import Vehicle.Vehicle;

public class Scooter implements Vehicle{
    private String mark;
    private HashMap<String, Double> models;
    public Scooter(String name, int size){
        mark = name;
        models = new HashMap<>();
        Random rnd = new Random();
        for(int i = 0; i < size; i++){
            models.put("Name: "+ i, 1000 + (1000000 - 1000) * rnd.nextDouble());
        }
    }
    public Scooter(String name, String[] mod, double[] pr){
        mark = name;
        models = new HashMap<>();
        for(int i = 0; i < mod.length; i++){
            models.put(mod[i], pr[i]);
        }
    }

    public double getPriceByName(String name) throws NoSuchModelNameException{
        if(!models.containsKey(name)){
            throw new NoSuchModelNameException("Модели с таким именем нет");
        }
        return models.get(name);
    }

    public void editModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException{
        if(models.containsKey(newName)){
            throw new DuplicateModelNameException("Новое имя не уникально");
        }
        if(!models.containsKey(oldName)){
            throw new NoSuchModelNameException("Модели с таким именем нет");
        }
        double price = models.get(oldName);
        models.remove(oldName);
        models.put(newName, price);
    }

    public int getSize(){
        return models.size();
    }

    public void setPriceByName(String name, double newPrice) throws NoSuchModelNameException{
        if(newPrice < 0){
            throw new ModelPriceOutOfBoundsException("Неверная цена");
        }
        if(!models.containsKey(name)){
            throw new NoSuchModelNameException("Модели с таким именем нет");
        }
        models.put(name, newPrice);
    }

    public void deleteModelByName(String name)throws NoSuchModelNameException{
        if(!models.containsKey(name)){
            throw new NoSuchModelNameException("Модели с таким именем нет");
        }
        models.remove(name);
    }

    public double[] getAllModelPrices(){
        Double[] prices = models.values().toArray(new Double[models.size()]);
        double[] normPrices = new double[models.size()];
        for(int i = 0; i < prices.length; i++){
            normPrices[i] = prices[i];
        }
        return normPrices; 
    }

    public String getMark(){
        return mark;
    }

    public void modelAdd(String newName,double newPrice)throws DuplicateModelNameException{
        if(newPrice < 0){
            throw new ModelPriceOutOfBoundsException("Неверная цена");
        }
        if(models.containsKey(newName)){
            throw new DuplicateModelNameException("Новое имя не уникально");
        }
        models.put(newName, newPrice);
    }

    public void setMark(String newMark){
        mark = newMark;
    }

    public String[] getAllModelNames(){
        return models.keySet().toArray(new String[models.size()]);
    }
}
