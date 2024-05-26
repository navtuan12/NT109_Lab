import java.rmi.Remote; 
import java.rmi.RemoteException;  

public interface iEcho extends Remote {  
   String printMsg(String e) throws RemoteException;  
}