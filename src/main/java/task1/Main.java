package task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final int TIME_WAIT_USER = 1000;
    public static final int NUMBER_OF_REPITITION = 10;
    public static final int MAX_WAIT = 6000;

    public static volatile boolean tumbler;

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.start();
    }
}
