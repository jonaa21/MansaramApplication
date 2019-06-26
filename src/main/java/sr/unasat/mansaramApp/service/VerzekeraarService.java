package sr.unasat.mansaramApp.service;

import sr.unasat.mansaramApp.config.JPAConfiguration;
import sr.unasat.mansaramApp.dao.VerzekeraarDao;
import sr.unasat.mansaramApp.entities.Verzekeraar;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class VerzekeraarService {

    private VerzekeraarDao verzekeraarDao;

    public VerzekeraarService() {
        verzekeraarDao = new VerzekeraarDao(JPAConfiguration.getEntityManager());
    }

    public List<Verzekeraar> getAllVerzekeraars(){
        return verzekeraarDao.getAll();
    }

    public boolean addVerzekering(Verzekeraar verzekeraar){
        boolean isPersisted = true;
        try {
            verzekeraarDao.insert(verzekeraar);
        } catch (SQLIntegrityConstraintViolationException e) {
            isPersisted = false;
        }
        return isPersisted;
    }
}
