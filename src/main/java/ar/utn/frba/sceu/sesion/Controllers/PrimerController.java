package ar.utn.frba.sceu.sesion.Controllers;

import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api")
public class PrimerController {
	
	
	@GetMapping("/usuario")
	public String comprobar(HttpSession session) {
		
		if (session.getAttribute("usuario_nombre") == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sesion no iniciada");
		}
		
		return (String)session.getAttribute("usuario_nombre");
	}

}
