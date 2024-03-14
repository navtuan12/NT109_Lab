package utils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Array {
    private int n;
    private List<Integer> arr;

    public Array(){

    }
    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao n: ");
        n = scanner.nextInt();
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap vao phan tu thu " + i + ": ");
            arr.add(scanner.nextInt());
        }
        scanner.close();
    }

    public String Output() {
        String result = "";
        for (int i = 0; i < arr.size(); i++) {
            result += arr.get(i) + " ";
        }
        return result;
    }

    public int Max() {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }

    public int Min() {
        int min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }

    public int SecondMax() { 
        int max = Max();
        int secondMax = Min();
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > secondMax && arr.get(i) < max) {
                secondMax = arr.get(i);
            }
        }
        return secondMax;
    }

    public void Sort() {
        Collections.sort(arr);
    }

    public void Addx(int x){
        arr.add(x);
        n += 1;
        this.Sort();
    }

}
