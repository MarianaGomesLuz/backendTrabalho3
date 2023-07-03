package aulas.web.adivinhe.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Representa um jogo no banco de dados.
 * @author Wilson Horstmeyer Bogado
 */
@Entity
@Table(name = "jogo")
public class Jogo extends PanacheEntityBase {

    @EmbeddedId
    @Valid
    public JogoPK jogoPK;
    
    @NotNull
    @Min(value = 0, message = "Pontuação ${validatedValue} é inválida. A pontuação mínima permitida é {value}.")
    public Integer pontuacao;
    
    @ManyToOne
    @JoinColumn(name = "jogador", referencedColumnName = "codigo", insertable = false, updatable = false)
    @JsonbTransient
    public Jogador jogador;

    @Override
    public String toString() {
        return "Jogo{" + "jogoPK=" + jogoPK + ", pontuacao=" + pontuacao + ", jogador=" + jogador + '}';
    }
}
