package zyh.data.main;

public class Thread1 {


    static class work implements Runnable{
        public void run(){
            System.out.println("run");
        }
    }
    
    public static void main(String[] args) {
        work w = new work();
        Thread  t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("run");
            }
        });
        t1.run();

    }
}
