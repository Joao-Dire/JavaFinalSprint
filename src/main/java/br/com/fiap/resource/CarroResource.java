package br.com.fiap.resource;

import br.com.fiap.bo.CarroBO;
import br.com.fiap.to.CarroTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/carro")
public class CarroResource {
    private CarroBO carroBO = new CarroBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findall() {
        ArrayList<CarroTO> resultado = carroBO.findall();
        if (resultado != null && !resultado.isEmpty()) {
            return Response.ok(resultado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Nada encontrado").build();
        }
    }
}

