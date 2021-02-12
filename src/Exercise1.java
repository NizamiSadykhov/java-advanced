import java.util.Arrays;

public class Exercise1 {

    private static final int SIZE = 10000000;
    private static final int H = SIZE / 2;

    public static void main(String[] args) {
        fillArray();
        fillArrayWithThreads();
    }

    private static void fillArray() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения fillArray: " + (endTime - startTime));
    }

    private static void fillArrayWithThreads() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);

        float[] array1 = new float[H];
        float[] array2 = new float[H];

        long startTime = System.currentTimeMillis();

        System.arraycopy(array, 0, array1, 0, H);
        System.arraycopy(array, H, array2, 0, H);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (array1) {
                    for (int i = 0; i < array1.length; i++) {
                        array1[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (array2) {
                    for (int i = 0; i < array2.length; i++) {
                        array2[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                }
            }
        });

        thread1.start();
        thread2.start();


        System.arraycopy(array1, 0, array, 0, H);
        System.arraycopy(array2, 0, array, H, H);

        long endTime = System.currentTimeMillis();

        System.out.println("Время выполнения fillArrayWithThreads: " + (endTime - startTime));
    }
}
