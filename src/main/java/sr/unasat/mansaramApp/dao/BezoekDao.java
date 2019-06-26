package sr.unasat.mansaramApp.dao;

import sr.unasat.mansaramApp.entities.Bezoek;
import sr.unasat.mansaramApp.entities.Patient;
import sr.unasat.mansaramApp.entities.Verzekeraar;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BezoekDao {

    private EntityManager entityManager;

    public BezoekDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Bezoek> getBezoekPerPatient(Patient patient) {
        entityManager.getTransaction().begin();
        String jpql = "select b from Bezoek b where b.patient = :patient";
        TypedQuery<Bezoek> query = entityManager.createQuery(jpql, Bezoek.class);
        query.setParameter("patient", patient);
        List<Bezoek> bezoekList = query.getResultList();
        entityManager.getTransaction().commit();
        return bezoekList;
    }

    public List<Bezoek> getBezoekByVerzekeraar(Verzekeraar verzekeraar) {
        entityManager.getTransaction().begin();
        String jpql = "select b from Bezoek b where b.patient.verzekering.verzekeraar = :verzekeraar";
        TypedQuery<Bezoek> query = entityManager.createQuery(jpql, Bezoek.class);
        query.setParameter("verzekeraar", verzekeraar);
        List<Bezoek> bezoekList = query.getResultList();
        entityManager.getTransaction().commit();
        return bezoekList;
    }

    public void insertBezoek(Bezoek bezoek) {
        entityManager.getTransaction().begin();
        entityManager.persist(bezoek);
        entityManager.getTransaction().commit();
    }
}
