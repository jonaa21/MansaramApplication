package sr.unasat.mansaramApp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="verzekering")
@Getter
@Setter
public class Verzekering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "verzekeraar_id")
    private Verzekeraar verzekeraar;

    @ManyToOne
    @JoinColumn(name = "verz_type_id")
    private VerzekeringType verzekeringType;

    public Verzekering() {
    }
}
