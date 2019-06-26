package sr.unasat.mansaramApp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "voornaam", nullable = false)
    private String voornaam;

    @Column(name = "achternaam", nullable = false)
    private String achternaam;

    @Column(name = "adres", nullable = false)
    private String adres;

    @Column(name = "verzekering_nr", nullable = false)
    private String verzekeringNummer;

    @Column(name = "geslacht", nullable = false)
    private String geslacht;

    @Column(name = "geb_datum", nullable = false)
//    @JsonSerialize(using = DateSerializer.class)
//    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDate gebDatum;

    @OneToOne
    @JoinColumn(name = "verzekering_id")
    private Verzekering verzekering;

    public Patient() {
    }

    public Patient(String voornaam, String achternaam, String adres, Verzekering verzekering, String verzekeringNummer, String geslacht, LocalDate gebDatum) {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.verzekering = verzekering;
        this.verzekeringNummer = verzekeringNummer;
        this.geslacht = geslacht;
        this.gebDatum = gebDatum;
    }
}
