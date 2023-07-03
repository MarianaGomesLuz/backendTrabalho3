package aulas.web.adivinhe;

import aulas.web.adivinhe.entity.Jogo;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import java.util.List;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AdivinheTest {

@Test
    public void testStatus() {
        given()
          .when().get("/status")
          .then()
             .statusCode(200)
             .body(is("Serviço ativo"));
    }


    @Test
    public void testFindJogos() {
        List<Jogo> jogos = Jogo.list("jogoPK.jogador", 4);
        jogos.forEach(System.out::println);
    }
}