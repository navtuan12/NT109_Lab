import com.example.MyLog;
import java.util.Scanner;
public class Bai4 {
    /*Viết chương trình chuyển đổi một số tự nhiên ở hệ số 10 thành một số ở hệ cơ số B (1 <= B <= 32) bất kỳ. Giả sử hệ cơ số cần chuyển là 2 <= B <= 16. Số đại điện cho hệ cơ số B > 10 là A = 10, B = 11, C = 12, D = 13, E = 14, F = 15.
Gợi ý:
•	Tham khảo bảng ASCII để chuyển đổi kiểu char thành String. Hàm chr(55 + m) trong ví dụ sau:
•	Nếu m = 10 trả về chuỗi "A".
•	Nếu m = 11 trả về chuỗi "B".
•	Nếu m = 12 trả về chuỗi "C".
•	Nếu m = 13 trả về chuỗi "D".
•	Nếu m = 14 trả về chuỗi "E".
•	Nếu m = 15 trả về chuỗi "F".
 */
    public static void main(String[] args) {
        MyLog log = new MyLog("21522757.txt");
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
                chuSo = (char) (soDu + 55);  // A = 10, B = 11, ...
            } else {
                chuSo = (char) (soDu + '0');
            }
            result = (new StringBuilder()).append(chuSo).append(result).toString();;
            tmp_n /= b;
        }
        log.WriteLog("Bai4: " + result);
        log.ReadFile();
    }
}
