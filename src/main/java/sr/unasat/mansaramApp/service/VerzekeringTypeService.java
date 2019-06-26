package sr.unasat.mansaramApp.service;

import sr.unasat.mansaramApp.config.JPAConfiguration;
import sr.unasat.mansaramApp.dao.*;
import sr.unasat.mansaramApp.entities.VerzekeringType;

import javax.persistence.EntityExistsException;
import java.util.List;

public class VerzekeringTypeService {

    private VerzekeringTypeDao verzekeringTypeDao;

    public VerzekeringTypeService() {
        verzekeringTypeDao = new VerzekeringTypeDao(JPAConfiguration.getEntityManager());
    }

    public List<VerzekeringType> getAllTypes(){
        return verzekeringTypeDao.getAll();
    }

    public boolean addType(VerzekeringType type){
        boolean isPersisted = true;
        try {
            verzekeringTypeDao.insert(type);
        } catch (EntityExistsException e) {
            isPersisted = false;
        }
        return isPersisted;
    }
}
