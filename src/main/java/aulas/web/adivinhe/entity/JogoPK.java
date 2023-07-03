package aulas.web.adivinhe.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

/**
 * A chave primária composta de um jogo.
 * @author Wilson Horstmeyer Bogado
 */
@Embeddable
public class JogoPK implements Serializable {

    @NotNull
    public Integer jogador;
    
    @NotNull
    @PastOrPresent
    @Column(name = "data_hora")
    public Date dataHora;

    public JogoPK() {
    }
    
    public JogoPK(Integer jogador, Date dataHora) {
        this.jogador = jogador;
        this.dataHora = dataHora;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.jogador);
        hash = 29 * hash + Objects.hashCode(this.dataHora);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final JogoPK other = (JogoPK) obj;
        if (!Objects.equals(this.jogador, other.jogador)) {
            return false;
        }
        return Objects.equals(this.dataHora, other.dataHora);
    }

    @Override
    public String toString() {
        return "JogoPK{" + "jogador=" + jogador + ", dataHora=" + dataHora + '}';
    }
}
