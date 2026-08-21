import java.util.*;

class Solution {

    private long lcm(long a, long b, long limit) {
        long g = gcd(a, b);

        if (a / g > limit / b) {
            return limit + 1;
        }

        return (a / g) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long count(long x, int[] coins) {
        int n = coins.length;
        long result = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long currentLcm = 1;
            int bits = 0;
            boolean tooLarge = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    currentLcm = lcm(currentLcm, coins[i], x);

                    if (currentLcm > x) {
                        tooLarge = true;
                        break;
                    }
                }
            }

            if (tooLarge) {
                continue;
            }

            long ways = x / currentLcm;

            if ((bits & 1) == 1) {
                result += ways;
            } else {
                result -= ways;
            }
        }

        return result;
    }

    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);

        int[] temp = new int[coins.length];
        int n = 0;

        for (int coin : coins) {
            boolean redundant = false;

            for (int i = 0; i < n; i++) {
                if (coin % temp[i] == 0) {
                    redundant = true;
                    break;
                }
            }

            if (!redundant) {
                temp[n++] = coin;
            }
        }

        int[] filtered = Arrays.copyOf(temp, n);

        long low = 1;
        long high = (long) filtered[0] * k;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, filtered) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
