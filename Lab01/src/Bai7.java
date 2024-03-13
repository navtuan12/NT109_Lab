import com.example.MyLog;
import java.util.Scanner;
public class Bai7 {
    /*Bài 07:
Viết chương trình liệt kê tất cả các số nguyên tố nhỏ hơn n. Số nguyên dương n được nhập từ bàn phím.
 */
    public static void main(String[] args) {
        MyLog log = new MyLog("21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = scanner.nextInt();
        String result = "";
        for (int i = 2; i <= n/2; i++) {
            if (isPrime(i)) {
                result += (i==n/2 ? Integer.toString(i) : (Integer.toString(i) + ", "));
            }
        }
        log.WriteLog("Bai7: Input="+ n +", result: " + result);
        log.ReadFile();
    }
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
