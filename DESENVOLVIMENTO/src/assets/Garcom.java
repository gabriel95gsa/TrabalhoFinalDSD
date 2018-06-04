package assets;

import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Garcom {
    
    private List<Bartender> bartenders;
    private Bartender bartendeEscolhido;
    private String nome;
    private DefaultTableModel tabelaLogs;

    public Garcom(List<Bartender> bartenders, String nome, DefaultTableModel tabelaLogs) {
        this.bartenders = bartenders;
        this.nome = nome;
        this.tabelaLogs = tabelaLogs;
    }
    
    /**
     * getters e setters
     * @return 
     */
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * método na qual é realizado o pedido ao bartender 
     * @param bebida
     * @param qtd 
     */
    public void pegarBebida(String bebida, int qtd) {
        synchronized(this) {
            this.bartendeEscolhido = this.escolherBartender();
            
            tabelaLogs.addRow(new Object[]{this.nome + " solicitou " + qtd + " doze(s) de " + 
                                           bebida + " para o "  + this.bartendeEscolhido.getNome()});
            
            this.bartendeEscolhido.prepararBebida(bebida, qtd);
            
            this.serveBebida(bebida, qtd);
        }
    }
    
    /**
     * método na qual a bebida é servida
     * @param bebida
     * @param qtd 
     */
    private void serveBebida(String bebida, int qtd) {
        tabelaLogs.addRow(new Object[]{this.nome + " serviu " + qtd + " doze(s) de " +
                                       bebida + " para " + Thread.currentThread().getName()});
    }
    
    /**
     * método que escolhe um bartender aleatório para preparar a bebida
     * @return 
     */
    private Bartender escolherBartender() {
        Random random = new Random();
        
        return bartenders.get(random.nextInt(bartenders.size()));
    }
    
}
