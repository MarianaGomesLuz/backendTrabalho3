package aula.web.adivinhe.ws;

import aulas.web.adivinhe.entity.Jogador;
import aulas.web.adivinhe.entity.Jogo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.time.Instant;
import java.util.Date;

@Path("/jogador")
public class JogadorResource {

    @GET
    @Path("/info/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Jogador infoJogador(Integer codigo) {
        Jogador jogador = Jogador.findById(codigo);
        return jogador;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jogador> listJogadores() {
        List<Jogador> jogadores = Jogador.listAll();
        return jogadores;
    }
    

    @POST
    @Path("/new")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response insertJogador(@Valid Jogador jogador) {
        Jogador jogadorExistente = Jogador.findById(jogador.codigo);
        if (jogadorExistente != null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }        
        jogador.persist();
        return Response.created(URI.create("/jogo/info/" + jogador.codigo)).build();
    }

  
    @DELETE
    @Path("/deletar/{codigo}")
    @Transactional
    public Response deleteJogador(@PathParam("codigo") Integer codigo) {
        Jogador jogador = Jogador.findById(codigo);
        if (jogador == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Excluir todos os jogos associados ao jogador
        Jogo.delete("jogador", jogador);

        // Excluir o jogador
        jogador.delete();

        return Response.noContent().build();
    }
    
    @DELETE
    @Path("/deletarJogos/{codigo}")
    @Transactional
    public Response deleteJogos(@PathParam("codigo") Integer codigo) {
        Jogador jogador = Jogador.findById(codigo);
        if (jogador == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Excluir todos os jogos associados ao jogador
        Jogo.delete("jogador", jogador);

        return Response.noContent().build();
    }    
    

    @DELETE
    @Path("/deleteEspecifico/{codigoJogador}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteJogo(@PathParam("codigoJogador") Integer codigo, @QueryParam("dataHora") String dataHora) {
        Jogador jogador = Jogador.findById(codigo);
        if (jogador == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Converter a string de dataHora para o tipo Date
        Instant instant = Instant.parse(dataHora);
        Date jogoDataHora = Date.from(instant);

        // Localizar o jogo com base no jogador e na dataHora
        Jogo jogo = Jogo.find("jogoPK.jogador = ?1 and jogoPK.dataHora = ?2", codigo, jogoDataHora).firstResult();
        if (jogo == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // Remover o jogo do jogador
        jogo.delete();


        return Response.noContent().build();
    }
    
    @PUT
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateJogador(@PathParam("codigo") Integer codigo, @Valid Jogador jogador) {
        Jogador jogadorExistente = Jogador.findById(codigo);
        if (jogadorExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

            // Executar a atualização no banco de dados
            int rowsUpdated = Jogador.update("apelido = ?1, dataNasc = ?2, email = ?3 , endereco.bairro = ?4, endereco.cep = ?5, endereco.cidade = ?6, endereco.logradouro = ?7, endereco.uf= ?8, nome = ?9, senha = ?10, codigo = ?11" +
            "where codigo = ?12",
            jogador.apelido, jogador.dataNasc, jogador.email, jogador.endereco.bairro, jogador.endereco.cep, jogador.endereco.cidade, jogador.endereco.logradouro, jogador.endereco.uf, jogador.nome, jogador.senha, jogador.codigo, codigo);
            if (rowsUpdated == 0) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

        jogadorExistente.persist();
        return Response.ok(jogadorExistente).build();
    }
    
    @PUT
    @Path("/updateJogo/{codigoJogador}")
    @Produces(MediaType.APPLICATION_JSON)    
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateJogo(@PathParam("codigoJogador") Integer codigoJogador, @Valid Jogo jogoAtualizado, @QueryParam("data") String dataJogo) {      
        // Converter a string de dataHora para o tipo Date
        Instant instant = Instant.parse(dataJogo);
        Date jogoDataHora = Date.from(instant);

        // Jogador da atualização existe?
        Jogador jogadorExistente = Jogador.findById(codigoJogador);
        if (jogadorExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Jogador jogadorAtualizado = Jogador.findById(jogoAtualizado.jogoPK.jogador);
        if(jogadorAtualizado!=null)
        {
            // Executar a atualização no banco de dados
            int rowsUpdated = Jogo.update("pontuacao = ?1, jogoPK.dataHora = ?2, jogoPK.jogador = ?3" +
            "where jogoPK.dataHora = ?4 and jogoPK.jogador = ?5",
            jogoAtualizado.pontuacao, jogoAtualizado.jogoPK.dataHora, jogoAtualizado.jogoPK.jogador,
            jogoDataHora, codigoJogador);
            if (rowsUpdated == 0) 
            {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            
        } 
        else 
        {            
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    return Response.noContent().build();
    }     
}