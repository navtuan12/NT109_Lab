import com.example.MyLog;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Bai1 {
    public Bai1(){
        MyLog log = new MyLog("21522757.txt");
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 10; i <= 200; i++){
            if(i%7==0 && i%5!=0){   
                list.add(i);
            }
        }
        String listInt = list.stream().map(Object::toString).collect(Collectors.joining(", "));
        log.WriteLog("Bai1: " + listInt);
        log.ReadFile();
    }
}
