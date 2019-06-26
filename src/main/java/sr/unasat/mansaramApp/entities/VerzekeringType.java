package sr.unasat.mansaramApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "verzekering_type")
@Getter
@Setter
public class VerzekeringType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

//    @JsonBackReference(value = "verzekeringType")
//    @OneToOne(mappedBy = "verzekeringType")
//    private Patient patient;

    public VerzekeringType() {
    }

    public VerzekeringType(String type) {
        this.type = type;
    }
}
