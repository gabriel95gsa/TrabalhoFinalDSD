package controller;

import dao.DAOLog;
import dao.exceptions.NonexistentEntityException;
import model.Log;
import java.util.List;

/**
 *
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class Controller_Log {

    DAOLog logDAO = new DAOLog();

    /**
     * MÉTODO DE ADICIONAR UM OBJETO NA TABELA DE LOG
     * @param log 
     */
    public void adicionarLog(Log log) {
        logDAO.create(log);
    }

    /**
     * MÉTODO DE REMOVER UM OBJETO NA TABELA LOG ATRAVÉS DO ID
     * @param id
     * @throws NonexistentEntityException 
     */
    public void removerLog(Long id) throws NonexistentEntityException {
        logDAO.destroy(id);
    }

    /**
     * MÉTODO DE EDITAR O OBJETO LOG
     * @param log
     * @throws Exception 
     */
    public void editarLog(Log log) throws Exception {
        logDAO.edit(log);
    }

    /**
     * MÉTODO DE PROCURAR UM LOG PELO ID
     * POREM COMO O ID É GERADO PELO BANCO, 
     * NÃO CONSEGUIMOS PESQUISAR ELE PELO ID
     * @param log
     * @return 
     */
    public Log procurarLogId(Log log) {
        return logDAO.findLog(log.getId());
    }

    /**
     * MÉTODO DE PROCURAR UM LOG PELO NOME
     * MÉTODO UTILIZADO PELA CONSULTA NO BANCO, 
     * PASSAMOS A CONSULTA ATRAVÉS DA DESCRIÇÃO DO LOG
     * @param nome
     * @return 
     */
    public Long procuraLogNome(String nome) {
        return logDAO.retornaLogID(nome);
    }

    /**
     * MÉTODO QUE RETORNA TODOS OS LOGS DA TABELA 
     * DO BANCO DE DADOS RETORNA UM ARRAY DE LOGS
     * @return 
     */
    public List retornaListaLog() {
        return logDAO.retornaListaLog();
    }
    
    /**
     * MÉTODO QUE EXCLUI TODOS OS REGISTROS DE LOG
     */
    public void excluirTodosLogs() {
        logDAO.excluirTodosLogs();
    }
    
}
