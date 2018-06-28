package assets;

import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servidor.InterfaceRemotaBar;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Bartender implements MensagensTabela {
    
    private String nome;
    private InterfaceRemotaBar repositorioBar;

    public Bartender(String nome) {
        this.nome = nome;
        
        // estabelece a conexão com o servidor do bar
        try {
            this.repositorioBar = (InterfaceRemotaBar) Naming.lookup("rmi://0.0.0.0:443/ServidorBar");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
     * método na qual o coquetel é preparado com os ingredientes
     * @param coquetel
     * @param nomeGarcom
     * @return
     * @throws RemoteException 
     */
    public boolean prepararBebida(Coquetel coquetel, String nomeGarcom) throws RemoteException {
        this.escreverMensagem(this.nome + " verificará se há ingredientes para a solicitação do garçom " + nomeGarcom);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        // Verifica as disponibilidade das bebidas do coquetel
        for (int i = 0; i < coquetel.getComposicao().size(); i++) {
            if (this.repositorioBar.getDisponibilidadeBebida(coquetel.getComposicao().get(i).getDescricao()) == false) {
                this.escreverMensagem(this.nome + " verificou e informou que não há mais doses da bebida " + 
                                      coquetel.getComposicao().get(i).getDescricao());
                return false;
            }
        }
        
        // Se todas as bebidas estão disponíveis, é decrementado o valor de doses
        for (int i = 0; i < coquetel.getComposicao().size(); i++) {
            this.repositorioBar.retiraDoseBebida(coquetel.getComposicao().get(i).getDescricao());
        }
        
        this.escreverMensagem(this.nome + " preparou o coquetel composto de " + coquetel.getDescricaoCoquetel());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.entregaBebida(coquetel, nomeGarcom);
        
        return true;
    }
    
    /**
     * método na qual o coquetel é entregue para o garçom
     * @param coquetel
     * @param nomeGarcom 
     */
    private void entregaBebida(Coquetel coquetel, String nomeGarcom) {
        this.escreverMensagem(this.nome + " entregou o coquetel composto de " + 
                              coquetel.getDescricaoCoquetel() + " para o garçom " + nomeGarcom);
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
