package thread;

import java.util.ArrayList;
import java.util.List;

public class Plate {

    private List<String> plate = new ArrayList<>();
    private Object lock = new Object();

    public void put(String fruit) {
        synchronized (lock) {
            try {
                if (!plate.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " is waiting");
                    lock.wait();
                } else {
                    plate.add(fruit);
                    System.out.println(Thread.currentThread().getName() + " put a " + fruit);
                    System.out.println("plate has " + plate.toString());
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getFruit(Object who) {
        synchronized (lock) {
            try {
                if (plate.size() == 0) {
                    lock.wait();
                } else {
                    String fruit = plate.get(0);
                    switch (fruit) {
                        case "Apple":
                            if (who instanceof Daughter) {
                                try {
                                    return plate.remove(0);
                                } finally {
                                    lock.notifyAll();
                                }
                            } else {
                                lock.wait();
                            }
                            break;
                        case "Orange":
                            if (who instanceof Son) {
                                try {
                                    return plate.remove(0);
                                } finally {
                                    lock.notifyAll();
                                }
                            } else {
                                lock.wait();
                            }
                            break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Plate plate = new Plate();
        new Father(plate).start();
        new Mother(plate).start();
        new Son(plate).start();
        new Daughter(plate).start();
    }

    static class Father extends Thread {

        Plate plate;

        public Father(Plate plate) {
            setName("father");
            this.plate = plate;
        }

        @Override
        public void run() {
            while(true) {
                plate.put("Apple");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Mother extends Thread {
        Plate plate;

        public Mother(Plate plate) {
            setName("mother");
            this.plate = plate;
        }

        @Override
        public void run() {
            while(true) {
                plate.put("Orange");
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Son extends Thread {

        Plate plate;

        public Son(Plate plate) {
            setName("son");
            this.plate = plate;
        }

        @Override
        public void run() {
            while (true) {
                String fruit = plate.getFruit(this);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (fruit != null) System.out.println("son got a " + fruit);
            }
        }
    }

    static class Daughter extends Thread {
        Plate plate;

        public Daughter(Plate plate) {
            setName("daughter");
            this.plate = plate;
        }

        @Override
        public void run() {
            while (true) {
                String fruit = plate.getFruit(this);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (fruit != null) System.out.println("daughter got a " + fruit);
            }
        }
    }

}
