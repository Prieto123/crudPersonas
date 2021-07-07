package cl.inacap.clasedatabase.Controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Persona;
import Servicios.PersonasService;
import Servicios.PersonasServiceLocal;
import java.util.Date;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home.do")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Inject
    private PersonasServiceLocal personaService;
    
    
    public static Date parseDate(String date) {
    	try {
    		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    	} catch (Exception e) {
    		return null;
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//request.getRequestDispatcher("site/home.jsp").forward(request, response);
		
		Date fecha = parseDate("2000-12-21");
		
		Persona p = new Persona();
		p.setApellidosPersona("Test Apellido");
		p.setDireccion("Test Direccion");
		p.setFechaNacimiento(fecha);
		p.setFotoPersona("Test URL Fotito");
		p.setIdCiudad(2);
		p.setNombresPersona("Test Persona");
		p.setRut("11111111-1");
		
		personaService.add(p);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
