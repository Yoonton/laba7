import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class Matrix implements Serializable{
    private int[][] matrix;

    public Matrix(int x, int y){
        matrix = new int[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                matrix[i][j] = ThreadLocalRandom.current().nextInt(0,101);
            }
        }
    }

    public int[] getSize(){
        return new int[] {matrix.length, matrix[0].length};
    }

    public int getElement(int x, int y){
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
}
