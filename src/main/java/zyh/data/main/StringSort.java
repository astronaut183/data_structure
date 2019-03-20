package zyh.data.main;

public class StringSort {

    public static void test(char[] chars, int from, int to) {
        if (to <= 0) {
            return;
        } else if (from == to) {
            System.out.println(chars);
        } else {
            for (int x = from; x <= to; x++) {
                if (x == from) {
                    swap(chars, x, from);
                    test(chars, from + 1, to);
                    swap(chars, x, from);
                } else {
                    if (chars[x] != chars[from]) {
                        swap(chars, x, from);
                        test(chars, from + 1, to);
                        swap(chars, x, from);
                    }
                }
            }
        }

    }

    public static void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        char[] car = str.toCharArray();
        test(car, 0, car.length - 1);
    }
}
