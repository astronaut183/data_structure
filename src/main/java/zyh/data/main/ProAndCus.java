package zyh.data.main;

import java.util.ArrayList;

public class ProAndCus {

    static class Box {
        static ArrayList<Apple> list = new ArrayList<>();
        static int capacity = 50;


        public void put(Apple apple) {
            synchronized (this) {
                while (list.size() >= capacity) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(apple);
                notifyAll();
                System.out.println("Add success! sizes is " + list.size());
            }
        }

        public Apple get() {
            Apple apple = null;
            synchronized (this) {
                while (list.size() <= 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                apple = list.remove(list.size() - 1);
                notifyAll();
                System.out.println("Get finished! sizes is " + list.size());
            }
            return apple;
        }
    }

    static class Apple {
        private String name = "apple";
    }

    static class producer {
        private Box box;

        public producer(Box box) {
            this.box = box;
        }

        public void put() {
            Apple apple = new Apple();
            box.put(apple);
        }
    }

    static class customer {
        private Box box;

        public customer(Box box) {
            this.box = box;
        }

        public Apple get() {
            return box.get();
        }
    }

    public static void main(String[] args) {
        Box box = new Box();
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    producer pro = new producer(box);
                    pro.put();
                }
            }).start();
        }
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    customer cus = new customer(box);
                    cus.get();
                }
            }).start();
        }

        String str = "abccc";
        char a = str.charAt(2);
        char b = str.charAt(0);
        String sub = a + b + "";
    }
}
