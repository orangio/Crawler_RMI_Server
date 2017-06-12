/**
 * Created by Filip on 14.03.2017.
 */

import crawler.*;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;


public class Main {
    private static final int PORT=999;

    public static void main(String[] args) throws Exception {
        //if (System.getSecurityManager() == null) {
           // System.setSecurityManager(new RMISecurityManager());
        //}
        String name = "rmi://"+PORT+"/CrawlerProxy";
        Registry registry = LocateRegistry.createRegistry(PORT);

        try {
            RMICrawlerProxy crawler = new RMICrawlerProxy(); // tworzenie obiektu gry na serwerze
            //RMICrawlerProxy stub = (RMICrawlerProxy) UnicastRemoteObject.exportObject(crawler, 0);
            registry.bind(name, crawler); // bindowanie obiektu gry
            System.out.println("Server ready. \n");

            System.out.println("Type 'exit' to exit server.");

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    if (scanner.hasNextLine()) {
                        if ("exit".equals(scanner.nextLine())) {
                            break;
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("\nRemoteException was thrown.");
        } finally {
            UnicastRemoteObject.unexportObject(registry, true); // zwalnianie rejestru
            System.out.println("Server stopped."); // komunikat zakonczenia
        }
    }
}
