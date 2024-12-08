package Vehicle;
import Exceptions.DuplicateModelNameException;
import Exceptions.NoSuchModelNameException;

public interface Vehicle extends java.io.Serializable, Cloneable {
    public void editModelName(String oldName,String newName) throws NoSuchModelNameException, DuplicateModelNameException;
    public double getPriceByName(String name) throws NoSuchModelNameException;
    public void setPriceByName(String name, double newPrice) throws NoSuchModelNameException;
    public String[] getAllModelNames();
    public double[] getAllModelPrices();
    public void modelAdd(String newName, double newPrice) throws DuplicateModelNameException;
    public void deleteModelByName(String name) throws NoSuchModelNameException;
    public int getSize();
    public String getMark();
    public void setMark(String newName);
}
