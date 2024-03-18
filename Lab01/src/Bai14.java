import com.example.MyLog;
import utils.util;
import utils.Matrix;

public class Bai14 {
    public Bai14(){
        MyLog log = new MyLog("Lab01\\21522757.txt");
        Matrix matrix = new Matrix(4, 4);
        matrix.Input();
        
        log.WriteLog("Bai 14 Input:\n" + (new util()).toString(matrix.getMatrix()));
        log.WriteLog("Bai 14 a) "+ matrix.FindMax());
        log.WriteLog("Bai 14 b) \n"+ matrix.FindPrime());
        log.WriteLog("Bai 14 c) \n"+ matrix.FindColumnWithMostPrime());
        log.ReadFile();
    }
}
