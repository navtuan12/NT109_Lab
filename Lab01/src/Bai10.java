import java.util.Scanner;

import com.example.MyLog;

public class Bai10 {

    private static final char SPACE = ' ';
    private static final char TAB = '\t';
    private static final char BREAK_LINE = '\n';

    public Bai10() {
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String input = scanner.nextLine();
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
        log.WriteLog("Bai10: Input: "+ input + ", Count: " + count);
        log.ReadFile();
        scanner.close();
    }
}
