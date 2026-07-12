import java.util.*;

class Solution {
    private static final Map<Integer, Integer> computed = new HashMap<>();

    private int getFactorial(int n) {
        if (computed.containsKey(n)) {
            return computed.get(n);
        }

        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            computed.put(i, factorial);
        }
        return factorial;
    }

    private void permuteInplace(List<Integer> values, int s, int k) {
        int n = values.size();

        if (s == n - 1) {
            return;
        }

        if (s == n - 2) {
            if (k == 1) {
                Collections.swap(values, n - 2, n - 1);
            }
            return;
        }

        int numFactorialsRightSide = getFactorial(n - (s + 1));
        k %= getFactorial(n);

        if (k < numFactorialsRightSide) {
            permuteInplace(values, s + 1, k);
            return;
        }

        int count = k / numFactorialsRightSide;
        Collections.swap(values, s, s + count);

        // Sort the suffix
        Collections.sort(values.subList(s + 1, n));

        k %= numFactorialsRightSide;
        permuteInplace(values, s + 1, k);
    }

    public String getPermutation(int n, int k) {
        k--;

        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            values.add(i);
        }

        permuteInplace(values, 0, k);

        StringBuilder sb = new StringBuilder();
        for (int num : values) {
            sb.append(num);
        }

        return sb.toString();
    }
}
