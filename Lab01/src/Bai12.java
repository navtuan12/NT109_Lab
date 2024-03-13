import com.example.MyLog;

public class Bai12 {
    //Nhập 2 sâu ký tự s1 và s2. Kiểm tra xem sâu s1 có chứa s2 không?
    public static void main(String[] args) {
        MyLog log = new MyLog("21522757.txt");
        String s1 = "hoc java co ban den nang cao";
        String s2 = "java";
        String result = s1.contains(s2) ? "s1 chua s2" : "s1 khong chua s2";
        log.WriteLog("Bai12: s1:" + s1 +", s2:" + s2 + ", result: " + result);
        log.ReadFile();
    }
}
