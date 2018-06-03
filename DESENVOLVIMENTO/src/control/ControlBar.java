package control;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import server.*;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class ControlBar extends ControlPadrao {

    public ControlBar(JDesktopPane jDesktopPane, JInternalFrame jInternalFrame) {
        super(jDesktopPane, jInternalFrame);
    }
    
    @Override
    public void abrirJanela() {
        if (this.view.isVisible()) {
            this.view.toFront();
            this.view.requestFocus();
        } else {
            viewPrincipal.add(this.view);
            this.view.setLocation((viewPrincipal.getWidth() / 2) - (this.view.getWidth() / 2),
                                       (viewPrincipal.getHeight()/ 2) - (this.view.getHeight() / 2));
            this.view.setVisible(true);
        }
    }
    
    /**
     * Inicia o servidor do Bar
     */
    public void iniciaServidor() {
        try {
            Bar server = new Bar();
            InterfaceRemotaBar stub = (InterfaceRemotaBar) UnicastRemoteObject.exportObject(server, 8000);
            Registry registry = LocateRegistry.createRegistry(8000);
            registry.bind("Servidor do Bar", stub);
            JOptionPane.showMessageDialog(null, "Servidor iniciado");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
