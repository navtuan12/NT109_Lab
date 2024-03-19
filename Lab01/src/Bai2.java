import java.util.Scanner;

import com.example.MyLog;

public class Bai2 {
    public Bai2(){
        Scanner scanner = new Scanner(System.in);
        MyLog log = new MyLog("21522757.txt");
        System.out.print("Nhap n: ");
        int n = scanner.nextInt();
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        scanner.close();
        log.WriteLog("Bai2:Input = "+ n + ", Output = " + Integer.toString(result));
        log.ReadFile();    
    }
}
