import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import com.example.MyLog;

public class Client {
   private Client() {
   }
   public static void main(String[] args) throws RemoteException, NotBoundException {
      MyLog log = new MyLog("21522757.txt");
      Registry registry = LocateRegistry.getRegistry("127.0.0.1",1234);
      iEcho stub = (iEcho) registry.lookup("printMsg");
      Scanner scanner = new Scanner(System.in);
      while (true) {
         String line = scanner.nextLine();
         System.out.println(stub.printMsg(line));
         log.WriteLog(line);
         log.WriteLog(stub.printMsg(line));
         if (line.equals("quit"))
            break;
      }
   }
}