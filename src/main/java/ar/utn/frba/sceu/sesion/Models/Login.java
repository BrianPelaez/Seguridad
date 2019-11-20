package ar.utn.frba.sceu.sesion.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	String mail, clave;
	
	

}
