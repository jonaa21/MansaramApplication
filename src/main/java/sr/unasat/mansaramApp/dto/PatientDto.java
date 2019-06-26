package sr.unasat.mansaramApp.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import sr.unasat.mansaramApp.entities.Verzekering;
import sr.unasat.mansaramApp.utils.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class PatientDto {

    private Long id;

    @NotNull
    private String voornaam;

    @NotNull
    private String achternaam;

    @NotNull
    private String adres;

//    @NotNull
    private Verzekering verzekering;

    @NotNull
    private String verzekeringNummer;

    @NotNull
    @Max(1)
    private String geslacht;

    @NotNull
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date gebDatum;

    public PatientDto() {
    }

    public PatientDto(Long id, String voornaam, String achternaam, String adres, Verzekering verzekering, String verzekeringNummer, String geslacht, Date gebDatum) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.adres = adres;
        this.verzekering = verzekering;
        this.verzekeringNummer = verzekeringNummer;
        this.geslacht = geslacht;
        this.gebDatum = gebDatum;
    }
}
