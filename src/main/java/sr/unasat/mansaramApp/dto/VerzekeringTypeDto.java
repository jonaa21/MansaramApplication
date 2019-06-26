package sr.unasat.mansaramApp.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VerzekeringTypeDto {

    private Long id;

    @NotNull
    private String type;

//    private Patient patient;

    public VerzekeringTypeDto() {
    }

    public VerzekeringTypeDto(Long id, String type) {
        this.id = id;
        this.type = type;
    }
}
