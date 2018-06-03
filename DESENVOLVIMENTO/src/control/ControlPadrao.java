package control;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public abstract class ControlPadrao {
    
    protected static JDesktopPane viewPrincipal;
    protected JInternalFrame view;

    public ControlPadrao(JDesktopPane viewPrincipal, JInternalFrame view) {
        this.viewPrincipal = viewPrincipal;
        this.view = view;
    }
    
    /**
     * método que abre a JInterframe no JFrame
     */
    public abstract void abrirJanela();
    
}
