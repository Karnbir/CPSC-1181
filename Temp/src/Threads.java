public class Threads {
    static int count = 420;
    static class myRunnable1 implements Runnable{
        public void run() {
            try {
                for (int i = 0; i < count; i++) {
                    System.out.println("0 ");
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("Interuption caught");
            }
        }
    }

    static class myRunnable2 implements Runnable {
        public void run() {
            try {
                for (int i = 0; i < count; i++) {
                    System.out.println("1 ");
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("Caught Interupt");
            }
        }
    }
    public static void main (String [] args) {
        Runnable r1 = new myRunnable1();
        Runnable r2 = new myRunnable2();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t2.start();
        t1.start();
        }

    }
