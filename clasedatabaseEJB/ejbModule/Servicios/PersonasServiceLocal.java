package Servicios;

import java.util.List;

import javax.ejb.Local;

import Model.Persona;

@Local
public interface PersonasServiceLocal {
	public void add(Persona p);
	public List<Persona> getAllPersonas();
	public void remove(Persona p);
	public void update(Persona p);
	public void holamundo();
}
