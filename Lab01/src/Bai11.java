import com.example.MyLog;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Bai11 {
    private static final char SPACE = ' ';
    private static final char TAB = '\t';
    private static final char BREAK_LINE = '\n';
    private static final char COMMA = ',';
     
    public Bai11() {

        MyLog log = new MyLog("Lab01\\21522757.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String input = scanner.nextLine();
        String result = countWords(input).toString().replace("=", ": ");
        log.WriteLog("Bai11: Input: "+ input +", result: " + result);
        log.ReadFile();
        scanner.close();

    }

    public static Map<String, Integer> countWords(String input) {
        // khởi tạo wordMap
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        if (input == null) {
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB 
                    && input.charAt(i) != BREAK_LINE && input.charAt(i) != COMMA) {
                // build một từ
                sb.append(input.charAt(i));
            } else {
                // thêm từ vào wordMap
                addWord(wordMap, sb);
                sb = new StringBuilder();
            }
        }
        // thêm từ cuối cùng tìm được vào wordMap
        addWord(wordMap, sb);
        return wordMap;
    }
    
    public static void addWord(Map<String, Integer> wordMap, StringBuilder sb) {
        String word = sb.toString();
        if (word.length() == 0) {
            return;
        }
        if (wordMap.containsKey(word)) {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }
}
