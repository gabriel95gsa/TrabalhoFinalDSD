package servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class MainServidor {

    public static void main(String[] args) {
        try {
            Bar server = new Bar();
            InterfaceRemotaBar stub = (InterfaceRemotaBar) UnicastRemoteObject.exportObject(server, 443);
            Registry registry = LocateRegistry.createRegistry(443);
            registry.bind("ServidorBar", stub);
            JOptionPane.showMessageDialog(null, "Servidor iniciado");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
