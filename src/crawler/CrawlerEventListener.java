package crawler;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Filip on 03.04.2017.
 */
public interface CrawlerEventListener extends Remote,Serializable {
    void onStudentAdded(Student a)throws RemoteException;
    void onStudentDeleted(Student a)throws RemoteException;
    void onNoChange()throws RemoteException;
}
