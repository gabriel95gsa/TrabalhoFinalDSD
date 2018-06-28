package controller;

import dao.DAOBebida;
import dao.exceptions.NonexistentEntityException;
import model.Bebida;
import java.util.List;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Controller_Bebida {

    DAOBebida bebidaDAO = new DAOBebida();

    public void adicionarBebida(Bebida b) {
        bebidaDAO.create(b);
    }

    public void removerBebida(Long id) throws NonexistentEntityException {
        bebidaDAO.destroy(id);
    }

    public void editarBebida(Bebida b) throws Exception {
        bebidaDAO.edit(b);
    }

    public Bebida procurarBebida(Bebida b) {
        return bebidaDAO.findBebida(b.getId());
    }

    public Long procuraBebida(String nome) {
        return bebidaDAO.retornaBebidaID(nome);
    }

    /**
     * MÉTODO QUE RETORNA TODOS OS BEBIDAS DA TABELA DO BANCO DE DADOS RETORNA UM ARRAY DE BEBIDAS
     * @return 
     */
    public List retornaListaBebida() {
        return bebidaDAO.retornaListaBebida();
    }
    
    public int qtdDosesDisponiveis(String nome) {
        return bebidaDAO.retornaQtdDosesBebida(nome);
    }
    
    public void diminuiQtdDosesDisponiveis(String nome) {
        Bebida bebida = bebidaDAO.retornaBebida(nome);
        
        bebida.setDoses(bebida.getDoses() - 1);
        
        try {
            bebidaDAO.edit(bebida);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
