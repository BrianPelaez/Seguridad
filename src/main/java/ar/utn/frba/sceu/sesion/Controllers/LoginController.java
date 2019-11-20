package ar.utn.frba.sceu.sesion.Controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.*;

import org.springframework.web.bind.annotation.*;

import ar.utn.frba.sceu.sesion.Models.Login;

@RestController
@RequestMapping("auth")
public class LoginController {
	
	@PostMapping("/login")
	public String login(@RequestBody Login login, HttpSession session) throws NoSuchAlgorithmException{
		
		//Usuario
		
		return "0";
	}

}
