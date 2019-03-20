package zyh.data.main;

public class AddBigInt {

    public static void addBigInt(StringBuilder num1, StringBuilder num2, int pos,
                                 boolean isCarry, StringBuilder result) {
        if (pos < num1.length() || pos < num2.length()) {
            int val = 0;
            if (isCarry) val++;
            char temp1 = pos < num1.length() ? num1.charAt(pos) : '0';
            char temp2 = pos < num2.length() ? num2.charAt(pos) : '0';
            val += add(temp1, temp2);
            if (val >= 10) {
                isCarry = true;
                val -= 10;
            } else {
                isCarry = false;
            }
            result.append(val);
            addBigInt(num1, num2, ++pos, isCarry, result);
        } else {
            if (isCarry) {
                result.append("1");
            }
        }
    }

    public static String addBigInt(StringBuilder num1, StringBuilder num2) {
        StringBuilder res = new StringBuilder("");
        num1.reverse();
        num2.reverse();
        addBigInt(num1, num2, 0, false, res);
        res.reverse();
        return res.toString();
    }

    public static int add(char num1, char num2) {
        return Integer.parseInt(String.valueOf(num1))
                + Integer.parseInt(String.valueOf(num2));
    }


    public static void main(String[] args) {
        StringBuilder num1 = new StringBuilder("12345678977777");
        StringBuilder num2 = new StringBuilder("456789456123456789");
        System.out.println(addBigInt(num1, num2));

        int a=1;
        int b=0;

        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a+"  "+b);
    }
}
