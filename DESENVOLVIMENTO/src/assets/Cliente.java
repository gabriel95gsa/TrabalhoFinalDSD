package assets;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Cliente implements Runnable, MensagensTabela {
    
    private String nome;
    private List<Garcom> garcons;
    private Garcom garcomEscolhido;
    private DefaultTableModel tabelaLogs;
    private MenuBebida menu;
    private boolean vip;
    private Random random;
    private Coquetel coquetel;

    public Cliente(List<Garcom> garcons, DefaultTableModel tabelaLogs, MenuBebida menu) {
        this.garcons = garcons;
        this.tabelaLogs = tabelaLogs;
        this.menu = menu;
        this.random = new Random();
        // escolhe aleatoriamente se o cliente será vip ou não
        this.vip = random.nextBoolean();
    }
    
    /**
     * Getters e Setters
     * @return 
     */
    public boolean isVip() {
        return vip;
    }
    
    /**
     * método na qual é realizado o pedido para o garçom
     * @param bebida
     * @param qtd 
     */
    private void queroBeber() {
        this.garcomEscolhido = this.escolherGarcom();
        
        this.escreverMensagem(this.nome + " entrou no bar");
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        this.escolherCoquetel();
        
        this.garcomEscolhido.pedirBebida(this.coquetel, this.nome);
        
        this.bebe();
    }
    
    /**
     * método na qual a bebida é consumida
     * @param bebida
     * @param qtd 
     */
    private void bebe() {
        String mensagem = this.nome + " bebeu sua bebida composta por " + 
                          this.coquetel.getDescricaoCoquetel();
        
        this.escreverMensagem(mensagem);
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
    }

    /**
     * método(s) implementado(s) da(s) interface(s)
     */
    @Override
    public void run() {
        this.nome = Thread.currentThread().getName();
        this.queroBeber();
    }

    @Override
    public void escreverMensagem(String mensagem) {
        if(this.vip == true) {
            mensagem =  "*VIP* " + mensagem;
        }
        tabelaLogs.addRow(new Object[]{mensagem});
    }
    
    @Override
    public void escreverMensagem(String mensagem, DefaultTableModel tabela) {
        if(this.vip == true) {
            mensagem =  "*VIP* " + mensagem;
        }
        tabela.addRow(new Object[]{mensagem});
    }
    
}
