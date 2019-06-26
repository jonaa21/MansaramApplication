package sr.unasat.mansaramApp.service;

import sr.unasat.mansaramApp.config.JPAConfiguration;
import sr.unasat.mansaramApp.dao.PatientDao;
import sr.unasat.mansaramApp.dao.VerzekeraarDao;
import sr.unasat.mansaramApp.dao.VerzekeringTypeDao;
import sr.unasat.mansaramApp.entities.Patient;

import javax.persistence.EntityExistsException;
import java.util.List;

public class PatientService {

    private PatientDao patientDao;
    private VerzekeringTypeDao verzekeringTypeDao;
    private VerzekeraarDao verzekeraarDao;

    public PatientService() {
        patientDao = new PatientDao(JPAConfiguration.getEntityManager());
        verzekeraarDao = new VerzekeraarDao(JPAConfiguration.getEntityManager());
        verzekeringTypeDao = new VerzekeringTypeDao(JPAConfiguration.getEntityManager());
    }

    public List<Patient> getAllPatients(){
        return patientDao.getAll();
    }

    public boolean insertPatient(Patient patient){
        boolean isPersisted = true;
        try {
//            patient.setVerzekering(verzekeraarDao
//                    .getVerzekeringByName(patient.getVerzekering().getVerzekering()));
//            patient.setVerzekeringType(verzekeringTypeDao
//                    .getTypeByName(patient.getVerzekeringType().getType()));
            patientDao.insert(patient);
        } catch (EntityExistsException e) {
            isPersisted = false;
        }
        return isPersisted;
    }
}
