package me.shafin.sustord.resources;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import me.shafin.sustord.models.LoginMessage;

import me.shafin.sustord.services.StudentLoginService;

@Path("/login")
public class LoginResource {

	@GET
        @Path("/{id}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public LoginMessage getLoginData(@PathParam("id") String registrationNo, @PathParam("password") String password) {
		
            try {
                StudentLoginService loginService = new StudentLoginService(registrationNo);
                return loginService.authenticateStudent(registrationNo, password);
            } catch (Exception ex) {
                LoginMessage error = new LoginMessage();
                error.setMessageTitle("ServiceCreationException");
                error.setMessageBody(ex.toString());
                Logger.getLogger(LoginResource.class.getName()).log(Level.SEVERE, null, ex);
                return error;
            }
			
	}

}
