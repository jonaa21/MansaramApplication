package sr.unasat.mansaramApp.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.mansaramApp.dto.VerzekeraarDto;
import sr.unasat.mansaramApp.dto.VerzekeringTypeDto;
import sr.unasat.mansaramApp.entities.Verzekeraar;
import sr.unasat.mansaramApp.entities.VerzekeringType;
import sr.unasat.mansaramApp.service.VerzekeringTypeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("verz-type")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VerzekeraarTypeController {

    private VerzekeringTypeService verzTypeService = new VerzekeringTypeService();
    private ModelMapper modelMapper = new ModelMapper();

    @Path("/list")
    @GET
    public Response getList(){
        List<VerzekeringType> verzekeraars = verzTypeService.getAllTypes();
        List<VerzekeringTypeDto> typeDtos = new ArrayList<>();
        verzekeraars.forEach(vt ->
                typeDtos.add(modelMapper.map(vt, VerzekeringTypeDto.class)));
        return Response.ok(typeDtos).build();
    }
}
