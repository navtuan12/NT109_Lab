import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplEcho extends UnicastRemoteObject implements iEcho {  
    protected ImplEcho() throws RemoteException {
        super();
    }
    
    @Override
    public String printMsg(String e) throws RemoteException {  
       return "Server response: " + e;
    }  
 } 