package sr.unasat.mansaramApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VerzekeraarDto {

    private Long id;

    @NotNull
    private String naam;

//    private List<Patient> patientList;

    public VerzekeraarDto() {
    }

    public VerzekeraarDto(Long id, String naam) {
        this.id = id;
        this.naam = naam;
    }
}
