package zyh.data.main;

import static sun.swing.MenuItemLayoutHelper.max;

public class Backpack {
    private int[][] memo;

    /**
     * @param w
     * @param v
     * @param size
     * @return
     */
    public int recursiveBackpack1(int[] w, int[] v, int size) {
        if (w.length != v.length) return -1;
        int n = w.length;
        return bestValue1(w, v, n - 1, size);
    }

    private int bestValue1(int[] w, int[] v, int index, int size) {
        if (index < 0 || size <= 0) return 0;

        int res = bestValue1(w, v, index - 1, size);
        if (size >= w[index]) {
            res = max(v[index] + bestValue1(w, v, index - 1, size - w[index]), res);
        }
        return res;
    }

    /**
     * @param w
     * @param v
     * @param size
     * @return
     */
    public int recursiveBackpack2(int[] w, int[] v, int size) {
        if (w.length != v.length) return -1;

        int n = w.length;
        memo = new int[n][size + 1];
        return bestValue2(w, v, n - 1, size);
    }

    private int bestValue2(int[] w, int[] v, int index, int size) {
        if (index < 0 || size <= 0) return 0;
        if (memo[index][size] != 0) {
            return memo[index][size];
        }
        int res = bestValue1(w, v, index - 1, size);
        if (size >= w[index]) {
            res = max(v[index] + bestValue1(w, v, index - 1, size - w[index]), res);
        }
        memo[index][size] = res;
        return res;
    }


    public int backpack(int[] w, int[] v, int size) {
        if (w.length != v.length) return -1;

        int n = w.length;
        if (n == 0) return 0;
        int[][] memo1 = new int[n][size + 1];

        for (int i = 0; i <= size; i++) {
            memo1[0][i] = (i >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= size; j++) {
                memo1[i][j] = memo1[i - 1][j];
                if (j >= w[i]) {
                    memo1[i][j] = max(memo1[i][j], v[i] + memo1[i - 1][j - w[i]]);
                }
            }
        }
        return memo1[n - 1][size];
    }
}

