package sr.unasat.mansaramApp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "verzekeraar")
@Getter
@Setter
public class Verzekeraar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naam", nullable = false)
    private String naam;

//    @JsonBackReference(value = "verzekering")
//    @OneToMany(mappedBy = "verzekering", fetch = FetchType.LAZY)
//    private List<Patient> patients;

    public Verzekeraar() {
    }

    public Verzekeraar(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return "Verzekeraar{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                '}';
    }
}
