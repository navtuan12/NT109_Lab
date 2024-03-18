package utils;
import java.util.Scanner;
import utils.util;
public class Matrix {
    private int column, row;
    private int[][] matrix;

    /*
        a) Tìm phần tử lớn thứ nhất với chỉ số của nó (chỉ số đầu tiên tìm được).
b) Tìm và in ra các phần tử là số nguyên tố của ma trận (các phần tử không nguyên tố thì thay bằng số 0).
c) Sắp xếp tất cả các cột của ma trận theo thứ tự tăng dần và in kết quả ra màn hình.
d) Tìm cột trong ma trận có nhiều số nguyên tố nhất.
     */
    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new int[row][column];
    }

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Nhap vao phan tu thu [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    public int[][] getMatrix() {
        return matrix;
    }

    
    public String FindMax(){
        int max = matrix[0][0];
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        sb.append("Max: " + max + " at [" + x + "][" + y + "]");
        return sb.toString();
    }

    // b) Tìm và in ra các phần tử là số nguyên tố của ma trận (các phần tử không nguyên tố thì thay bằng số 0).
    public String FindPrime(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if((new util()).isPrime(matrix[i][j])){
                    sb.append(matrix[i][j] + " ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //c) Sắp xếp tất cả các cột của ma trận theo thứ tự tăng dần và in kết quả ra màn hình.

    public int[][] SortColumns(){
        for (int i = 0; i < column; i++) {
            int[] temp = new int[row];
            for (int j = 0; j < row; j++) {
                temp[j] = matrix[j][i];
            }
            for (int j = 0; j < row; j++) {
                for (int k = j + 1; k < row; k++) {
                    if(temp[j] > temp[k]){
                        int t = temp[j];
                        temp[j] = temp[k];
                        temp[k] = t;
                    }
                }
            }
            for (int j = 0; j < row; j++) {
                matrix[j][i] = temp[j];
            }
        }
        return matrix;
    }
    // /d) Tìm cột trong ma trận có nhiều số nguyên tố nhất.
    public String FindColumnWithMostPrime(){
        StringBuilder sb = new StringBuilder();
        int[] count = new int[column];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                if((new util()).isPrime(matrix[j][i])){
                    count[i]++;
                }
            }
        }
        int max = count[0];
        int index = 0;
        for (int i = 1; i < column; i++) {
            if(count[i] > max){
                max = count[i];
                index = i;
            }
        }
        for(int i = 0; i < row; i++ ){
            sb.append(matrix[i][index]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
