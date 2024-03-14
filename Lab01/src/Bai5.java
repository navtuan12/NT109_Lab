import com.example.MyLog;
import java.util.Scanner;

public class Bai5 {
    public Bai5(){
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n:");
        int n = scanner.nextInt();
        int f0 = 0, f1 = 1;
        String result = "0, 1";
        for (int i = 2; i < n; i++) {
            int f = f0 + f1;
            result += ", " + f;
            f0 = f1;
            f1 = f;
        }
        scanner.close();
        log.WriteLog("Bai5: Input=" + n +", result: "+ result);
        log.ReadFile();
    }
}
