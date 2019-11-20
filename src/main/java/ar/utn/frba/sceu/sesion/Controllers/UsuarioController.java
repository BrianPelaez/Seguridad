package ar.utn.frba.sceu.sesion.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import ar.utn.frba.sceu.sesion.Repositories.UsuarioRepository;

@RestController
@RequestMapping("api")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuario")
	public Integer comprobar(HttpSession session) {
		
		if (session.getAttribute("usuario_id") == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sesion no iniciada");
		}
		
		return (Integer)session.getAttribute("usuario_id");
	}

}
