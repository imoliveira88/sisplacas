package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_PLACA")
public class Placa implements Serializable {
    
    public Placa(){
        this.placaComponentes = new ArrayList<>();
    }
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLACA")
    private Long id;
    
    @OneToMany(mappedBy = "placa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private final List<PlacaComponente> placaComponentes;
   
    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "DESCRICAO") 
    private double descricao;
    
    public void addItem(PlacaComponente item) {
        this.placaComponentes.add(item);
    }
    
    public void removeItem(PlacaComponente item){
        this.placaComponentes.remove(item);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getDescricao() {
        return descricao;
    }

    public void setDescricao(double descricao) {
        this.descricao = descricao;
    }
    
    

    
}