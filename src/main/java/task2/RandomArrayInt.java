package task2;

import java.util.concurrent.Callable;

public class RandomArrayInt implements Callable<Integer> {

    private static final int MAX = 10000;
    private static final int MIN = 0;

    private int[] arr;

    public RandomArrayInt(int capicity) {
        arr = new int[capicity];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) ((Math.random() * ((MAX - MIN) + 1)) + MIN);
        }
    }

    @Override
    public Integer call() throws Exception {
        return sum();
    }

    private int sum(){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

}
