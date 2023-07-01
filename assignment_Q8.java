import java.util.HashMap;
import java.util.Map;

public class assignment_Q8 {
    public static int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        int[][] result = new int[m][n];

        // Create sparse representation for mat2
        Map<Integer, Map<Integer, Integer>> sparseMat2 = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sparseMat2.put(i, new HashMap<>());
            for (int j = 0; j < n; j++) {
                if (mat2[i][j] != 0) {
                    sparseMat2.get(i).put(j, mat2[i][j]);
                }
            }
        }

        // Perform matrix multiplication
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int p = 0; p < k; p++) {
                    if (mat1[i][p] != 0 && sparseMat2.containsKey(p) && sparseMat2.get(p).containsKey(j)) {
                        sum += mat1[i][p] * sparseMat2.get(p).get(j);
                    }
                }
                result[i][j] = sum;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 0}, {-1, 0, 3}};
        int[][] mat2 = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] result = multiply(mat1, mat2);
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
