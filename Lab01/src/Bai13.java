import com.example.MyLog;
import java.util.Scanner;
public class Bai13 {

    public static void main(String[] args){
        Array a = new Array();
        MyLog log = new MyLog("21522757.txt");
        a.Input();
        int[] addX = a.AddXSort();
        log.WriteLog("Bai13 Input: " + a.Output());
        log.WriteLog("Bai13 a) Max: " + a.Max() + ", Second max: " + a.SecondMax());
        a.Sort();
        log.WriteLog("Bai13 b) Sort: " + a.Output());
        log.WriteLog("Bai13 c) Add x: "+ Print(addX));
        log.ReadFile();
    }
    
    public static String Print(int[] arr){
        String result = "";
        for(int i = 0; i < arr.length; i++){
            result += arr[i] + " ";
        }
        return result;
    }
}

