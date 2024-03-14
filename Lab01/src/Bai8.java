import com.example.MyLog;

public class Bai8 {
    //Viết chương trình liệt kê tất cả số nguyên tố có 5 chữ số trong java.
    public static void main(String[] args) {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        String result = "";
        for (int i = 10000; i < 100000; i++) {
            if (isPrime(i)) {
                result += (i==99991 ? Integer.toString(i) : (Integer.toString(i) + ", "));
            }
        }
        log.WriteLog("Bai8: result: " + result);
        log.ReadFile();
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
