import java.util.Arrays;

public class assignment_Q1 {

    public static int[] reconstructPermutation(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        int smallest = 0;
        int largest = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = smallest;
                smallest++;
            } else {
                perm[i] = largest;
                largest--;
            }
        }

        // Add the remaining number (either smallest or largest) to the last position
        perm[n] = smallest;

        return perm;
    }

    public static void main(String[] args) {
        String s = "IDID";
        int[] result = reconstructPermutation(s);
        System.out.println(Arrays.toString(result)); // Output: [0, 4, 1, 3, 2]
    }
}
