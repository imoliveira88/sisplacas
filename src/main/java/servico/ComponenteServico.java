package servico;

import java.sql.SQLException;
import java.util.List;
import modelo.Componente;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ComponenteServico extends DAOGenericoJPA<Long,Componente>{

    public ComponenteServico() {
        super();
    }
    
    public boolean deletar(Long id) throws Exception,SQLException{
        super.getEm().getTransaction().begin();
        
        Componente p = super.getEm().find(Componente.class,id);
        
        try{
            super.getEm().remove(p);
            super.getEm().getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public Componente getComponente(String tipoValor){
        String query = "SELECT e FROM Componente e";
        List<Componente> componentes = super.getEm().createQuery(query,Componente.class).getResultList();
        try{
            for(Componente comp : componentes){
                if((comp.getTipo()+comp.getValor()).equals(tipoValor)) return comp;
            }
            return null;
        }
        catch(NoResultException e){
            return null;
        }
    }
    
    public boolean existeComponente(Componente p){
        String query = "SELECT e FROM Componente e";
        List<Componente> componentes = super.getEm().createQuery(query, Componente.class).getResultList();
        try{
            for(Componente comp : componentes){
                if(comp.equals(p)) return true;
            }
            return false;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    @Override
    public List<Componente> findAll() {
        String query = "SELECT e FROM Componente e ORDER BY e.tipo";
        List<Componente> componentes = super.getEm().createQuery(query, Componente.class).getResultList();
        return componentes;
    }
    
    public void salvar(Componente b) {
        if(!existeComponente(b)){
            super.getEm().getTransaction().begin();
            super.getEm().persist(b);
            super.getEm().getTransaction().commit();
        }
    }
    
    
    
}