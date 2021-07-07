package Servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Persona;

/**
 * Session Bean implementation class PersonasService
 */
@Stateless
@LocalBean
public class PersonasService implements PersonasServiceLocal {

    /**
     * Default constructor. 
     */
    public PersonasService() {
        // TODO Auto-generated constructor stub
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("clasedatabaseEJB");
    
    @Override
    public void holamundo() {
    	System.out.println("xd");
    }
    
	@Override
	public void add(Persona p) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.persist(p);
			em.flush(); // este es un commit? 
			
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public List<Persona> getAllPersonas() {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.createNamedQuery("Persona.getAllPersonas", Persona.class).getResultList();
		} catch(Exception e) {
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public void remove(Persona p) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			em.remove(em.find(Persona.class, p.getIdPersona()));
		} catch (Exception e) {
			
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Persona p) {
		// TODO Auto-generated method stub
		EntityManager em = this.emf.createEntityManager();
		try {
			Persona origen = em.find(Persona.class, p.getIdPersona());
			origen.setApellidosPersona(p.getApellidosPersona());
			origen.setDireccion(p.getDireccion());
			origen.setFechaNacimiento(p.getFechaNacimiento());
			origen.setFotoPersona(p.getFotoPersona());
			origen.setIdCiudad(p.getIdCiudad());
			origen.setNombresPersona(p.getNombresPersona());
			origen.setRut(p.getRut());
			
			em.merge(origen);
			em.flush();
		} catch(Exception e) {
			
		} finally {
			em.close();
		}
	}
	
	

}
