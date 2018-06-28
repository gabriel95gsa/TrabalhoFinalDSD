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
public class Cliente implements Runnable, MensagensTabela {
    
    private String nome;
    private List<Garcom> garcons;
    private Garcom garcomEscolhido;
    private MenuBebida menu;
    private boolean vip;
    private Random random;
    private Coquetel coquetel;
    private InterfaceRemotaBar repositorioBar;
    private int qtdPedidosNegados;
    private int contNivelBebado;

    public Cliente(List<Garcom> garcons, MenuBebida menu) {
        this.garcons = garcons;
        this.menu = menu;
        this.random = new Random();
        // escolhe aleatoriamente se o cliente será vip ou não
        this.vip = random.nextBoolean();
        this.qtdPedidosNegados = 0;
        this.contNivelBebado = 0;
        
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
    public boolean isVip() {
        return vip;
    }
    
    private void entrarNoBar() throws RemoteException {
        this.escreverMensagem(this.nome + " entrou no bar");
        
        this.queroBeber();
    }
    
    /**
     * método na qual é realizado o pedido para o garçom
     */
    private void queroBeber() throws RemoteException {
        this.garcomEscolhido = this.escolherGarcom();
        
        this.escolherCoquetel();
        
        if (this.garcomEscolhido.pedirBebida(this.coquetel, this.nome) == true) {
            this.bebe();
        } else {
            this.escreverMensagem(this.nome + " pensará em outro coquetel");
            
            this.qtdPedidosNegados++;
            
            // Se o cliente tiver 5 pedidos negados, sua prioridade se torna máxima
            if (this.qtdPedidosNegados >= 5) {
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
            }
            
            this.queroBeber();
        }
    }
    
    /**
     * método na qual o coquetel é consumido
     */
    private void bebe() throws RemoteException {
        this.escreverMensagem(this.nome + " bebeu seu coquetel composto de " + 
                              this.coquetel.getDescricaoCoquetel());
        
        // a cada bebida de coquetel o nível aumenta em 2
        this.contNivelBebado += 2;
        
        if (this.contNivelBebado >= 10) {
            this.escreverMensagem(this.nome + " está bêbado demais e precisa " + 
                                  " ser conduzido até a saída");
        } else {
            this.queroBeber();
        }
    }
    
    /**
     * método que escolhe um garçom aleatório para atendimento
     * @return 
     */
    private Garcom escolherGarcom() {
        return garcons.get(this.random.nextInt(garcons.size()));
    }
    
    /**
     * método que escolhe a(s) bebida(s) que o cliente pedirá
     * cliente poderá pedir até 3 bebidas para o coquetel
     * @return 
     */
    private void escolherCoquetel() {
        int nroBebidas = (this.random.nextInt(3)) + 1;
        
        this.coquetel = new Coquetel();
        
        for (int i = 0; i < nroBebidas; i++) {
            // escolhe uma bebida aleatoriamente do menu
            this.coquetel.addBebida(this.menu.getBebidas().get(this.random.nextInt(this.menu.getNroBebidasMenu())));
        }
        
        this.escreverMensagem(this.nome + " olhou o menu na mesa e escolheu um coquetel de " + 
                              this.coquetel.getDescricaoCoquetel());
    }

    /**
     * método(s) implementado(s) da(s) interface(s)
     */
    @Override
    public void run() {
        this.nome = Thread.currentThread().getName();
        try {
            this.entrarNoBar();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void escreverMensagem(String mensagem) {
        if(this.vip == true) {
            mensagem =  "*VIP* " + mensagem;
        }
        try {
            this.repositorioBar.gravarLog(mensagem);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void escreverMensagem(String mensagem, DefaultTableModel tabela) {
        if(this.vip == true) {
            mensagem =  "*VIP* " + mensagem;
        }
        try {
            this.repositorioBar.gravarLog(mensagem);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
