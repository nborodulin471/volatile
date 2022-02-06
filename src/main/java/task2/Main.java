package task2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Генерация 3 массивов целых положительных чисел
        RandomArrayInt arr1 = new RandomArrayInt(10);
        RandomArrayInt arr2 = new RandomArrayInt(20);
        RandomArrayInt arr3 = new RandomArrayInt(15);

        // Создание трех потоков, которые суммируют выручку (каждый по своему массиву) в общий отчет
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        LongAdder longAdder = new LongAdder();

        longAdder.add(executorService.submit(arr1).get());
        longAdder.add(executorService.submit(arr2).get());
        longAdder.add(executorService.submit(arr3).get());

        // Главный поток ждет завершения всех рассчетов и печатает общий итог в консоль
        executorService.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("Сумма для налоговой: " + longAdder.sum());
        executorService.shutdown();
    }
}
