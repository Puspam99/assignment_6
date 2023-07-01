import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class assignment_Q6 {
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0]; // If the length is odd, it cannot be a doubled array
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : changed) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> originalList = new ArrayList<>();
        for (int num : changed) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                if (num == 0) {
                    // Special handling for 0 since we need at least two 0s
                    if (countMap.get(num) < 2) {
                        return new int[0];
                    }
                    originalList.add(num);
                    countMap.put(num, countMap.get(num) - 2);
                } else {
                    if (countMap.containsKey(num * 2) && countMap.get(num * 2) > 0) {
                        originalList.add(num);
                        countMap.put(num, countMap.get(num) - 1);
                        countMap.put(num * 2, countMap.get(num * 2) - 1);
                    } else {
                        return new int[0]; // If the half value is not present, it cannot be a doubled array
                    }
                }
            }
        }

        int[] originalArray = new int[originalList.size()];
        for (int i = 0; i < originalList.size(); i++) {
            originalArray[i] = originalList.get(i);
        }

        return originalArray;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] original = findOriginalArray(changed);
        for (int num : original) {
            System.out.print(num + " "); // Output: 1 3 4
        }
    }
}
