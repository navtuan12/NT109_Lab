
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.example.MyLog;

class App implements Runnable {
    private ExecutorService pool = Executors.newFixedThreadPool(4);

    public void quickSortThread(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            Runnable left = () -> {
                quickSortThread(arr, begin, partitionIndex - 1);
            };
            Runnable right = () -> {
                quickSortThread(arr, partitionIndex + 1, end);
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

    public static void print(int args[]) {
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

    public static int[] generatedRandomArray(int n) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int[] uniqueArray = new int[n];
        for (int i = 0; i < n; i++) {
            uniqueArray[i] = list.get(i);
        }
        return uniqueArray;
    }

    public static void main(String[] args) {
        // Genarate 2 random arrays
        int n = 10000000;
        int[] uniqueArray = generatedRandomArray(n);
        int[] uniqueArray2 = uniqueArray;
        MyLog log = new MyLog("21522757.txt");

        App app = new App();
        double startTime = System.nanoTime();
        app.quickSort(uniqueArray, 0, n - 1);
        double endTime = System.nanoTime();

        double startTime2 = System.nanoTime();
        app.quickSortThread(uniqueArray2, 0, n - 1);
        double endTime2 = System.nanoTime();

        double duration = (endTime - startTime) / 1000000000;
        double duration2 = (endTime2 - startTime2) / 1000000000;
        log.WriteLog("\nInput: " + n + "\nSequential: " + duration + "\nParallel: " + duration2);
        log.ReadFile();
    }
}
