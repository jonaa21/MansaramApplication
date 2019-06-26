package sr.unasat.mansaramApp.dao;

import sr.unasat.mansaramApp.entities.VerzekeringType;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VerzekeringTypeDao {

    private EntityManager entityManager;

    public VerzekeringTypeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(VerzekeringType verzekeringType){
        for (VerzekeringType verzType : getAll()) {
            if (verzType.getType().trim().equalsIgnoreCase(verzekeringType.getType().trim())){
                throw new EntityExistsException();
            }
        }
        entityManager.getTransaction().begin();
        entityManager.persist(verzekeringType);
        entityManager.getTransaction().commit();
    }

    public List<VerzekeringType> getAll() {
        entityManager.getTransaction().begin();
        String jpql = "select verzType from VerzekeringType verzType";
        TypedQuery<VerzekeringType> query = entityManager.createQuery(jpql, VerzekeringType.class);
        List<VerzekeringType> types = query.getResultList();
        entityManager.getTransaction().commit();
        return types;
    }

    public VerzekeringType getTypeByName(String name){
        entityManager.getTransaction().begin();
        String jpql = "select vt from VerzekeringType vt where vt.type like :name";
        TypedQuery<VerzekeringType> query = entityManager.createQuery(jpql, VerzekeringType.class);
        query.setParameter("name", name);
        VerzekeringType type = query.getSingleResult();
        entityManager.getTransaction().commit();
        return type;
    }
}
