package ar.utn.frba.sceu.sesion.Models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	String nombre,apellido;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



}
