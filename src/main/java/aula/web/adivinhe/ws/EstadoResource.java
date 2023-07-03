package aula.web.adivinhe.ws;

import aulas.web.adivinhe.entity.Estado;
import aulas.web.adivinhe.entity.Jogo;
import aulas.web.adivinhe.entity.JogoPK;
import aulas.web.adivinhe.entity.Municipio;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import java.net.URI;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.jboss.resteasy.reactive.RestQuery;

@Path("/estado")
public class EstadoResource {

    public static final int limitePagina = 50;
            
    // Endpoint Obter a relação de todos os estados
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listEstados() {
        var estados = Estado.listAll();
        return Response.ok(estados).build();
    }

    // Endpoint Obter as informações de um estado específico
    @GET
    @Path("/{uf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Estado infoEstado(String uf) {
        Estado estadoSelecionado = Estado.findById(uf);
        return estadoSelecionado;
    }

    // Todos os Municipios de um determinado estado por UF
    @GET
    @Path("/municipiosEstduais/{uf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMunicipios(String uf, @RestQuery Integer pageIndex) {
        if (pageIndex == null)
        {
            var municipios = Municipio.listAll();
            return Response.ok(municipios).build();
        }        
        PanacheQuery<Municipio> municipios = Municipio.find("uf", uf);
        return Response.ok(municipios.page(Page.of(pageIndex, limitePagina)).list()).build();
    }
    

}