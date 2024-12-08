package MyTransport;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;
// ⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀ ⣀⣀⣤⣤⣤⣀⡀
// ⠸⡇⠀⠿⡀⠀⠀⠀⣀⡴⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀
// ⠀⠀⠀⠀⠑⢄⣠⠾⠁⣀⣄⡈⠙⣿⣿⣿⣿⣿⣿⣿⣿⣆
// ⠀⠀⠀⠀⢀⡀⠁⠀⠀⠈⠙⠛⠂⠈⣿⣿⣿⣿⣿⠿⡿⢿⣆
// ⠀⠀⠀⢀⡾⣁⣀⠀⠴⠂⠙⣗⡀⠀⢻⣿⣿⠭⢤⣴⣦⣤⣹⠀⠀⠀⢀⢴⣶⣆
// ⠀⠀⢀⣾⣿⣿⣿⣷⣮⣽⣾⣿⣥⣴⣿⣿⡿⢂⠔⢚⡿⢿⣿⣦⣴⣾⠸⣼⡿
// ⠀⢀⡞⠁⠙⠻⠿⠟⠉⠀⠛⢹⣿⣿⣿⣿⣿⣌⢤⣼⣿⣾⣿⡟⠉
// ⠀⣾⣷⣶⠇⠀⠀⣤⣄⣀⡀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇
// ⠀⠉⠈⠉⠀⠀⢦⡈⢻⣿⣿⣿⣶⣶⣶⣶⣤⣽⡹⣿⣿⣿⣿⡇
// ⠀⠀⠀⠀⠀⠀⠀⠉⠲⣽⡻⢿⣿⣿⣿⣿⣿⣿⣷⣜⣿⣿⣿⡇
// ⠀⠀ ⠀⠀⠀⠀⠀⢸⣿⣿⣷⣶⣮⣭⣽⣿⣿⣿⣿⣿⣿⣿⠇
// ⠀⠀⠀⠀⠀⠀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇
// ⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿

import Exceptions.DuplicateModelNameException;
import Exceptions.ModelPriceOutOfBoundsException;
import Exceptions.NoSuchModelNameException;
import Vehicle.Vehicle;


public class Car implements Vehicle {
    private String carMark;
    private CarModel[] carModels;

    public Car(String mark, int modelCount) {
        carMark = mark;
        carModels = new CarModel[modelCount];
        Random rnd = new Random();
        for (int i = 0; i < modelCount; i++) {
            carModels[i] = new CarModel("Name:" + i, 1000 + (1000000 - 1000) * rnd.nextDouble());
        }
    }

    public Car(String mark, String[] models, double[] prices) {
        carMark = mark;
        carModels = new CarModel[models.length];
        for (int i = 0; i < models.length; i++) {
            carModels[i] = new CarModel(models[i], prices[i]);
        }
    }

    public String getMark() {
        return carMark;
    }

    public void setMark(String newName) {
        carMark = newName;
    }

    public int getSize() {
        return carModels.length;
    }

    public void editModelName(String oldName, String newName)
            throws NoSuchModelNameException, DuplicateModelNameException {
        int ind = 0;
        int intModele = -1;
        while (ind != carModels.length) {
            if (carModels[ind].getModelName().equals(newName)) {
                throw new DuplicateModelNameException("Новое имя не уникально");
            }
            if (carModels[ind].getModelName().equals(oldName)) {
                intModele = ind;
            }
            ind++;
        }
        if (intModele == -1) {
            throw new NoSuchModelNameException("Модель не найдена");
        } else {
            carModels[intModele].setModelName(newName);
        }
    }
    
    public double getPriceByName(String name) throws NoSuchModelNameException {
        int ind = 0;
        while (ind != carModels.length && !(carModels[ind].getModelName().equals(name))) {
            ind++;
        }
        if (ind == carModels.length) {
            throw new NoSuchModelNameException("Модель не найдена");
        }
        return carModels[ind].getPrice();
    }

    public String[] getAllModelNames() {
        String[] allModels = new String[carModels.length];
        for (int i = 0; i < carModels.length; i++) {
            allModels[i] = carModels[i].getModelName();
        }
        return allModels;
    }

    public double[] getAllModelPrices() {
        double[] allPrice = new double[carModels.length];
        for (int i = 0; i < carModels.length; i++) {
            allPrice[i] = carModels[i].getPrice();
        }
        return allPrice;
    }

    public void modelAdd(String newName, double newPrice) throws DuplicateModelNameException {
        if (newPrice < 0) {
            throw new ModelPriceOutOfBoundsException("Неверная цена модели");
        }
        for (int i = 0; i < carModels.length; i++) {
            if (carModels[i].getModelName().equals(newName)) {
                throw new DuplicateModelNameException("Имя модели не уникальное");
            }
        }
        carModels = Arrays.copyOf(carModels, carModels.length + 1);
        carModels[carModels.length - 1] = new CarModel(newName, newPrice);
    }

    public void deleteModelByName(String name) throws NoSuchModelNameException {
        int ind = 0;
        while (ind != carModels.length && !(carModels[ind].getModelName().equals(name))) {
            ind++;
        }
        if (ind == carModels.length) {
            throw new NoSuchModelNameException("Модель не найдена");
        }
        System.arraycopy(carModels, ind + 1, carModels, ind, carModels.length - ind - 1);
        carModels = Arrays.copyOf(carModels, carModels.length - 1);
    }

    public void setPriceByName(String name, double newPrice) throws NoSuchModelNameException {
        int ind = 0;
        if (newPrice < 0) {
            throw new ModelPriceOutOfBoundsException("Неверная цена");
        }
        while (ind != carModels.length && !(carModels[ind].getModelName().equals(name))) {
            ind++;
        }
        if (ind == carModels.length) {
            throw new NoSuchModelNameException("Модель не найдена");
        }
        carModels[ind].setPrice(newPrice);
    }

    @Override
    public String toString() {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(carMark + "\n");
        for (int i = 0; i < carModels.length; i++) {
            strBuffer.append(carModels[i].getModelName() + " Price:  " + carModels[i].getPrice() + "\n");
        }
        return strBuffer.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car) || obj == null) {
            return false;
        }//this
        if(this == obj){
            return true;
        }
        Car veh = (Car) obj;
        if (!(veh.getMark().equals(carMark))) {
            return false;
        }
        if (veh.getSize() != carModels.length) {
            return false;
        }
        String[] vehModels = veh.getAllModelNames();
        double[] vehPrices = veh.getAllModelPrices();
       
        for (int i = 0; i < carModels.length; i++) {
            if (!(vehModels[i].equals(carModels[i].getModelName())) ||
                    (vehPrices[i] != carModels[i].getPrice())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 77761*(carMark.hashCode() + Arrays.hashCode(carModels));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Car clone = (Car)super.clone();
        clone.carModels = new CarModel[carModels.length];
        for (int i = 0; i < carModels.length; i++) {
            clone.carModels[i] = new CarModel(carModels[i].getModelName(), carModels[i].getPrice());
        }
        return clone;
    }

    private class CarModel implements Serializable {
        private String modelName = "";
        private double price;

        public CarModel(String modName, double pr) {
            modelName = modName;
            price = pr;
        }

        public void setModelName(String value) {
            modelName = value;
        }

        public String getModelName() {
            return modelName;
        }

        public void setPrice(double value) {
            price = value;
        }

        public double getPrice() {
            return price;
        }
    }
}
