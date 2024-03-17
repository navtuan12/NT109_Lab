import com.example.MyLog;
import utils.util;
public class Bai8 {
    //Viết chương trình liệt kê tất cả số nguyên tố có 5 chữ số trong java.
    public Bai8() {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        String result = "";
        for (int i = 10000; i < 100000; i++) {
            if ((new util()).isPrime(i)) {
                result += (i==99991 ? Integer.toString(i) : (Integer.toString(i) + ", "));
            }
        }
        log.WriteLog("Bai8: result: " + result);
        log.ReadFile();
    }
}
