package controllers;

import java.util.HashMap;
import java.util.Map;

import play.data.validation.Required;
import play.mvc.Controller;

public class ServiciosUsuario extends Controller {
	
	public static void registroUsuario(@Required String usuario, String regId){
		
Map<String, Object> result = new HashMap<String, Object>();
		
		if (validation.hasErrors()){
			result.put("resultado", false);
			result.put("mensaje", "Parametros Incompletos");
		}else{
			
			
		}
		
	}

}
