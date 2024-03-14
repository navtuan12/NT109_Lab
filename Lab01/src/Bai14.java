import com.example.MyLog;

import utils.Matrix;

public class Bai14 {
    /*
     Viết chương trình nhập vào ma trận A có n dòng, m cột, các phần tử là số nguyên lớn hơn 0 và nhỏ hơn 100. Thực hiện các chức năng sau:
a) Tìm phần tử lớn thứ nhất với chỉ số của nó (chỉ số đầu tiên tìm được).
b) Tìm và in ra các phần tử là số nguyên tố của ma trận (các phần tử không nguyên tố thì thay bằng số 0).
c) Sắp xếp tất cả các cột của ma trận theo thứ tự tăng dần và in kết quả ra màn hình.
d) Tìm cột trong ma trận có nhiều số nguyên tố nhất.

     */

    public static void main(String[] args) {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Matrix matrix = new Matrix(4, 4);
        matrix.Input();
        matrix.Output();
        matrix.FindMax();
        log.WriteLog("Bai 14 Input:");
}
