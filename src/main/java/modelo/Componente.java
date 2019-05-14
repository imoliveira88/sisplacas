package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_COMPONENTE")
public class Componente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Componente(){}
    
    public Componente(String t, String d, String v){
        this.tipo = t;
        this.descricao = d;
        this.valor = v;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPONENTE")
    private Long id;
    
    @Column(name = "TIPO")
    private String tipo;
    
    @Column(name = "VALOR")
    private String valor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PLACA", referencedColumnName = "ID_PLACA")
    private Placa placa;
    
    @Column(name = "ROTULO")
    private String rotulo;

    @Column(name = "DESCRICAO")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Placa getPlaca() {
        return placa;
    }

    public void setPlaca(Placa placa) {
        this.placa = placa;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
   
}