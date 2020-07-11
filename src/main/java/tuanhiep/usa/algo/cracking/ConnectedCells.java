package tuanhiep.usa.algo.cracking;

public class ConnectedCells {
    public static void main(String[] args) {

    }

    /**
     * Get the biggest region contains 1 in matrix of value 0 and 1
     *
     * @param matrix
     * @return
     */
    public static int getBiggestRegion(int[][] matrix) {
        int biggestSize = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] == 1) {
                    int size = getRegion(matrix, row, column);
                    biggestSize = Math.max(biggestSize, size);
                }
            }
        }
        return biggestSize;
    }

    /**
     * Get the size of region which contains 1 in matrix using DFS
     *
     * @param matrix
     * @param row
     * @param column
     * @return
     */
    private static int getRegion(int[][] matrix, int row, int column) {
        if (row < 0 || column < 0 || row > matrix.length || column > matrix[row].length) {
            return 0;
        }
        if (matrix[row][column] == 0) {
            return 0;
        }
        int sizeRegion = 1;
        for (int i = row - 1; i < row + 1; i++) {
            for (int j = column - 1; j < column + 1; j++) {
                if ((i != row || j != column) && matrix[i][j] == 1) {
                    // clear the checked slot to not check it again
                    matrix[i][j] = 2;
                    sizeRegion += getRegion(matrix, i, j);
                }
            }
        }
        return sizeRegion;
    }


}
