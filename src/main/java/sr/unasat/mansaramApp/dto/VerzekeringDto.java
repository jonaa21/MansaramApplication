package sr.unasat.mansaramApp.dto;

import lombok.Getter;
import lombok.Setter;
import sr.unasat.mansaramApp.entities.Verzekering;
import sr.unasat.mansaramApp.entities.VerzekeringType;

@Getter
@Setter
public class VerzekeringDto {

    private Long id;

    private Verzekering verzekering;

    private VerzekeringType verzekeringType;

    public VerzekeringDto() {
    }

    public VerzekeringDto(Long id, Verzekering verzekering, VerzekeringType verzekeringType) {
        this.id = id;
        this.verzekering = verzekering;
        this.verzekeringType = verzekeringType;
    }
}
