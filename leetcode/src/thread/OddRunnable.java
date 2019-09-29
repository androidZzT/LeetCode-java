package thread;

public class OddRunnable implements Runnable {

    private EvenOddZero target;

    public OddRunnable(EvenOddZero target) {
        this.target = target;
    }

    @Override
    public void run() {
        int i = 1;
        synchronized (target) {
            while (i < target.n) {
                if (target.flags[1]) {
                    System.out.println(i);
                    i += 2;
                    target.flags[0] = false;
                    target.flags[1] = false;
                    target.flags[2] = true;
                    target.notify();
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
