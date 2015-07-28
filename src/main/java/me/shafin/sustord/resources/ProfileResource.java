/*
 */
package me.shafin.sustord.resources;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.shafin.sustord.models.ErrorMessage;
import me.shafin.sustord.models.AcademicProfile;
import me.shafin.sustord.models.PersonalProfile;
import me.shafin.sustord.services.AcademicInfoService;
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
            PersonalProfile personal = new PersonalInfoService(ID).getPersonalInfo();
            return Response.ok()
                    .entity(personal)
                    .build();
        } catch (HibernateException | SQLException | NullPointerException ex) {
            ErrorMessage error = new ErrorMessage();
            error.setErrorTitle("ServiceCreationError");
            error.setErrorBody(ex.toString());
            return Response.serverError()
                    .entity(error)
                    .build();
        }
    }

    @GET
    @Path("/academic/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAcademicProfile(@PathParam("id") String ID) {
        try {
            AcademicProfile academic = new AcademicInfoService(ID).getAcademicProfile();
            return Response.ok()
                    .entity(academic)
                    .build();
        } catch (HibernateException | NullPointerException | SQLException ex) {
            Logger.getLogger(ProfileResource.class.getName()).log(Level.SEVERE, null, ex);
            ErrorMessage error = new ErrorMessage();
            error.setErrorTitle("ServiceCreationError");
            error.setErrorBody(ex.toString());
            return Response.serverError()
                    .entity(error)
                    .build();
        }

    }
}
