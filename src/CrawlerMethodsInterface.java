import crawler.CrawlerEventListener;
import crawler.ExtremumMode;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Filip on 30.05.2017.
 */
public interface CrawlerMethodsInterface extends Remote, Serializable {
    public void addListener(CrawlerEventListener listener) throws RemoteException;
    public  void run() throws RemoteException;
    public void postCancel()throws RemoteException;
    public void setOn(boolean on)throws RemoteException;
    double extractMark(ExtremumMode mode)throws RemoteException;
    int extractAge(ExtremumMode mode)throws RemoteException;
}
