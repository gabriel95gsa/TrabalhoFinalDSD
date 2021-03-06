package dao;

import dao.exceptions.NonexistentEntityException;
import model.Bebida;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

/**
 * @author Mateus Gomes, Gabriel Schenkel e Cristiano A. Flores
 */
public class DAOBebida implements Serializable {

    public DAOBebida() {
        this.emf = Persistence.createEntityManagerFactory("DSDPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bebida bebida) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bebida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bebida bebida) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bebida = em.merge(bebida);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = bebida.getId();
                if (findBebida(id) == null) {
                    throw new NonexistentEntityException("The bebida with id " + id + " no longer exists.");
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
            Bebida bebida;
            try {
                bebida = em.getReference(Bebida.class, id);
                bebida.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bebida with id " + id + " no longer exists.", enfe);
            }
            em.remove(bebida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Bebida findBebida(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bebida.class, id);
        } finally {
            em.close();
        }
    }

    public Long retornaBebidaID(String descricao) {
        Long id = null;
        EntityManager em = getEntityManager();
        List<Bebida> listaEncontrado = null;
        Query consulta = em.createQuery("select b from Bebida b");
        List<Bebida> listaBebida = consulta.getResultList();
        for (Bebida oBeb : listaBebida) {
            String desc = oBeb.getDescricao();
            if (desc.equalsIgnoreCase(descricao)) {
                id = oBeb.getId();
                break;
            }
        }
        return id;
    }
    
    public Bebida retornaBebida(String descricao) {
        EntityManager em = getEntityManager();
        List<Bebida> listaEncontrado = null;
        Query consulta = em.createQuery("select b from Bebida b where b.descricao = '" + descricao + "'");
        List<Bebida> listaBebida = consulta.getResultList();
        Bebida bebida = null;
        for (Bebida oBebida : listaBebida) {
            if (oBebida.getDescricao().equals(descricao)) {
                bebida = oBebida;
            }
        }
        
        return bebida;
    }

    public List<Bebida> retornaListaBebida() {
        EntityManager em = getEntityManager();
        Query consulta = em.createQuery("select b from Bebida b");
        List<Bebida> listaBebidas = consulta.getResultList();
        return listaBebidas;
    }
    
    public int retornaQtdDosesBebida(String descricao) {
        int doses = 0;
        EntityManager em = getEntityManager();
        List<Bebida> listaEncontrado = null;
        Query consulta = em.createQuery("select b from Bebida b where b.descricao = '" + descricao + "'");
        List<Bebida> listaBebida = consulta.getResultList();
        for (Bebida oBeb : listaBebida) {
            String desc = oBeb.getDescricao();
            if (desc.equalsIgnoreCase(descricao)) {
                doses = oBeb.getDoses();
                break;
            }
        }
        return doses;
    }
    
}
