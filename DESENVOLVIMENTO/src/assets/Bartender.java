package assets;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Bartender implements MensagensTabela {
    
    private String nome;
    private DefaultTableModel tabelaLogs;

    public Bartender(String nome, DefaultTableModel tabelaLogs) {
        this.nome = nome;
        this.tabelaLogs = tabelaLogs;
    }
    
    /**
     * Getters e Setters
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
    public void prepararBebida(Coquetel coquetel, String nomeGarcom) {
        this.escreverMensagem(this.nome + " verificará se há ingredientes para a solicitação do garçom " + nomeGarcom);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.escreverMensagem(this.nome + " preparou a bebida composta por " + coquetel.getDescricaoCoquetel());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.entregaBebida(coquetel, nomeGarcom);
    }
    
    /**
     * método na qual a bebida é entregue para o garçom
     * @param bebida
     * @param qtd 
     */
    private void entregaBebida(Coquetel coquetel, String nomeGarcom) {
        this.escreverMensagem(this.nome + " entregou a bebida composta por " + 
                              coquetel.getDescricaoCoquetel() + " para o garçom " + nomeGarcom);
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
