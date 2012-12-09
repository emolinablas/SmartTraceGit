package controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import models.User;

import play.data.validation.Required;
import play.mvc.Controller;

public class ServiciosUsuario extends Controller {
	
	public static void crearUsuario(@Required String usuario, String nombre, String regId){
		Map<String, Object> result = new HashMap<String, Object>();
		
		if(validation.hasErrors()){
			result.put("resultado", false);
			result.put("mensaje", "Parametros incompletos");
		}else{
			User user = User.find("byUsuario", usuario).first();
			if(user==null){
				User nick = new User(usuario, regId,nombre).save();
				result.put("resultado", true);
				result.put("usuario", nick);
				result.put("mensaje", "usuario creado exitosamente");
			}else{
				result.put("resultado", false);
				result.put("mensaje", "Ocurrio un error al crear el usuario, ya existe el usuario");
			}
		}
		renderJSON(result);
	}
	
	public static void registroUsuario(@Required long id, String regId){
		
Map<String, Object> result = new HashMap<String, Object>();
		
		if (validation.hasErrors()){
			result.put("resultado", false);
			result.put("mensaje", "Parametros Incompletos");
		}else{
			
			User user = User.findById(id);
			if (user!=null){	
				   user.regN = regId;
				   
				   if(user.validateAndSave()){
					   result.put("resultado", true);
					   result.put("mensaje", "Se registró el usuario para la sesion.");
				   }else{
					   result.put("resultado", false);
					   result.put("mensaje", "Error. por favor intente mas tarde");
				   }
				
			}else{
				result.put("resultado", false);
				result.put("mensaje", "No existe el usuario");
			}
		}
		renderJSON(result);
		
	}
	
	public static void listadoUsuarios(){
		
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<User> usuarios = User.findAll();
		
		if(usuarios.size()>0){
			result.put("resultado", true);
			result.put("usuarios", usuarios);
			result.put("mensaje", "Usuarios consultados exitosamente");
		}else{
			result.put("resultado", false);
			result.put("mensaje", "No existen usuarios");
		}
		
		renderJSON(result);
	}

}
