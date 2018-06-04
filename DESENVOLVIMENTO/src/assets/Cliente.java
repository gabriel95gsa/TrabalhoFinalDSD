package assets;

import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Cliente implements Runnable {
    
    private List<Garcom> garcons;
    private Garcom garcomEscolhido;
    private DefaultTableModel tabelaLogs;

    public Cliente(List<Garcom> garcons, DefaultTableModel tabelaLogs) {
        this.garcons = garcons;
        this.tabelaLogs = tabelaLogs;
    }
    
    /**
     * método na qual é realizado o pedido para o garçom
     * @param bebida
     * @param qtd 
     */
    private void queroBeber(String bebida, int qtd) {
        this.garcomEscolhido = this.escolherGarcom();
        
        tabelaLogs.addRow(new Object[]{Thread.currentThread().getName() + " pediu " + 
                                       qtd + " doze(s) de " + bebida + " para o " + 
                                       this.garcomEscolhido.getNome()});
        
        this.garcomEscolhido.pegarBebida(bebida, qtd);
        
        this.bebe(bebida, qtd);
    }
    
    /**
     * método na qual a bebida é consumida
     * @param bebida
     * @param qtd 
     */
    private void bebe(String bebida, int qtd) {
        tabelaLogs.addRow(new Object[]{Thread.currentThread().getName() + 
                                       " está bebendo sua(s) " + qtd + " doze(s) de " + 
                                       bebida});
    }
    
    /**
     * método que escolhe um garçom aleatório para atendimento
     * @return 
     */
    private Garcom escolherGarcom() {
        Random random = new Random();
        
        return garcons.get(random.nextInt(garcons.size()));
    }

    @Override
    public void run() {
        this.queroBeber("cerveja skol", 2);
    }
    
}
