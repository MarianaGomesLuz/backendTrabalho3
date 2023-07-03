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
import org.jboss.resteasy.reactive.RestQuery;

@Path("/municipio")
public class MunicipioResource {

    public static final int limitePagina = 50;    
    
    // Endpoint Obter a relação de todos os municipios com paginação
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMunicipios(@RestQuery Integer pageIndex) {
        if (pageIndex == null)
        {
            var municipios = Municipio.listAll();
            return Response.ok(municipios).build();
        }        
        PanacheQuery<Municipio> municipios = Municipio.findAll();
        return Response.ok(municipios.page(Page.of(pageIndex, limitePagina)).list()).build();        
    }
    
    
    // Endpoint Obter as informações de um municipio específico
    @GET
    @Path("/{ibge}")
    @Produces(MediaType.APPLICATION_JSON)
    public Municipio infoEstado(Integer ibge) {
        Municipio municipioSelecionado = Municipio.findById(ibge);
        return municipioSelecionado;
    }
    
}