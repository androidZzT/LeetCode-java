package thread;

public class ZeroRunnable implements Runnable {

    private EvenOddZero target;

    public ZeroRunnable(EvenOddZero target) {
        this.target = target;
    }

    @Override
    public void run() {
        int i = 0;
        synchronized (target) {
            while (i < target.n) {
                if (target.flags[0]) {
                    System.out.println(0);
                    i++;
                    target.flags[0] = false;
                    target.flags[1] = true;
                    target.flags[2] = false;
                    target.notifyAll();
                } else {
                    try {
                        target.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
