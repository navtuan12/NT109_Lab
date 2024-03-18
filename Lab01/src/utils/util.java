package utils;

import java.util.Scanner;

public class util {
    public boolean isPrime(int prime) {
        if (prime < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(prime); i++) {
            if (prime % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String toString(int[][] a) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < a.length ; i++)
            for (int j = 0; j < a[i].length; j++) {
                str.append(a[i][j]);
                str.append("\t");
                if(j == a[i].length-1)
                    str.append("\n");
            }
        return str.toString();
    }

    public void StringInput(String[] arr){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            System.out.print("Nhap phan tu thu " + (i+1) + ": ");
            arr[i] = scanner.nextLine();
        }
        scanner.close();
    } 

    public String StringOutput(String[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 5; i++){
            sb.append(arr[i]);
            sb.append(", ");
        }
        return sb.toString();
    }
}
