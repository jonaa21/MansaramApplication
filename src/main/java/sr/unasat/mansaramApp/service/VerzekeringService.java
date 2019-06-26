package sr.unasat.mansaramApp.service;

import sr.unasat.mansaramApp.config.JPAConfiguration;
import sr.unasat.mansaramApp.dao.VerzekeringDao;
import sr.unasat.mansaramApp.entities.Verzekeraar;
import sr.unasat.mansaramApp.entities.Verzekering;

import java.util.List;

public class VerzekeringService {

    private VerzekeringDao verzekeringDao;

    public VerzekeringService() {
        verzekeringDao = new VerzekeringDao(JPAConfiguration.getEntityManager());
    }

    public List<Verzekering> getAllVerzekeraars(){
        return verzekeringDao.getAll();
    }

    public List<Verzekering> getVerzekeringenByVerzekeraar(Verzekeraar verzekeraar) {
        return verzekeringDao.getVerzekeringenByVerzekeraar(verzekeraar);
    }

//    public boolean addVerzekering(Verzekering verzekeraar){
//        boolean isPersisted = true;
//        try {
//            verzekeringDao.insert(verzekeraar);
//        } catch (SQLIntegrityConstraintViolationException e) {
//            isPersisted = false;
//        }
//        return isPersisted;
//    }
}
