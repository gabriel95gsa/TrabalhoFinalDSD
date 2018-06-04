package assets;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Bartender {
    
    private String nome;
    private DefaultTableModel tabelaLogs;

    public Bartender(String nome, DefaultTableModel tabelaLogs) {
        this.nome = nome;
        this.tabelaLogs = tabelaLogs;
    }
    
    /**
     * getters e setters
     */
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * método na qual a bebida é preparada com os ingredientes
     * @param bebida
     * @param qtd 
     */
    public void prepararBebida(String bebida, int qtd) {
        synchronized(this) {
            tabelaLogs.addRow(new Object[]{this.nome + " verificará se há ingredientes para o pedido."});
            
            tabelaLogs.addRow(new Object[]{this.nome + " preparou " + qtd + " doze(s) de " + bebida});
            
            this.entregaBebida(bebida, qtd);
        }
    }
    
    /**
     * método na qual a bebida é entregue para o garçom
     * @param bebida
     * @param qtd 
     */
    private void entregaBebida(String bebida, int qtd) {
        tabelaLogs.addRow(new Object[]{this.nome + " entregou " + qtd + " doze(s) de " + 
                                       bebida + " para o garçom."});
    }
    
}
