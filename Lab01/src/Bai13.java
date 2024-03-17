import com.example.MyLog;
import utils.Array;

public class Bai13 {

    public Bai13() {
        Array a = new Array();
        MyLog log = new MyLog("Lab01\\21522757.txt");
        a.Input();
        log.WriteLog("Bai13 Input: " + a.Output());
        log.WriteLog("Bai13 a) Max: " + a.Max() + ", Second max: " + a.SecondMax());
        a.Sort();
        log.WriteLog("Bai13 b) Sort: " + a.Output());
        a.Addx(3);
        log.WriteLog("Bai13 c) Add x: "+ a.Output());
        log.ReadFile();
    }
}

