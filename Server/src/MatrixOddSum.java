public class MatrixOddSum {
    public static int getOddSum(Matrix matrix){
        int sum = 0;
        int[] size = matrix.getSize();
        for(int i = 0; i < size[0]; i++){
            for(int j = 0; j < size[1]; j++){
                if(matrix.getElement(i, j) % 2 != 0){
                    sum+=matrix.getElement(i, j);
                }
            }
        }
        return sum;
    }
}
