import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Matrix implements Serializable{
    private double[][] matrix;

    public Matrix(int x, int y){
        matrix = new double[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                matrix[i][j] = Math.ceil(ThreadLocalRandom.current().nextDouble(0,101) * 100) / 100;
            }
        }
    }

    public int[] getSize(){
        return new int[] {matrix.length, matrix[0].length};
    }

    public double getElement(int x, int y){
        return matrix[x][y];
    }

    public void setElement(int x, int y, int value){
        matrix[x][y] = value;
    }

    public void printMatrix(){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double getOddSum(Matrix matrix){
        double sum = 0;
        int[] size = matrix.getSize();
        for(int i = 0; i < size[0]; i++){
            for(int j = 0; j < size[1]; j++){
                if(Math.ceil(matrix.getElement(i, j)) % 2 != 0){
                    sum+=matrix.getElement(i, j);
                }
            }
        }
        return sum;
    }

    @Override
    public String toString(){
        StringBuilder mat = new StringBuilder();
        mat.append("<html>");
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                mat.append(matrix[i][j] + " ");
            }
            mat.append("<br>");
        }
        return mat.toString();
    }
}
