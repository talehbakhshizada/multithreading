public class Account {
    Integer balance = 100;
    static Account account = new Account();

    public static void main(String[] args) throws Exception {
        Runnable runnable1 = () -> account.test();
        Runnable runnable2 = () -> account.test();
        Runnable runnable3 = () -> account.test();
        Runnable runnable4 = () -> account.test();

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);
        Thread thread4 = new Thread(runnable4);

        thread1.start();
        thread2.start();
        thread3.start();
        //Thread.sleep(2000L);
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

    }

    public void test() {
        System.out.println(Thread.currentThread().getName());
    }

}
