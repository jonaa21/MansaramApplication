import sr.unasat.mansaramApp.config.JPAConfiguration;
import sr.unasat.mansaramApp.dao.VerzekeraarDao;
import sr.unasat.mansaramApp.dao.VerzekeringDao;
import sr.unasat.mansaramApp.entities.Verzekeraar;
import sr.unasat.mansaramApp.entities.Verzekering;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationPath("api")
public class ApplicationConfig extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "sr.unasat.mansaramApp.controller");
        return properties;
    }

    public static void main(String[] args) {
        VerzekeringDao verzekeringDao = new VerzekeringDao(JPAConfiguration.getEntityManager());
        VerzekeraarDao verzekeraarDao = new VerzekeraarDao(JPAConfiguration.getEntityManager());
        Verzekeraar verz = verzekeraarDao.getVerzekeringById(Long.parseLong("2"));
        List<Verzekering> verzekering = verzekeringDao.getVerzekeringByVerzekeraar(verz);
        verzekering.stream().forEach(v -> System.out.println(v.getVerzekeraar().toString()));

    }
}
