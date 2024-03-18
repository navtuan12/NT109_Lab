import com.example.MyLog;
import java.util.Scanner;
public class Bai9 {
    public Bai9() {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = scanner.nextInt();
        String result = "";
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                result += (n==i ? Integer.toString(i) : (Integer.toString(i) + "x"));
                n /= i;
            }
        }
        log.WriteLog("Bai9: Input="+ n +", result: " + result);
        log.ReadFile();
        scanner.close();
    }
}
