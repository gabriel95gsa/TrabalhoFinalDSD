package control;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class GerenteJanelas {

    private static JDesktopPane jDesktopPane;

    public GerenteJanelas(JDesktopPane jDesktopPane) {
        GerenteJanelas.jDesktopPane = jDesktopPane;
    }

    /**
     * método que abre a JInterframe no JFrame
     * 
     * @param jInternalFrame - inserindo uma JInternalFrame qualquer
     */
    public void abrirJanelas(JInternalFrame jInternalFrame) {
        
        if (jInternalFrame.isVisible()) {
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        } else {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setLocation((jDesktopPane.getWidth() / 2) - (jInternalFrame.getWidth() / 2),
                                       (jDesktopPane.getHeight()/ 2) - (jInternalFrame.getHeight() / 2));
            jInternalFrame.setVisible(true);
        }
    }
}
