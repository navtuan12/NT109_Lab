import com.example.MyLog;

import utils.util;

public class Bai15 {
    public Bai15(){
        MyLog log = new MyLog("Lab01\\21522757.txt");
        String[] arr = new String[5];
        (new util()).StringInput(arr);
        String result = "Dung roi!";
        log.WriteLog("Bai 15 Input: " + (new util()).StringOutput(arr));
        for (String s : arr) {
            if(!s.matches("00[2-5]L[0-9]{4}")){
                result = "Sai roi!";
                log.WriteLog("Bai 15 Output: " + result);
                log.ReadFile();
                return;
            }
        }
        log.WriteLog("Bai 15 Output: " + result);
        log.ReadFile();
    }
}
