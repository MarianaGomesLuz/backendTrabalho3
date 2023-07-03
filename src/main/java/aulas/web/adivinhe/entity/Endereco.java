package aulas.web.adivinhe.entity;

import java.io.Serializable;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * Representa o endereço e um jogador.
 * @author Wilson Horstmeyer Bogado
 */
@Embeddable
public class Endereco implements Serializable {
    
    @NotNull
    @Length(min = 3, max = 255)
    public String logradouro;

    @Min(1) @Max(99999)
    public Integer numero;
    
    @Length(min = 1, max = 50)
    public String bairro;
    
    @Min(0) @Max(99999999)
    public Integer cep;
    
    @NotNull
    @Length(min = 3, max = 100)
    public String cidade;
    
    @NotNull
    @Length(min = 2, max = 2)
    public String uf;

    @Override
    public String toString() {
        return logradouro + ", " +
               numero + " " +
               bairro + " " +
               cep + " " +
               cidade + " " +
               uf;
    }
    
}
