package thread;

public class EvenRunnable implements Runnable {

    private EvenOddZero target;

    public EvenRunnable(EvenOddZero target) {
        this.target = target;
    }

    @Override
    public void run() {
        int i = 2;
        synchronized (target) {
            while (i < target.n) {
                if (target.flags[2]) {
                    System.out.println(i);
                    i += 2;
                    target.flags[0] = true;
                    target.flags[1] = false;
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
