public class assignment_Q3 {
    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int i = 0;

        // Ascending phase
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak should not be the first or last element
        if (i == 0 || i == arr.length - 1) {
            return false;
        }

        // Descending phase
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == arr.length - 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1};
        boolean result = validMountainArray(arr);
        System.out.println(result); // Output: false
    }
}
