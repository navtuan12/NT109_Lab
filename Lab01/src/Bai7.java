import com.example.MyLog;
import java.util.Scanner;
import utils.util;
public class Bai7 {
    
    public Bai7() {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = scanner.nextInt();
        String result = "";
        for (int i = 2; i <= n/2; i++) {
            if ((new util()).isPrime(i)) {
                result += (i==n/2 ? Integer.toString(i) : (Integer.toString(i) + ", "));
            }
        }
        log.WriteLog("Bai7: Input="+ n +", result: " + result);
        log.ReadFile();
        scanner.close();
    }
}
