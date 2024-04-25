
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class App implements Runnable {
    private ExecutorService pool = Executors.newFixedThreadPool(10 );

    public void quickSortThread(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            Runnable left = () -> {
                quickSort(arr, begin, partitionIndex - 1);
            };
            Runnable right = () -> {
                quickSort(arr, partitionIndex + 1, end);
            };
            pool.execute(left);
            pool.execute(right);
        }
    }

    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);

            quickSort(arr, partitionIndex + 1, end);

        }
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }

    public void print(int args[]) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        int index = 0;
        for (int i = 0; i < 10000; i++) {
            list.add(index++);
        }
        Collections.shuffle(list);
        int[] uniqueArray = new int[10000];
        for (int i = 0; i < list.size(); i++) {
            uniqueArray[i] = list.get(i);
        }
        App app = new App();
        app.print(uniqueArray);
        double startTime = System.nanoTime();
        app.quickSortThread(uniqueArray, 0, 9999);
        double endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1000000000;
        app.print(uniqueArray);
        System.out.println(duration);
    }
}
