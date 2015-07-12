/*
 */
package me.shafin.sustord.resources;

import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import me.shafin.sustord.exceptions.DataNotFoundException;
import me.shafin.sustord.models.ErrorMessage;
import me.shafin.sustord.models.StudentPersonalProfile;
import me.shafin.sustord.services.PersonalInfoService;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class ProfileResource {

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
    @Path("/personal/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonalProfile(@PathParam("id") String ID) {
      
        try {
            StudentPersonalProfile personal = new PersonalInfoService(ID).getAllPersonalInfo();
            return Response.ok()
                    .entity(personal)
                    .build();
        } catch (HibernateException | SQLException ex) {
            ErrorMessage error = new ErrorMessage();
            error.setErrorTitle("ServiceCreationError");
            error.setErrorBody(ex.toString());
            return Response.serverError()
                    .entity(error)
                    .build();
        } catch(NullPointerException ex){
            throw new DataNotFoundException("Reg No "+ID+" not Found "+ex.toString());
        }
    }

    @GET
    @Path("/academic/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAcademicProfile(@PathParam("id") String ID) {
        return Response.serverError()
                .build();

    }
}
