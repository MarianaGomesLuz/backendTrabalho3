package aula.web.adivinhe.ws;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/status")
public class MonitorResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String status() {
        return "Serviço ativo";
    }
}