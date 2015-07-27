package me.shafin.sustord.resources;

import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import me.shafin.sustord.models.ErrorMessage;
import me.shafin.sustord.models.LoginMessage;

import me.shafin.sustord.services.StudentLoginService;
import org.hibernate.HibernateException;

public class LoginResource {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDefaultResponse() {
        ErrorMessage error = new ErrorMessage();
        error.setErrorTitle("InvalidURI");
        error.setErrorBody("Your requesting URI is not valid.");
        return Response.serverError()
                .entity(error)
                .build();
    }

    @GET
    @Path("/{id}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLoginData(@PathParam("id") String ID, @PathParam("password") String password) {

        try {
            LoginMessage loginMessage = new StudentLoginService(ID).authenticateStudent(password);
            return Response.ok()
                    .entity(loginMessage)
                    .build();
        } catch (ExceptionInInitializerError | HibernateException | SQLException ex) {
            ErrorMessage error = new ErrorMessage();
            error.setErrorTitle("ServiceCreationError");
            error.setErrorBody(ex.toString());
            return Response.serverError()
                    .entity(error)
                    .build();
        }

    }

}
