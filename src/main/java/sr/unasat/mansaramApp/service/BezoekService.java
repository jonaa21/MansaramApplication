package sr.unasat.mansaramApp.service;

import sr.unasat.mansaramApp.config.JPAConfiguration;
import sr.unasat.mansaramApp.dao.BezoekDao;
import sr.unasat.mansaramApp.entities.Bezoek;
import sr.unasat.mansaramApp.entities.Patient;
import sr.unasat.mansaramApp.entities.Verzekeraar;

import java.util.List;

public class BezoekService {

    private BezoekDao bezoekDao;

    public BezoekService() {
        this.bezoekDao = new BezoekDao(JPAConfiguration.getEntityManager());
    }

    public List<Bezoek> getAllBezoekenPerPatient(Patient patient) {
        return bezoekDao.getBezoekPerPatient(patient);
    }

    public List<Bezoek> getAllBezoekenPerVerzekeraar(Verzekeraar verzekeraar) {
        return bezoekDao.getBezoekByVerzekeraar(verzekeraar);
    }
}
