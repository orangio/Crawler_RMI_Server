package crawler;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Filip on 21.03.2017.
 */
public  interface Logger extends Remote {
    void log(String status, Student student) throws RemoteException;
}
