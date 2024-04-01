import java.util.Scanner;
import com.example.MyLog;
import java.util.HashMap;
import java.util.Map;


public class Bai3 {
    public Bai3() {
        Scanner scanner = new Scanner(System.in);
        MyLog log = new MyLog("Lab01\\21522757.txt");
        System.out.print("Nhap n: ");
        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 1; i <= n; i++) {
            map.put(i, i*i);
        }
        String str = map.toString().replace("=", ": ");
        scanner.close();
        log.WriteLog("Bai3: Input = "+ n + ", Output = " + str);
        log.ReadFile();

    }    
}
