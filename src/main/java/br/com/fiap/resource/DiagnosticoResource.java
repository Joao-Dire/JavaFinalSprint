package br.com.fiap.resource;

import br.com.fiap.bo.DiagnosticoBO;
import br.com.fiap.to.DiagnosticoTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/diagnosticos")
public class DiagnosticoResource {
    private DiagnosticoBO diagnosticoBO = new DiagnosticoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<DiagnosticoTO> resultado = diagnosticoBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        DiagnosticoTO resultado = diagnosticoBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    // Novo endpoint para buscar diagnósticos pelo ID do veículo
    @GET
    @Path("/veiculo/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByVeiculoId(@PathParam("id") int veiculoId) {
        ArrayList<DiagnosticoTO> resultado = diagnosticoBO.findByVeiculoId(veiculoId);
        Response.ResponseBuilder response = null;
        if (resultado != null && !resultado.isEmpty()) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid DiagnosticoTO diagnostico) {
        DiagnosticoTO resultado = diagnosticoBO.save(diagnostico);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Response.ResponseBuilder response = null;
        if (diagnosticoBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid DiagnosticoTO diagnostico, @PathParam("id") int id) {
        diagnostico.setIdDiagnostico(id);
        DiagnosticoTO resultado = diagnosticoBO.update(diagnostico);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
