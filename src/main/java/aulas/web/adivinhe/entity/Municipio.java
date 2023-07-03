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
import jakarta.persistence.ManyToOne;
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
@Table(name = "municipio")
public class Municipio extends PanacheEntityBase {
    
    @NotNull
    public String concatUfMun;

    @Id    
    @NotNull
    public Integer ibge;

    @NotNull
    public Integer ibge7;    
    
    @NotNull
    @Column(insertable = false, updatable = false)
    public String uf;
    
    @NotNull
    public String municipio;
    
    @NotNull
    public String regiao;
    
    @NotNull
    public Integer populacao;
    
    @NotNull
    public String porte;    
    
    public String capital;    
    
    @ManyToOne
    @JoinColumn(name = "uf")    
    @JsonbTransient    
    public Estado estado;  
}

