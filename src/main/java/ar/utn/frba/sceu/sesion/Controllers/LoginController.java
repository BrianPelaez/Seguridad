package ar.utn.frba.sceu.sesion.Controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.*;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ar.utn.frba.sceu.sesion.Models.Login;
import ar.utn.frba.sceu.sesion.Models.Usuario;
import ar.utn.frba.sceu.sesion.Repositories.UsuarioRepository;

@RestController
@RequestMapping("auth")
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/login")
	public String login(@RequestBody Login login, HttpSession session) throws NoSuchAlgorithmException {

		// TOMAMOS EL Usuario DE LA DB
		Usuario usuario;
		usuario = usuarioRepository.findByUsuario(login.getUsuario());
		session.getAttribute("usuario");
		
		//HASH CLAVE
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(login.getClave().getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		//FIN HASH CLAVE
		
		if (!myHash.equals(usuario.getClave())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Clave incorrecta: " + login.getClave() + " la clave guardada es: " + usuario.getClave());
		}
		//AL REALIZAR EL SET 'usuario_nombre' ES UN NOMBRE DE VARIABLE QUE SE CREA.
		session.setAttribute("usuario_nombre", usuario.getUsuario());

		return "OK";
	}

}
