package aulas.web.adivinhe.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.util.Date;
import java.util.List;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

/**
 * Representa um jogador no banco de dados.
 * @author Wilson Horstmeyer Bogado
 */
@Entity
@Table(name = "estado")
public class Estado extends PanacheEntityBase {
    
    @NotNull
    public Integer ibge;
    
    @NotNull
    public String estado;

    @Id
    @NotNull
    public String uf;
    
    @NotNull
    public String regiao;
    
    @NotNull
    public Integer qntd_mun;
    
    @NotNull
    public String sintaxe;
    
    @NotNull
    public String capital;    

    @OneToMany(mappedBy = "estado")
    @JsonbTransient
    public List<Municipio> municipiosEstaduais;
    
}
