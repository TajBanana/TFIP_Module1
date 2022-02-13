public class TestRunnable implements Runnable{
    private int threadNumber;

    public TestRunnable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for(int i = 0; i <=5 ; i++) {
            System.out.println(i + " from thread " + threadNumber);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
