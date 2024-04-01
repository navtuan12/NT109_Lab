import com.example.MyLog;
import java.util.Scanner;
public class Bai9 {
    public Bai9() {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = scanner.nextInt();
        int tmp_n = n;
        String result = "";
        for (int i = 2; i <= tmp_n; i++) {
            while (tmp_n % i == 0) {
                result += (tmp_n==i ? Integer.toString(i) : (Integer.toString(i) + "x"));
                tmp_n /= i;
            }
        }
        log.WriteLog("Bai9: Input="+ n +", result: " + result);
        log.ReadFile();
        scanner.close();
    }
}
