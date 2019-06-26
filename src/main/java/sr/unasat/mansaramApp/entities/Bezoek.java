package sr.unasat.mansaramApp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "bezoek")
@Getter
@Setter
public class Bezoek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Patient> patients;

    @Column(name = "bevinding", nullable = false)
    private String bevinding;

    @Column(name = "bezoek_datum", nullable = false)
    private Timestamp timestamp;

    public Bezoek(List<Patient> patients, String bevinding) {
        this.patients = patients;
        this.bevinding = bevinding;
    }

    public Bezoek() {
    }
}
