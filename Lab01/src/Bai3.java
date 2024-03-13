import java.util.Scanner;
import com.example.MyLog;
import java.util.HashMap;
import java.util.Map;


public class Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyLog log = new MyLog("21522757.txt");
        System.out.print("Nhap n: ");
        int n = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 1; i <= n; i++) {
            map.put(i, i*i);
        }
        String str = map.toString().replace("=", ": ");
        scanner.close();
        log.WriteLog("Bai3: " + str);
        log.ReadFile();

    }    
}
