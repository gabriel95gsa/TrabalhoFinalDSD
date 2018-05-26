/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.deso.dsd.controller;

import br.udesc.ceavi.deso.dsd.dao.DAOLog;
import br.udesc.ceavi.deso.dsd.dao.exceptions.NonexistentEntityException;
import br.udesc.ceavi.deso.dsd.model.Log;
import java.util.List;

/**
 *
 * @author Mateus A. Gomes
 */
public class Controller_Log {

    DAOLog logDAO = new DAOLog();

//    MÉTODO DE ADICIONAR UM OBJETO NA TABELA DE LOG
    public void adicionarLog(Log log) {
        logDAO.create(log);
    }

//    MÉTODP DE REMOVER UM OBJETO NA TABELA LOG ATRAVÉS DO ID
    public void removerLog(Long id) throws NonexistentEntityException {
        logDAO.destroy(id);
    }

//    MÉTODO DE EDITAR O OBJETO LOG
    public void editarLog(Log log) throws Exception {
        logDAO.edit(log);
    }

//    MÉTODO DE PROCURAR UM LOG PELO ID
//    POREM COMO O ID É GERADO PELO BANCO, NÃO CONSEGUIMOS PESQUISAR ELE PELO ID
    public Log procurarLogId(Log log) {
        return logDAO.findLog(log.getId());
    }

//    MÉTODO DE PROCURAR UM LOG PELO NOME
//    MÉTODO UTILIZADO PELA CONSULTA NO BANCO, PASSAMOS A CONSULTA ATRAVÉS DA DESCRIÇÃO DO LOG
    public Long procuraLogNome(String nome) {
        return logDAO.retornaLogID(nome);
    }

//    MÉTODO QUE RETORNA TODOS OS LOGS DA TABELA DO BANCO DE DADOS RETORNA UM ARRAY DE LOGS
    public List retornaListaLog() {
        return logDAO.retornaListaLog();
    }
}
