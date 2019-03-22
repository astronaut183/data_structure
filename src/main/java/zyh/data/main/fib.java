package zyh.data.main;

import java.util.ArrayList;

public class fib {

    public static int fiber(int a){
        if(a==0)    return 0;
        if(a==1)    return 1;

        return fiber(a-1)+fiber(a-2);
    }
    public static void main(String[] args) {
        int a = fiber(1);
        System.out.println(a);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.remove(arr.size()-1);
    }
}
