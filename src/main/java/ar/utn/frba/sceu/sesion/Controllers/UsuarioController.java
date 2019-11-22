package ar.utn.frba.sceu.sesion.Controllers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import ar.utn.frba.sceu.sesion.Models.Usuario;
import ar.utn.frba.sceu.sesion.Repositories.UsuarioRepository;

@RestController
@RequestMapping("api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/usuario")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) throws NoSuchAlgorithmException {
		
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		
		//HASH CLAVE
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(usuario.getClave().getBytes());
		byte[] digest = md.digest();
		String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		//FIN HASH CLAVE
		
		//SE CHEQUEA SI EL USUARIO EXISTE
		usuarios.forEach(x -> {
			
			if (x.getUsuario().equals(usuario.getUsuario())) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario ya existe");
			}
			
		});
		
		usuario.setClave(myHash);
		usuarioRepository.save(usuario);
		return usuario;
	}

}
