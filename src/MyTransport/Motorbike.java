package MyTransport;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

import Exceptions.DuplicateModelNameException;
import Exceptions.ModelPriceOutOfBoundsException;
import Exceptions.NoSuchModelNameException;
import Vehicle.Vehicle;

    // ⣿⣿⣿⣿⣿⣿⣿⠿⠿⢛⣋⣙⣋⣩⣭⣭⣭⣭⣍⣉⡛⠻⢿⣿⣿⣿⣿ 
    // ⣿⣿⣿⠟⣋⣥⣴⣾⣿⣿⣿⡆⣿⣿⣿⣿⣿⣿⡿⠟⠛⠗⢦⡙⢿⣿⣿ 
    // ⣿⡟⡡⠾⠛⠻⢿⣿⣿⣿⡿⠃⣿⡿⣿⠿⠛⠉⠠⠴⢶⡜⣦⡀⡈⢿⣿ 
    // ⡿⢀⣰⡏⣼⠋⠁⢲⡌⢤⣠⣾⣷⡄⢄⠠⡶⣾⡀⠀⣸⡷⢸⡷⢹⠈⣿ 
    // ⡇⢘⢿⣇⢻⣤⣠⡼⢃⣤⣾⣿⣿⣿⢌⣷⣅⡘⠻⠿⢛⣡⣿⠀⣾⢠⣿ 
    // ⣷⠸⣮⣿⣷⣨⣥⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢁⡼⠃⣼⣿ 
    // ⡟⠛⠛⠛⣿⠛⠛⢻⡟⠛⠛⢿⡟⠛⠛⡿⢻⡿⠛⡛⢻⣿⠛⡟⠛⠛⢿ 
    // ⡇⢸⣿⠀⣿⠀⠛⢻⡇⠸⠃⢸⡇⠛⢛⡇⠘⠃⢼⣷⡀⠃⣰⡇⠸⠇⢸ 
    // ⡇⢸⣿⠀⣿⠀⠛⢻⡇⢰⣿⣿⡇⠛⠛⣇⢸⣧⠈⣟⠃⣠⣿⡇⢰⣾⣿ 
    // ⣿⣿⣿⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢋⣿⠙⣷⢸⣷⠀⣿⣿⣿ 
    // ⣿⣿⣿⡇⢻⣿⣿⣿⡿⠿⢿⣿⣿⣿⠟⠋⣡⡈⠻⣇⢹⣿⣿⢠⣿⣿⣿ 
    // ⣿⣿⣿⣿⠘⣿⣿⣿⣿⣯⣽⣉⣿⣟⣛⠷⠙⢿⣷⣌⠀⢿⡇⣼⣿⣿⣿ 
    // ⣿⣿⣿⡿⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⡙⢿⢗⣀⣁⠈⢻⣿⣿ 
    // ⣿⡿⢋⣴⣿⣎⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡉⣯⣿⣷⠆⠙⢿ 
    // ⣏⠀⠈⠧⠡⠉⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠉⢉⣁⣀⣀⣾
public class Motorbike implements Vehicle {
    private int size = 0;
    private Model head = null;
    private String bikeMark;
    private transient LocalDateTime lastModifed = null;

    {
        lastModifed = LocalDateTime.now();
    }

    public Motorbike(String name, int s) {
        size = s;
        bikeMark = name;
        head = new Model();
        head.next = head;
        head.prev = head;
        createModelList(s);
    }

    public Motorbike(String name, String[] models, double[] prices) {
        bikeMark = name;
        head = new Model();
        head.next = head;
        head.prev = head;
        for (int i = 0; i < models.length; i++) {
            Model model = new Model(models[i], prices[i]);
            model.setNext(head);
            model.setPrev(head.getPrev());
            head.getPrev().setNext(model);
            head.setPrev(model);
        }
        size = models.length;
    }

    public LocalDateTime getLastModifed() {
        return lastModifed;
    }

    public String getMark() {
        return bikeMark;
    }

    public void setMark(String newName) {
        bikeMark = newName;
    }

