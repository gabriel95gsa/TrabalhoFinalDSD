package assets;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public interface MensagensTabela {
    
    public void escreverMensagem(String mensagem);
    
    public void escreverMensagem(String mensagem, DefaultTableModel tabela);
    
}
