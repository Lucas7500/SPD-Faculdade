package DAO;

import entities.Usuario;

import javax.persistence.*;
import java.util.List;

public abstract class BaseDAO {

    private static final String unidadeDePersistencia = "vacinacao";
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadeDePersistencia);

    protected <T> List<T> obterTodos(Class<T> tipo, String nomeTabela) {
        EntityManager em = emf.createEntityManager();
        String queryStr = "SELECT t FROM " + nomeTabela + " t";
        List<T> resultado = null;

        try {
            TypedQuery<T> query = em.createQuery(queryStr, tipo);
            resultado = query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return resultado;
    }

    protected <T> T obterPorId(Class<T> tipo, Long id) {
        EntityManager em = emf.createEntityManager();
        T resultado = null;

        try {
            resultado = em.find(tipo, id);
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return resultado;
    }

    protected <T> void criar(T obj) {
        EntityManager em = emf.createEntityManager();

        try {
            executarTransacao(() -> em.persist(obj), em);
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public <T> void deletar(Class<T> tipo, Long id) {
        EntityManager em = emf.createEntityManager();

        try {
            T obj = em.find(tipo, id);

            if (obj != null) {
                executarTransacao(() -> em.remove(obj), em);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private void executarTransacao(Runnable acao, EntityManager em) {
        em.getTransaction().begin();
        acao.run();
        em.getTransaction().commit();
    }
}
