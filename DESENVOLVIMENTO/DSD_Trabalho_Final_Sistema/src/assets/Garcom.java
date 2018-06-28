package assets;

import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Garcom implements MensagensTabela {
    
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
     * Getters e Setters
     * @return 
     */
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * método na qual é realizado o pedido ao garçom
     */
    public void pedirBebida(Coquetel coquetel, String nomeCliente) {
        synchronized(this) {
            this.escreverMensagem(nomeCliente + " chamou o garçom " + 
                                  this.nome + " e pediu uma bebida composta por " + 
                                  coquetel.getDescricaoCoquetel());
            
            this.escreverMensagem(this.nome + " atendendendo " + nomeCliente);
            
            this.pegarBebida(coquetel, nomeCliente);
        }
    }
    
    /**
     * método na qual é realizado o pedido ao bartender 
     * @param bebida
     * @param qtd 
     */
    private void pegarBebida(Coquetel coquetel, String nomeCliente) {
        this.bartendeEscolhido = this.escolherBartender();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.escreverMensagem(this.nome + " solicitou uma bebida composta por " +
                              coquetel.getDescricaoCoquetel() + " para o "  + 
                              this.bartendeEscolhido.getNome());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.bartendeEscolhido.prepararBebida(coquetel, this.nome);

        this.serveBebida(nomeCliente);
    }
    
    /**
     * método na qual a bebida é servida
     * @param bebida
     * @param qtd 
     */
    private void serveBebida(String nomeCliente) {
        this.escreverMensagem(this.nome + " serviu o coquetel para " + nomeCliente);
    }
    
    /**
     * método que escolhe um bartender aleatório para preparar a bebida
     * @return 
     */
    private Bartender escolherBartender() {
        Random random = new Random();
        
        return bartenders.get(random.nextInt(bartenders.size()));
    }

    /**
     * método(s) implementado(s) da(s) interface(s)
     */
    @Override
    public void escreverMensagem(String mensagem) {
        tabelaLogs.addRow(new Object[]{mensagem});
    }
    
    @Override
    public void escreverMensagem(String mensagem, DefaultTableModel tabela) {
        tabela.addRow(new Object[]{mensagem});
    }
    
}
