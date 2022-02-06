package task1;

import static task1.Main.tumbler;

public class Toys implements Runnable {

    @Override
    public synchronized void run() {
        while (true) {
            if (tumbler == true) {
                tumbler = false;
                System.out.println("Тублер выключил");
            }
        }
    }

}
