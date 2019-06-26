package sr.unasat.mansaramApp.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.mansaramApp.dto.PatientDto;
import sr.unasat.mansaramApp.dto.VerzekeraarDto;
import sr.unasat.mansaramApp.entities.Verzekeraar;
import sr.unasat.mansaramApp.service.VerzekeraarService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("verzekeraar")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VerzekeraarController {

    private VerzekeraarService verzekeraarService = new VerzekeraarService();
    private ModelMapper modelMapper = new ModelMapper();

    @Path("/list")
    @GET
    public Response getList(){
        List<Verzekeraar> verzekeraars = verzekeraarService.getAllVerzekeraars();
        List<VerzekeraarDto> verzekeraarDtoList = new ArrayList<>();
        verzekeraars.forEach(v ->
                verzekeraarDtoList.add(modelMapper.map(v, VerzekeraarDto.class)));
        return Response.ok(verzekeraarDtoList).build();
    }
}
