package servidor;

import controller.Controller_Bebida;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Main {

    public static void main(String[] args) {
        
        try {
            ServidorBD servidor = new ServidorBD();
            InterfaceRemotaBD stub = (InterfaceRemotaBD) UnicastRemoteObject.exportObject(servidor, 1541);
            Registry registry = LocateRegistry.createRegistry(1541);
            registry.bind("ServidorBD", stub);
            JOptionPane.showMessageDialog(null, "Servidor iniciado");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
