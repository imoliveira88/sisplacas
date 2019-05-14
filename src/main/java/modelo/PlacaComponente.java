package modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "TB_PLACACOMPONENTE")
public class PlacaComponente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public PlacaComponente(Placa p, Componente c, String r){
        this.placa = p;
        this.componente = c;
        this.rotulo = r;
    }

    
    public PlacaComponente(){};
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLACACOMPONENTE")
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPONENTE", referencedColumnName = "ID_COMPONENTE")
    private Componente componente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PLACA", referencedColumnName = "ID_PLACA")
    private Placa placa;
    
    @Column(name = "ROTULO")
    private String rotulo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
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
    
    
    
}