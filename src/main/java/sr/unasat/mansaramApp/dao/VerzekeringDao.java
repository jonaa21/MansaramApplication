package sr.unasat.mansaramApp.dao;

import sr.unasat.mansaramApp.entities.Verzekeraar;
import sr.unasat.mansaramApp.entities.Verzekering;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VerzekeringDao {

    private EntityManager entityManager;

    public VerzekeringDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    public void insert(Verzekering verzekering) throws SQLIntegrityConstraintViolationException {
//        for (Verzekeraar verz : getAll()) {
//            if (verz.getNaam().trim().equalsIgnoreCase(verzekering.getNaam().trim())){
//                throw new SQLIntegrityConstraintViolationException();
//            }
//        }
//        entityManager.getTransaction().begin();
//        entityManager.persist(verzekering);
//        entityManager.getTransaction().commit();
//    }

    public List<Verzekering> getAll() {
        entityManager.getTransaction().begin();
        String jpql = "select v from Verzekering v";
        TypedQuery<Verzekering> query = entityManager.createQuery(jpql, Verzekering.class);
        List<Verzekering> verzekeringList = query.getResultList();
        entityManager.getTransaction().commit();
        return verzekeringList;
    }

    public Verzekering getVerzekeringById(Long id){
        entityManager.getTransaction().begin();
        String jpql = "select v from Verzekering v where v.id = :id";
        TypedQuery<Verzekering> query = entityManager.createQuery(jpql, Verzekering.class);
        query.setParameter("id", id);
        Verzekering verzekering = query.getSingleResult();
        entityManager.getTransaction().commit();
        return verzekering;
    }

    public List<Verzekering> getVerzekeringenByVerzekeraar(Verzekeraar verzekeraar) {
        entityManager.getTransaction().begin();
        String jpql = "select v from Verzekering v where v.verzekeraar = :verzekeraar";
        TypedQuery<Verzekering> query = entityManager.createQuery(jpql, Verzekering.class);
        query.setParameter("verzekeraar", verzekeraar);
        List<Verzekering> verzekeringen = query.getResultList();
        entityManager.getTransaction().commit();
        return verzekeringen;
    }
}
