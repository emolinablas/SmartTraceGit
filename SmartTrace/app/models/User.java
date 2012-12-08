package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class User extends Model {
	
	public String usuario;
	public String regN;
	public String nombre;
	
	public User(String usuario, String regN, String nombre){
		
		this.usuario = usuario;
		this.regN = regN;
		this.nombre = nombre;
		
	} 
	
	public String toString(){
		return nombre;
	}

}
