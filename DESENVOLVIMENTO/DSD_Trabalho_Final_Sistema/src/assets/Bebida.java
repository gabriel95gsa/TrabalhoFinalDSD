package assets;

/**
 *
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Bebida {
    
    private String descricao;

    public Bebida(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Getters e Setters
     */
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
