package sr.unasat.mansaramApp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bezoek")
@Getter
@Setter
public class Bezoek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Patient patient;

    @Column(name = "bevinding", nullable = false)
    private String bevinding;

    @Column(name = "bezoek_datum", nullable = false)
    private LocalDateTime timestamp;

    public Bezoek(Patient patient, String bevinding) {
        this.patient = patient;
        this.bevinding = bevinding;
        setTimestamp(LocalDateTime.now());
    }

    public Bezoek() {
    }

    @Override
    public String toString() {
        return "Bezoek{" +
                "id=" + id +
                ", patient=" + patient +
                ", bevinding='" + bevinding + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
