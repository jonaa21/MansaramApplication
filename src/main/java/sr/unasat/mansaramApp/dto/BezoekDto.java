package sr.unasat.mansaramApp.dto;

import lombok.Getter;
import lombok.Setter;
import sr.unasat.mansaramApp.entities.Patient;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class BezoekDto {

    private Long id;

    @NotNull
    private Patient patient;

    @NotNull
    @Max(255)
    private String bevinding;

    @NotNull
    private LocalDateTime timestamp;

    public BezoekDto() {
    }

    public BezoekDto(Patient patient, String bevinding) {
        this.patient = patient;
        this.bevinding = bevinding;
        setTimestamp(LocalDateTime.now());
    }
}
