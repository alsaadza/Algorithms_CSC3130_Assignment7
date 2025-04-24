public class Question4 {

    public static boolean question4(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {

                if (matrix[i][j] != matrix[j][i]) {

                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("Directed or undirected checker: ");

        System.out.println();

        int[][] input = {
                {0, 1, 0},
                {1, 0, 1},
                {0, 0, 1}
        };
        System.out.println("Test 1 - Is the matrix representing a directed graph? : " + question4(input)); //this should return true

        System.out.println("---------------------------------------------------");

        int[][] input2 = {
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };

        System.out.println("Test 2 - Is the matrix representing a directed graph? : " + question4(input2)); //this should return false


        System.out.println("---------------------------------------------------");


        int[][] input3 = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };

        System.out.println("Test 3 - Is the matrix representing a directed graph? : " + question4(input3)); //this should return false






    }
}