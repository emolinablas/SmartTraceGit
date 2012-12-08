package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;



import play.mvc.Controller;

public class EnviaMensaje extends Controller {
	
	public static void envio(String usuario, String mensaje){
		
		Map<String, Object> resulta = new HashMap<String, Object>();
		
		try {

			//Sender sender = new Sender("AIzaSyAB2AVASez74ypJNuAO9jExql7koOOJab0");
			  Sender sender = new Sender("AIzaSyDG1CbnC4qpgITjfclZbXWbAHE-YVVj5eE");

			ArrayList<String> devicesList = new ArrayList<String>();
			devicesList.add("APA91bFcJNR3_8FzPZAZjRk3Bvaj1_6mFWvMXcTj3_p1-DgCATMVBEDd6NiFk9d8rE2KKyQ-fAcp1rMa67HjXCnx81PZyA3YyZr-pBnyEaPBJrEDiUBigdoqbJQIu9mknzx5VActq1yqOwo8FvmcDfH4HxU6rcp9YQ");
			//devicesList.add("APA91bH1cc67ghqwUcXyJieu1DLZ3AJ5L_dkNztzlT61I1KucnJiabzKEiOtE72NJAxK6cdSdAMUUmSMP8nhhn73usxITJZ-H49y_HO4ri67YlZqcwXYqW1-2LyQDl0rwfzF_eepwx7we8h9N8QgLfioDqH6R1xlaw");

			// Use this line to send message without payload data
			// Message message = new Message.Builder().build();

			// use this line to send message with payload data
			Message message = new Message.Builder()
					.collapseKey("1")
					.timeToLive(3)
					.delayWhileIdle(true)
					.addData("message",
							"TE AMO!!")
					.build();

			// Use this code to send to a single device
			// Result result = sender
			// .send(message,
			// "APA91bGiRaramjyohc2lKjAgFGpzBwtEmI8tJC30O89C2b3IjP1CuMeU1h9LMjKhmWuZwcXZjy1eqC4cE0tWBNt61Kx_SuMF6awzIt8WNq_4AfwflaVPHQ0wYHG_UX3snjp_U-5kJkmysdRlN6T8xChB1n3DtIq98w",
			// 1);

			// Use this for multicast messages
			MulticastResult result = sender.send(message, devicesList, 1);
			sender.send(message, devicesList, 1);

			System.out.println(result.toString());
			if (result.getResults() != null) {
				int canonicalRegId = result.getCanonicalIds();
				
				resulta.put("resultado", true);
				resulta.put("mensaje", "SI FUNCIONO");
				
				if (canonicalRegId != 0) {
				}
			} else {
				
				resulta.put("resultado", true);
				resulta.put("mensaje", "NO FUNCIONO");
				
				int error = result.getFailure();
				System.out.println(error);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		renderJSON(resulta);
	}
	
	

}

