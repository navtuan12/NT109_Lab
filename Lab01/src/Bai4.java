import com.example.MyLog;
import java.util.Scanner;
public class Bai4 {
    public Bai4(){
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao 1 so he co so 10: ");
        int n = scanner.nextInt();
        System.out.print("Nhap he co so b can chuyen: ");
        int b = scanner.nextInt();
        int tmp_n = n;
        String result = "";
        while (tmp_n > 0) {
            int soDu = tmp_n % b;
            char chuSo;
            if (soDu >= 10) {
                chuSo = (char) (soDu + 55); 
            } else {
                chuSo = (char) (soDu + '0');
            }
            result = (new StringBuilder()).append(chuSo).append(result).toString();;
            tmp_n /= b;
        }
        log.WriteLog("Bai4: He co so 10 : " + n + ", He co so b: "+ b + ", Output: " + result);
        log.ReadFile();
        scanner.close();
    }
}
