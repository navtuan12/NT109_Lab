import java.util.Scanner;

import com.example.MyLog;

public class Bai12 {
    public Bai12() {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap s1: ");
        String s1 = scanner.nextLine();
        System.out.print("Nhap s2: ");
        String s2 = scanner.nextLine();
        String result = s1.contains(s2) ? "s1 chua s2" : "s1 khong chua s2";
        log.WriteLog("Bai12: s1:" + s1 +", s2:" + s2 + ", result: " + result);
        log.ReadFile();
        scanner.close();
    }
}
