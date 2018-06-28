package view;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import servidor.InterfaceRemotaBar;

/**
 *
 * @authores Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class TabelaLogs implements Runnable {

    private DefaultTableModel tabela;
    private InterfaceRemotaBar repositorioBar;
    private JButton botaoComecar;

    public TabelaLogs(DefaultTableModel table, JButton botaoComecar) {
        this.tabela = table;
        this.botaoComecar = botaoComecar;
        
        try {
            this.repositorioBar = (InterfaceRemotaBar) Naming.lookup("rmi://0.0.0.0:443/ServidorBar");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        this.limpaTabela();
        try {
            this.repositorioBar.excluirTodosLogs();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    private void limpaTabela() {
        this.tabela.setRowCount(0);
    }
    
    private void atualizaTabela() {
        List<String> listaLogs;
        try {
            listaLogs = this.repositorioBar.getListaLogs();
            
            if(listaLogs.size() > 0 && listaLogs.size() > this.tabela.getRowCount()) {
                for(int i = this.tabela.getRowCount(); i < listaLogs.size(); i++) {
                    this.tabela.addRow(new Object[]{listaLogs.get(i)});
                }
            }
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * método(s) implementado(s) da(s) interface(s)
     */
    
    @Override
    public void run() {
        while (true) {
            this.botaoComecar.setEnabled(false);
            this.atualizaTabela();
            
            try {
                Thread.sleep(2000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
