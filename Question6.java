import java.util.*;

public class Question6 {


    public static void graph(String input){
            if (input == null) {
                return;
            }

            input = input.replaceAll("[\\[\\]{}()|| ]", "").trim();


           String[] parts = input.split("\\s*,\\s*(?=[a-z A-Z]\\s*,)");

            int n = parts.length;
            int[][] matrix = new int[n][n];
            String[] vertices = new String[n];
            int[] jumps = new int[n];


            for (int i = 0; i < n; i++) {

                String[] pair = parts[i].split(",");

                vertices[i] = pair[0].trim();
                jumps[i] = Integer.parseInt(pair[1].trim());
            }


            for (int i = 0; i < n; i++) {

                int left = (i - jumps[i] + n) % n;
                int right = (i + jumps[i]) % n;

                matrix[i][left] = 1;
                matrix[i][right] = 1;
            }

            System.out.print("   ");

        for (int i = 0; i < vertices.length; i++) {
            System.out.print(vertices[i] + " ");
        }
            System.out.println();

            for (int i = 0; i < n; i++) {

                System.out.print(vertices[i] + "| ");

                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }

                System.out.println();
            }

        }


    public static void main(String[] args) {

        System.out.println("Question 6: ");
        System.out.println();

        String input = "[(I,2),(A,5),(E,4),(F,2),(T,2),(S,3)]";


        System.out.println("INPUT: " + input);

        System.out.println("__________________________________");

        System.out.println("OUTPUT: ");

        graph(input);
    }


}
