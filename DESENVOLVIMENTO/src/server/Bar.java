package server;

import assets.Bartender;
import assets.Garcom;
import java.util.List;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Bar implements InterfaceRemotaBar {
    
    private List<Garcom> garcons;
    private List<Bartender> bartenders;
    
    /**
     * método que adiciona um garçom a lista de garçons
     * @param garcom 
     */
    public void adicionarGarcom(Garcom garcom) {
        this.garcons.add(garcom);
    }
    
    /**
     * método que adiciona um bartender a lista de bartenders
     * @param bartender 
     */
    public void adicionarBartender(Bartender bartender) {
        this.bartenders.add(bartender);
    }
    
}
