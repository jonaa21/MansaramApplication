package sr.unasat.mansaramApp.dao;

import sr.unasat.mansaramApp.entities.Verzekeraar;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class VerzekeraarDao {

    private EntityManager entityManager;

    public VerzekeraarDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Verzekeraar verzekeraar) throws SQLIntegrityConstraintViolationException {
        for (Verzekeraar verz : getAll()) {
            if (verz.getNaam().trim().equalsIgnoreCase(verzekeraar.getNaam().trim())){
                throw new SQLIntegrityConstraintViolationException();
            }
        }
        entityManager.getTransaction().begin();
        entityManager.persist(verzekeraar);
        entityManager.getTransaction().commit();
    }

    public List<Verzekeraar> getAll() {
        entityManager.getTransaction().begin();
        String jpql = "select v from Verzekeraar v";
        TypedQuery<Verzekeraar> query = entityManager.createQuery(jpql, Verzekeraar.class);
        List<Verzekeraar> verzekeraarList = query.getResultList();
        entityManager.getTransaction().commit();
        return verzekeraarList;
    }

    public Verzekeraar getVerzekeringById(Long id){
        entityManager.getTransaction().begin();
        String jpql = "select v from Verzekeraar v where v.id = :id";
        TypedQuery<Verzekeraar> query = entityManager.createQuery(jpql, Verzekeraar.class);
        query.setParameter("id", id);
        Verzekeraar verzekeraar = query.getSingleResult();
        entityManager.getTransaction().commit();
        return verzekeraar;
    }

    public Verzekeraar getVerzekeringByName(String name){
        entityManager.getTransaction().begin();
        String jpql = "select v from Verzekeraar v where v.naam like :name";
        TypedQuery<Verzekeraar> query = entityManager.createQuery(jpql, Verzekeraar.class);
        query.setParameter("name", name);
        Verzekeraar verzekeraar = query.getSingleResult();
        entityManager.getTransaction().commit();
        return verzekeraar;
    }
}
