import com.example.MyLog;

public class Bai10 {
    //Nhập một sâu ký tự. Đếm số từ của sâu đó (mỗi từ cách nhau bởi một khoảng trắng có thể là một hoặc nhiều dấu cách, tab, xuống dòng). Ví dụ " hoc java co ban den nang cao " có 7 từ.
    public static final char SPACE = ' ';
    public static final char TAB = '\t';
    public static final char BREAK_LINE = '\n';
    public static void main(String[] args) {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        String input = " hoc java co ban den nang cao ";
        int count = 0;
        int size = input.length();
        boolean notCounted = true;
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB 
                    && input.charAt(i) != BREAK_LINE) {
                if(notCounted) {
                    count++;
                    notCounted = false;
                }
            } else {
                notCounted = true;
            }
        }
        log.WriteLog("Bai10: " + count);
        log.ReadFile();
    }
}
