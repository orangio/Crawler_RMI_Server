import crawler.Crawler;
import crawler.CrawlerEventListener;
import crawler.ExtremumMode;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Filip on 30.05.2017.
 */
public class RMICrawlerProxy extends UnicastRemoteObject implements CrawlerMethodsInterface, Serializable {
    private Crawler crawler;

    protected RMICrawlerProxy() throws RemoteException, MalformedURLException {
        crawler = new Crawler(new URL("http://home.agh.edu.pl/~ggorecki/IS_Java/students.txt"));
    }

    @Override
    public void addListener(CrawlerEventListener listener) throws RemoteException {
        crawler.addListener(listener);
    }

    @Override
    public void run() throws RemoteException {
        try {
            crawler.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postCancel() throws RemoteException {
        crawler.postCancel();
    }

    @Override
    public void setOn(boolean on) throws RemoteException {
        crawler.setOn(on);
    }

    @Override
    public double extractMark(ExtremumMode mode) throws RemoteException {
        return 0;
    }

    @Override
    public int extractAge(ExtremumMode mode) throws RemoteException {
        return 0;
    }
}
