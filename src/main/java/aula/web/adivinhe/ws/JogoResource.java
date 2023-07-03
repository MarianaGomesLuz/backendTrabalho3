package aula.web.adivinhe.ws;

import aulas.web.adivinhe.entity.Jogo;
import aulas.web.adivinhe.entity.JogoPK;
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
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/jogo")
public class JogoResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listJogos() {
        var jogos = Jogo.listAll();
        return Response.ok(jogos).build();
    }
    
    @GET
    @Path("/jogador/{jogador}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listJogos(Integer jogador) {
        var jogos = Jogo.list("jogoPK.jogador", jogador);
        return Response.ok(jogos).build();
    }
    
    @GET
    @Path("/info/{jogador}/{jogo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response infoJogo(Integer jogador, Date dataHora) {
        var jogoPK = new JogoPK(jogador, dataHora);
        Jogo j = Jogo.findById(jogoPK);
        return Response.ok(j).build();
    }
    
    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insertJogo(@Valid Jogo jogo) {
        jogo.persist();
        Instant instant = Instant.ofEpochMilli(jogo.jogoPK.dataHora.getTime());
        String iso = DateTimeFormatter.ISO_INSTANT.format(instant);
        return Response.created(URI.create("/jogo/info/" + jogo.jogoPK.jogador + "/" + iso)).build();
    }
}