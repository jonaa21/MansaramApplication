package sr.unasat.mansaramApp.dao;

import sr.unasat.mansaramApp.entities.Patient;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PatientDao {

    private EntityManager entityManager;

    public PatientDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Patient patient) {
        for (Patient p : getAll()){
            if ((p.getAchternaam().trim().equalsIgnoreCase(patient.getAchternaam().trim()) ||
                    p.getVoornaam().trim().equalsIgnoreCase(patient.getVoornaam().trim())) &&
                    p.getVerzekeringNummer().trim().equalsIgnoreCase(patient.getVerzekeringNummer().trim())){
                throw new EntityExistsException();
            }
        }
        entityManager.getTransaction().begin();
        entityManager.persist(patient);
        entityManager.getTransaction().commit();
    }

    public List<Patient> getAll() {
        entityManager.getTransaction().begin();
        String jpql = "select p from Patient p";
        TypedQuery<Patient> query = entityManager.createQuery(jpql, Patient.class);
        List<Patient> patients = query.getResultList();
        entityManager.getTransaction().commit();
        return patients;
    }

    public Patient getPatientById(Long id) {
        entityManager.getTransaction().begin();
        String jpql = "select p from Patient p where p.id = :id";
        TypedQuery<Patient> query = entityManager.createQuery(jpql, Patient.class);
        query.setParameter("id", id);
        Patient patient = query.getSingleResult();
        entityManager.getTransaction().commit();
        return patient;
    }
}
