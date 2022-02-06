package task1;

import static task1.Main.*;

public class User implements Runnable {
    @Override
    public synchronized void run() {
        // Поток-пользователь, после нескольких итераций завершает выполнение
        for (int i = 0; i < NUMBER_OF_REPITITION; i++) {
            try {
                Thread.sleep(TIME_WAIT_USER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Поток-пользователь раз в несколько секунд включает тумблер
            tumbler = true;
            System.out.println("Включил тумблер");
        }
        notifyAll();
    }
}
