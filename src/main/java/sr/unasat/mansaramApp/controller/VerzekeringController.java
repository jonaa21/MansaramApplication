package sr.unasat.mansaramApp.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.mansaramApp.dto.VerzekeraarDto;
import sr.unasat.mansaramApp.dto.VerzekeringDto;
import sr.unasat.mansaramApp.entities.Verzekeraar;
import sr.unasat.mansaramApp.entities.Verzekering;
import sr.unasat.mansaramApp.service.VerzekeringService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("verz")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VerzekeringController {

    private VerzekeringService verzService = new VerzekeringService();
    private ModelMapper modelMapper = new ModelMapper();

    @Path("/list")
    @GET
    public Response getList(){
        List<Verzekering> verzekeringList = verzService.getAllVerzekeraars();
        List<VerzekeringDto> verzekeraarDtoList = new ArrayList<>();
        verzekeringList.forEach(v ->
                verzekeraarDtoList.add(modelMapper.map(v, VerzekeringDto.class)));
        return Response.ok(verzekeraarDtoList).build();
    }

    @Path("/getVerzekeraar")
    @GET
    public Response getVerzekeringenByVerzekeraar(VerzekeraarDto verzekeraar) {
        Verzekeraar verz = modelMapper.map(verzekeraar, Verzekeraar.class);
        List<Verzekering> verzekeringen = verzService.getVerzekeringenByVerzekeraar(verz);
        return Response.ok(verzekeringen).build();
    }
}
