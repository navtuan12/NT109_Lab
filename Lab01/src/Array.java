import java.util.NoSuchElementException;
import java.util.Scanner;
public class Array {
    private int n;
    private int[] arr;

    public void Input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao n: ");
        n = scanner.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++){
            System.out.print("Nhap vao phan tu thu " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.err.println("Nhap thanh cong");
    }

    public String Output(){
        String result = "";
        for(int i = 0; i < n; i++){
            result += arr[i] + " ";
        }
        return result;
    }

    public int Max(){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public int SecondMax(){
        int max = Max();
        int secondMax = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > secondMax && arr[i] < max){
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public void Sort(){
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public int[] AddXSort(){
        int[] newArr = new int[n + 1];
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhap vao x: ");
            int x = scanner.nextInt();
            int i = 0;
            boolean flag = false;
            while(i < n+1){
                if(arr[i] < x || flag == true){
                    newArr[i] = arr[i];
                } else {
                    newArr[i] = x;
                    flag = true;
                }
                i++;
            }
        } catch (NoSuchElementException e) {
        }
        return newArr;
    }

}
