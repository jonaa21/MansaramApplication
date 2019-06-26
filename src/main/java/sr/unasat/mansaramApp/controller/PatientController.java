package sr.unasat.mansaramApp.controller;

import org.modelmapper.ModelMapper;
import sr.unasat.mansaramApp.dto.PatientDto;
import sr.unasat.mansaramApp.entities.Patient;
import sr.unasat.mansaramApp.service.PatientService;
import sr.unasat.mansaramApp.service.VerzekeraarService;
import sr.unasat.mansaramApp.service.VerzekeringTypeService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("patient")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PatientController {

    private PatientService patientService = new PatientService();
    private VerzekeringTypeService verzekeringTypeService = new VerzekeringTypeService();
    private VerzekeraarService verzekeraarService = new VerzekeraarService();
    private ModelMapper modelMapper = new ModelMapper();

    @POST
    @Path("/add")
    public Response insert(@Valid PatientDto patientDto){
//        Verzekeraar naam = modelMapper.map(patientDto.getVerzekering(), Verzekeraar.class);
//        VerzekeringType verzekeringType = modelMapper
//                .map(patientDto.getVerzekering(), VerzekeringType.class);
        Patient patient = modelMapper.map(patientDto, Patient.class);
//        verzekeraarService.addVerzekering(naam);
//        verzekeringTypeService.addType(verzekeringType);
        boolean isSuccess = patientService.insertPatient(patient);

        return Response.ok(isSuccess).build();
    }

    @Path("/list")
    @GET
    public Response getList(){
        List<Patient> patients = patientService.getAllPatients();
        List<PatientDto> patientDtoList = new ArrayList<>();
        patients.forEach(p ->
                patientDtoList.add(modelMapper.map(p, PatientDto.class)));
        return Response.ok(patientDtoList).build();
    }
}
