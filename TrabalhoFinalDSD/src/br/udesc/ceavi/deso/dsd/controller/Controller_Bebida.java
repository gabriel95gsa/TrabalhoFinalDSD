package br.udesc.ceavi.deso.dsd.controller;

import br.udesc.ceavi.deso.dsd.dao.DAOBebida;
import br.udesc.ceavi.deso.dsd.dao.exceptions.NonexistentEntityException;
import br.udesc.ceavi.deso.dsd.model.Bebida;
import java.util.List;

/**
 * @author Mateus A. Gomes
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

//    MÉTODO QUE RETORNA TODOS OS BEBIDAS DA TABELA DO BANCO DE DADOS RETORNA UM ARRAY DE BEBIDAS
    public List retornaListaBebida() {
        return bebidaDAO.retornaListaBebida();
    }
}
