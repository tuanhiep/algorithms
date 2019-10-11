package tuanhiep.usa.algo.euler;

public class MaximumPathSum_18 {
    public static void main(String[] args) {
        String test = "3 " +
                "7 4 " +
                "2 4 6 " +
                "8 5 9 3";
        System.out.println(findMax(test, 4));


        String s = "75 " +
                "95 64 " +
                "17 47 82 " +
                "18 35 87 10 " +
                "20 04 82 47 65 " +
                "19 01 23 75 03 34 " +
                "88 02 77 73 07 63 67 " +
                "99 65 04 28 06 16 70 92 " +
                "41 41 26 56 83 40 80 70 33 " +
                "41 48 72 33 47 32 37 16 94 29 " +
                "53 71 44 65 25 43 91 52 97 51 14 " +
                "70 11 33 28 77 73 17 78 39 68 17 57 " +
                "91 71 52 38 17 14 91 43 58 50 27 29 48 " +
                "63 66 04 68 89 53 67 30 73 16 69 87 40 31 " +
                "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 ";

        System.out.println(findMax(s, 15));
    }

    public static long findMax(String s, int size) {
        String[] input = s.split("\\s+");
        int[][] matrix = new int[size][size];
        int index = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < row + 1; col++) {
                matrix[row][col] = Integer.parseInt(input[index]);
                index++;
            }
        }
        return findMax(matrix);

    }

    private static long findMax(int[][] matrix) {
        int[][] max = matrix.clone();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row + 1; col++) {
                int firstParent = 0, secondParent = 0;
                if (row - 1 >= 0) {
                    firstParent = max[row - 1][col];
                }
                if (col - 1 >= 0) {
                    secondParent = max[row - 1][col - 1];
                }

                max[row][col] = Math.max(firstParent + max[row][col], secondParent + max[row][col]);

            }
        }

        int maxSumPath = 0;

        for (int col = 0; col < max[0].length; col++) {
            maxSumPath = Math.max(maxSumPath, max[max.length - 1][col]);

        }
        return maxSumPath;


    }


}
