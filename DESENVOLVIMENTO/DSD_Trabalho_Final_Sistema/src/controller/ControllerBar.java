package controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class ControllerBar extends ControllerPadrao {

    public ControllerBar(JDesktopPane jDesktopPane, JInternalFrame jInternalFrame) {
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
     * inicia os processos do bar
     */
    public void iniciaBar() {
        
    }
    
}
