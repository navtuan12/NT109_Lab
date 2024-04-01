import com.example.MyLog;
import java.util.Scanner;
public class Bai6 {
    public Bai6() {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao a,b:");
        int a = scanner.nextInt(), b = scanner.nextInt();
        int uscln = USCLN(a, b);
        int bscnn = (a * b) / uscln;
        log.WriteLog("Bai6: Input: a=" + a + ", b=" + b + ", USCLN=" + uscln + ", BSCNN=" + bscnn);
        log.ReadFile();
        scanner.close();
    }

    public static int USCLN(int a, int b) {
        if (b == 0) return a;
        return USCLN(b, a % b);
    }
}
