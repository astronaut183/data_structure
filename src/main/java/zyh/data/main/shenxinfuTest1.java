package zyh.data.main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class shenxinfuTest1 {
    public static int findNum(int[] num1, int[] num2) {
        Set<Integer> set = new HashSet<>();
        for(int i :num2){
            set.add(i);
        }
        for(int j:num1){
            if(!set.contains(j)){
                return j;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num1 = new int[n];
        int[] num2 = new int[n - 1];
        int i = 0;
        while (i < n) {
            num1[i++] = scanner.nextInt();
        }
        i = 0;
        while (i < n - 1) {
            num2[i++] = scanner.nextInt();
        }

        System.out.println(findNum(num1, num2));
    }
}
