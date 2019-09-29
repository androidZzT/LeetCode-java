package thread;

public class EvenOddZero {

    int n;
    boolean[] flags;

    public EvenOddZero(int n) {
        this.n = n;
        this.flags = new boolean[]{true, false, false};
    }

    public static void main(String args[]) {
        EvenOddZero evenOddZero = new EvenOddZero(100);
        Thread A = new Thread(new OddRunnable(evenOddZero));
        Thread B = new Thread(new EvenRunnable(evenOddZero));
        Thread C = new Thread(new ZeroRunnable(evenOddZero));

        C.start();
        A.start();
        B.start();
    }
}
