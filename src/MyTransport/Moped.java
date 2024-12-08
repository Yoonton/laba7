package MyTransport;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

import Exceptions.DuplicateModelNameException;
import Exceptions.ModelPriceOutOfBoundsException;
import Exceptions.NoSuchModelNameException;
import Vehicle.Vehicle;

// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⢿⣿⣿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⡿⢛⣽⣿⣯⡉⣿⣿⠉⣿⣿⣿⣿⣿⣿⣶⠄⣿⣿⣿⠄⢸⣿⣷⡆⢹⣿⠄⢸⣿⣿⣿⡇⠄⣿⣿⣿⠄⣿⣿⣿⣆⢸⣷⡆⢹⣿⣿⡿⣻⣿⣿⣯⠉⣭⣽⣿⡛⢻⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⠄⣿⣿⣿⣿⣷⣿⣿⡀⢿⣿⣛⡿⠿⣿⣿⠄⣿⣿⣿⠄⢸⣿⣟⣡⣾⣿⠄⢸⣿⣿⣿⡇⠄⣿⣿⣿⠄⣿⣟⢸⣿⣿⣿⠇⣸⣿⠻⢾⣿⣿⣿⡇⠄⢿⣿⣻⣧⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⠄⠻⣿⣿⣿⣿⠻⣿⡇⢸⣿⣿⡗⢀⣽⣿⡆⢻⣿⣿⠄⢸⣿⣿⣿⣿⣿⠄⢸⣿⣿⣿⡇⠄⣿⣿⡏⠄⣿⣿⣿⠏⣿⣿⠄⣿⣿⣦⡘⢻⣿⣿⡇⢰⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣭⣿⣿⣵⣶⣿⣷⣾⣿⣿⣷⣿⣿⣿⣶⣶⣿⣷⠒⠞⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣶⣶⣿⣶⣿⣿⣶⣿⣿⣿⣷⣶⣯⣭⣥⣼⣿⣛⣋⣸⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡻⠹⠿⠏⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⡿⠿⠿⠿⠿⠿⠿⠿⢿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠛⠃⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠉⢻
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣠⣶⣶⣶⣶⡿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠄⠄⠄⠂⠄⠄⠄⠄⠄⠄⠄⠄⠄⣼⣿⣿⣿⣿⡿⠄⠄⠄⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣰⣞⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠄⠄⠄⠄⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠉⠄⠄⠄⠄⠄⠸⠻⠛⠁⠉⠄⠉⠙⠛⠻⠿⢿⣿⠄⠄⠄⠈⠸⠄⠄⠄⠄⠄⠄⠄⠄⠸⠿⠿⠿⠿⢻
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⠄⠄⠄⣤⣀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⣠⣀⣴⣷⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠁⠄⠄⠄⠄⠄⠄⢀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣠⣾⣻⣿⣿⣿⠋⠉⢻⣄⠄⠄⠄⠄⠒⠄⠄⠿⠃⠄⠄⠄⠄⠄⣼
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣼⣷⡄⠄⠄⠄⠄⠄⠄⣧⡗⠄⠄⠄⠄⠄⠄⠄⠄⠘⠻⠿⠿⠿⠛⠃⠄⠄⢸⣿⣷⣄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣾⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡃⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣰⣿⣿⣶⣶⠂⠄⠄⠄⠄⠈⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢠⣴⣿⣿⣿⣿⣦⡀⠄⢠⣶⠄⠄⠄⢰⣶⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠄⠄⠄⠄⠄⠄⠄⢀⣀⣠⣿⣿⣿⣿⡿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⡀⠄⠄⠄⠄⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣾⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠄⠄⠄⠰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⠄⠄⠄⠄⠄⠄⠄⠄⠸⢿⣠⣴⣿⡿⠟⠃⠄⠄⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿

public class Moped implements Vehicle{
    private String mark;
    private LinkedList<Model> models;

    public Moped(String name, int count){
        mark = name;
        models = new LinkedList<Model>();
        Random rnd = new Random();
        for(int i = 0; i < count; i++){
            models.add(new Model("Name: "+i, 1000 + (1000000 - 1000) * rnd.nextDouble()));
        }
    }

    public Moped(String name, String[] mod, double[] pr){
        mark = name;
        models = new LinkedList<>();
        for(int i = 0; i < mod.length; i++){
            models.add(new Model(mod[i], pr[i]));
        }
    }

    public double getPriceByName(String name) throws NoSuchModelNameException{
        ListIterator<Model> listIt = models.listIterator();
        Model temp;
        while(listIt.hasNext()){
            temp = listIt.next();
            if(temp.getModelName().equals(name)){
                return temp.getPrice();
            }
        }
        throw new NoSuchModelNameException("Такой модели нет");
    }

    public void editModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException{
        ListIterator<Model> listIt = models.listIterator();
        Model foundTemp = null;
        Model temp;
        while (listIt.hasNext()) {
            temp = listIt.next();
            if(temp.getModelName().equals(newName)){
                throw new DuplicateModelNameException("Новое имя не уникально");
            }
            if(temp.getModelName().equals(oldName)){
                foundTemp = temp;
            }
        }
        if(foundTemp == null){
            throw new NoSuchModelNameException("Модель с таким именем не найдена");
        }
        else{
            foundTemp.setModelName(newName);
        }
    }

    public int getSize(){
        return models.size();
    }

    public void setPriceByName(String name, double price) throws NoSuchModelNameException{
        if(price < 0){
            throw new ModelPriceOutOfBoundsException("Не верная цена");
        }
        ListIterator<Model> listIt = models.listIterator();
        Model temp;
        while(listIt.hasNext()){
            temp = listIt.next();
            if(temp.getModelName().equals(name)){
                temp.setPrice(price);
                return;
            }
        }
        throw new NoSuchModelNameException("Такой модели нет");
    }

    public void deleteModelByName(String name) throws NoSuchModelNameException{
        ListIterator<Model> listIt = models.listIterator();
        while (listIt.hasNext()) {
            if(listIt.next().getModelName().equals(name)){
                listIt.remove();
                return;
            }
        }
        throw new NoSuchModelNameException("Такой модели нет");
    }

    public double[] getAllModelPrices(){
        double[] prices = new double[models.size()];
        int i = 0;
        ListIterator<Model> listIt = models.listIterator();
        while(listIt.hasNext()){
            prices[i] = listIt.next().getPrice();
            i++;
        }
        return prices;
    }
    public String[] getAllModelNames(){
        String[] names = new String[models.size()];
        int i = 0;
        ListIterator<Model> listIt = models.listIterator();
        while (listIt.hasNext()) {
            names[i] = listIt.next().getModelName();
            i++;
        }
        return names;
    }
    public String getMark(){
        return mark;
    }
    public void modelAdd(String name, double price) throws DuplicateModelNameException{
        if(price < 0){
            throw new ModelPriceOutOfBoundsException("Неверное значение цены");
        }
        ListIterator<Model> listIt = models.listIterator();
        while (listIt.hasNext()) {
            if(listIt.next().getModelName().equals(name)){
                throw new DuplicateModelNameException("Новое имя не уникально");
            }
        }
        models.add(new Model(name, price));
    }

    public void setMark(String newMark){
        mark = newMark;
    }

    private class Model implements Serializable{
        String modelName;
        double price;

        public Model(String name, double pr){
            modelName = name;
            price = pr;
        }

        public String getModelName(){
            return modelName;
        }
        public void setModelName(String value){
            modelName = value;
        }
        public double getPrice(){
            return price;
        }
        public void setPrice(double value){
            price = value;
        }
    }
}
