package dao;

import dao.exceptions.NonexistentEntityException;
import model.Log;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class DAOLog implements Serializable {

    public DAOLog() {
        this.emf = Persistence.createEntityManagerFactory("DSDPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Log log) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Log log) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            log = em.merge(log);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = log.getId();
                if (findLog(id) == null) {
                    throw new NonexistentEntityException("The log with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Log log;
            try {
                log = em.getReference(Log.class, id);
                log.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The log with id " + id + " no longer exists.", enfe);
            }
            em.remove(log);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void excluirTodosLogs() {
        Long id = null;
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        List<Log> listaEncontrado = null;
        Query consulta = em.createQuery("select l from Log l");
        List<Log> listaLog = consulta.getResultList();
        for (Log oLog : listaLog) {
            em.remove(oLog);
        }
        em.getTransaction().commit();
    }

    public Log findLog(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Log.class, id);
        } finally {
            em.close();
        }
    }
    
    public Long retornaLogID(String descricao) {
        Long id = null;
        EntityManager em = getEntityManager();
        List<Log> listaEncontrado = null;
        Query consulta = em.createQuery("select l from Log l");
        List<Log> listaLog = consulta.getResultList();
        for (Log oLog : listaLog) {
            String desc = oLog.getDescricao();
            if (desc.equalsIgnoreCase(descricao)) {
                id = oLog.getId();
                break;
            }
        }
        return id;
    }
    
    public List<String> retornaListaLog() {
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("select l from Log l order by l.id");
        List<Log> listaConsulta = consulta.getResultList();
        List<String> listaLog = new ArrayList<>();
        for (Log oLog : listaConsulta) {
            listaLog.add(oLog.getDescricao());
        }
        return listaLog;
    }

}
