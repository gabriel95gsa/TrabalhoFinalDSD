package assets;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Coquetel {
    
    private List<Bebida> composicao;

    public Coquetel(List<Bebida> coquetel) {
        this.composicao = coquetel;
    }
    
    public Coquetel() {
        this.composicao = new ArrayList<>();
    }

    /**
     * Getters e Setters
     */
    
    public List<Bebida> getComposicao() {
        return composicao;
    }

    public void setComposicao(List<Bebida> composicao) {
        this.composicao = composicao;
    }
    
    /**
     * método que adiciona uma bebida a composicao
     * @param bebida 
     */
    public void addBebida(Bebida bebida) {
        this.composicao.add(bebida);
    }
    
    /**
     * método que retorna uma string contendo as bebidas
 que compõem o composicao separadas por vírgula
     */
    public String getDescricaoCoquetel() {
        String descricao = "";
        
        for (Bebida item : this.composicao) {
            if (descricao.equals("")) {
                descricao += item.getDescricao();
            } else {
                descricao += item.getDescricao();
            }
            descricao += ", ";
        }
        
        if (descricao.substring(descricao.length() - 2, descricao.length()).equals(", ")) {
            return descricao.substring(0, descricao.length() - 2);
        } else {
            return descricao;
        }
    }
    
}
