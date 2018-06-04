package assets;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Cliente implements Runnable {
    
    private Garcom garcom;

    public Cliente(Garcom garcom) {
        this.garcom = garcom;
    }
    
    /**
     * método na qual é realizado o pedido para o garçom
     * @param bebida
     * @param qtd 
     */
    private void queroBeber(String bebida, int qtd) {
        this.garcom.pegarBebida(bebida, qtd);
    }
    
    /**
     * método na qual a bebida é consumida
     * @param bebida
     * @param qtd 
     */
    private void bebe(String bebida, int qtd) {}

    @Override
    public void run() {
        
    }
    
}