    private void createModelList(int size) {
        Model model;
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            model = new Model("Name: " + i, 1000 + (1000000 - 1000) * rnd.nextDouble());
            model.setNext(head);
            model.setPrev(head.getPrev());
            head.getPrev().setNext(model);
            head.setPrev(model);
        }
        lastModifed = LocalDateTime.now();
    }

    private Model findByName(String name) {
        Model temp = head.getNext();
        if (head != null) {
            while (temp != head && !(temp.getModelName().equals(name))) {
                temp = temp.getNext();
            }
            if (temp == head) {
                temp = null;
            }
        }
        return temp;
    }

    public void editModelName(String oldName, String newName)
            throws NoSuchModelNameException, DuplicateModelNameException {
        Model temp = head.getNext();
        Model tempModel = null;
        while (temp != head) {
            if (temp.getModelName().equals(newName)) {
                throw new DuplicateModelNameException("Не уникальное название");
            }
            if (temp.getModelName().equals(oldName)) {
                tempModel = temp;
            }
            temp = temp.getNext();
        }
        if (tempModel == null) {
            throw new NoSuchModelNameException("Такой модели нет");
        } else {
            tempModel.setModelName(newName);
            lastModifed = LocalDateTime.now();
        }
    }

    public String[] getAllModelNames() {
        String[] names = new String[size];
        Model temp = head.getNext();
        int ind = 0;
        if (head != null) {
            while (temp != head) {
                names[ind] = temp.getModelName();
                temp = temp.getNext();
                ind++;
            }
        }
        return names;
    }

    public double getPriceByName(String name) throws NoSuchModelNameException {
        Model temp = findByName(name);
        if (temp == null) {
            throw new NoSuchModelNameException("Такой модели нет");
        }
        return temp.getPrice();
    }

    public double[] getAllModelPrices() {
        double[] prices = new double[size];
        Model temp = head.getNext();
        int ind = 0;
        if (head != null) {
            while (temp != head) {
                prices[ind] = temp.getPrice();
                temp = temp.getNext();
                ind++;
            }
        }
        return prices;
    }

    public void setPriceByName(String name, double newPrice) throws NoSuchModelNameException {
        if (newPrice < 0) {
            throw new ModelPriceOutOfBoundsException("Неверная цена модели");
        }
        Model temp = findByName(name);
        if (temp == null) {
            throw new NoSuchModelNameException("Такой модели нет");
        }
        temp.setPrice(newPrice);
        lastModifed = LocalDateTime.now();
    }

    public void modelAdd(String newName, double newPrice) throws DuplicateModelNameException {
        if (newPrice < 0) {
            throw new ModelPriceOutOfBoundsException("Неверная цена модели");
        }
        if (findByName(newName) != null) {
            throw new DuplicateModelNameException("Модель c таким названием уже есть");
        }

        Model model = new Model(newName, newPrice);
        model.setNext(head);
        model.setPrev(head.getPrev());
        head.getPrev().setNext(model);
        head.setPrev(model);
        size++;
        lastModifed = LocalDateTime.now();
    }

    public void deleteModelByName(String name) throws NoSuchModelNameException {
        Model delModel = findByName(name);
        if (delModel == null || delModel == head) {
            throw new NoSuchModelNameException("Такой модели нет");
        }
        if (delModel != null && delModel != head) {
            delModel.getPrev().setNext(delModel.getNext());
            delModel.getNext().setPrev(delModel.getPrev());
        }
        lastModifed = LocalDateTime.now();
        size--;
        delModel = null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(bikeMark + "\n");
        Model temp = head.getNext();
        while (temp != head) {
            strBuffer.append(temp.getModelName()+ " Price: " + temp.getPrice() + "\n");
            temp = temp.getNext();
        }
        return strBuffer.toString();
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Motorbike) || obj == null){
            return false;
        }
        if(this== obj){
            return true;
        }
        Motorbike veh = (Motorbike)obj;
        if(!(veh.getMark().equals(bikeMark))){
            return false;
        }
        String[] vehModels = veh.getAllModelNames();
        double[] vehPrices = veh.getAllModelPrices();
        int i = 0;
        Model temp = head.getNext();
        if(vehModels.length != size){
            return false;
        }
        while (temp != head) {
            if(!(vehModels[i].equals(temp.getModelName()))||
            vehPrices[i] != temp.getPrice()){
                return false;
            }
            i++;
            temp = temp.getNext();
        }
        return true;
    }
    @Override
    public int hashCode(){
        int res = bikeMark.hashCode();
        Model temp = head.getNext();
        while(temp != head){
            res+=45481 * (temp.hashCode() + (int)temp.getPrice());
            temp = temp.getNext();
        }
        return res;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Motorbike clone = (Motorbike)super.clone();
        clone.head = new Model();
        clone.head.setNext(clone.head);
        clone.head.setPrev(clone.head);
        Model temp = head.getNext();
        Model cloneTemp = clone.head.getNext();
        while(temp != head){
            Model newModel = new Model(temp.getModelName(), temp.getPrice());
            newModel.setNext(clone.head);
            newModel.setPrev(clone.head.getPrev());
            clone.head.getPrev().setNext(newModel);
            clone.head.setPrev(newModel);
            temp = temp.getNext();
            cloneTemp = cloneTemp.getNext();
        }
        return clone;
    }


    private class Model implements Serializable {
        private String modelName = null;
        private Double price = Double.NaN;
        Model prev = null;
        Model next = null;

        public Model() {
        }

        public Model(String name, double pr) {
            modelName = name;
            price = pr;
        }

        public void setModelName(String name) {
            modelName = name;
        }

        public String getModelName() {
            return modelName;
        }

        public void setPrice(double p) {
            price = p;
        }

        public double getPrice() {
            return price;
        }

        public void setNext(Model n) {
            next = n;
        }

        public Model getNext() {
            return next;
        }

        public void setPrev(Model p) {
            prev = p;
        }

        public Model getPrev() {
            return prev;
        }
    }
}
