public class Threads {

    public static void main (String [] args) {
        class  runnable1 implements Runnable {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hi");
                }
            }
        }

        class runnable2 implements Runnable {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Andrew");
                }
            }
        }

        Runnable r1 = new runnable1();
        Runnable r2 = new runnable2();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

    }
}
