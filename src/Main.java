public class Main {
    static int balance = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = Main::deposit;

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("Balance = "+balance);
    }

    public synchronized static void deposit() {
        System.out.println(Thread.currentThread().getName()+" in");
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        balance+=100;
        System.out.println(Thread.currentThread().getName()+" out");

    }
}