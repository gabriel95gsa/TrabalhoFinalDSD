package assets;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servidor.InterfaceRemotaBar;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Garcom implements MensagensTabela {
    
    private List<Bartender> bartenders;
    private Bartender bartendeEscolhido;
    private String nome;
    private InterfaceRemotaBar repositorioBar;

    public Garcom(List<Bartender> bartenders, String nome) {
        this.bartenders = bartenders;
        this.nome = nome;
        
        try {
            this.repositorioBar = (InterfaceRemotaBar) Naming.lookup("rmi://0.0.0.0:443/ServidorBar");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
    public boolean pedirBebida(Coquetel coquetel, String nomeCliente) throws RemoteException {
        synchronized(this) {
            this.escreverMensagem(nomeCliente + " chamou o garçom " + 
                                  this.nome + " e pediu um coquetel de " + 
                                  coquetel.getDescricaoCoquetel());
            
            this.escreverMensagem(this.nome + " atendendendo " + nomeCliente);
            
            return this.pegarBebida(coquetel, nomeCliente);
        }
    }
    
    /**
     * método na qual é realizado o pedido ao bartender
     * @param coquetel
     * @param nomeCliente
     * @return
     * @throws RemoteException 
     */
    private boolean pegarBebida(Coquetel coquetel, String nomeCliente) throws RemoteException {
        this.bartendeEscolhido = this.escolherBartender();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.escreverMensagem(this.nome + " solicitou um coquetel composto de " +
                              coquetel.getDescricaoCoquetel() + " para o "  + 
                              this.bartendeEscolhido.getNome());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        if (this.bartendeEscolhido.prepararBebida(coquetel, this.nome) == true) {
            this.serveBebida(nomeCliente);
            return true;
        } else {
            this.escreverMensagem(this.nome + " informou para " + nomeCliente +
                                  " que o coquetel não pode ser feito devido a " +
                                  "falta de ingredientes");
            return false;
        }
    }
    
    /**
     * método na qual o coquetel é servido
     * @param nomeCliente 
     */
    private void serveBebida(String nomeCliente) {
        this.escreverMensagem(this.nome + " serviu o coquetel para " + nomeCliente);
    }
    
    /**
     * método que escolhe um bartender aleatório para preparar o coquetel
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
        try {
            this.repositorioBar.gravarLog(mensagem);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void escreverMensagem(String mensagem, DefaultTableModel tabela) {
        try {
            this.repositorioBar.gravarLog(mensagem);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
