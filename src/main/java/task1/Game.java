package task1;

import static task1.Main.MAX_WAIT;

public class Game {
    public synchronized void start() {
        User user = new User();
        Toys toys = new Toys();
        // Создание поток-пользователь и поток-игрушка
        Thread userThread = new Thread(null, user, "Пользователь");
        userThread.start();
        // Поток-игрушка как только обнаруживает включение - выключает тумблер
        Thread toysThread = new Thread(null, toys, "Игрушка");
        toysThread.start();
        // Главный поток (main) после завершения потока-пользователя, останавливает поток-игрушку
        try {
            wait(MAX_WAIT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        toysThread.interrupt();
    }
}
