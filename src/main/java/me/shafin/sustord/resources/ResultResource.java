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
import me.shafin.sustord.models.CumulativeResult;
import me.shafin.sustord.models.CurriculumResult;
import me.shafin.sustord.models.ErrorMessage;
import me.shafin.sustord.models.SemesterResult;
import me.shafin.sustord.services.CurriculumResultService;
import me.shafin.sustord.services.SemesterResultService;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class ResultResource {

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
    @Path("/curriculum/{semester_no}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurriculumWiseResult(@PathParam("semester_no") Integer semester,
            @PathParam("id") String id) {
        try {
            CurriculumResultService service = new CurriculumResultService(id);
            CurriculumResult result = service.getCurriculumResult(semester);
            return Response.ok()
                    .entity(result)
                    .build();
        } catch (HibernateException | SQLException ex) {
            throw new DataNotFoundException(ex.toString());
        }
    }

    @GET
    @Path("/semester/{semester_no}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSemesterWiseResult(@PathParam("semester_no") Integer semester,
            @PathParam("id") String id) throws SQLException {
        try {
            SemesterResultService service = new SemesterResultService(id);
            SemesterResult result = service.getSemesterResult(semester);
            return Response.ok()
                    .entity(result)
                    .build();
        } catch (HibernateException ex) {
            throw new DataNotFoundException(ex.toString());
        } 
    }
    
    @GET
    @Path("/cgpa/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCGPA(@PathParam("id") String id) throws SQLException {
        try {
            SemesterResultService service = new SemesterResultService(id);
            CumulativeResult result = service.getCumulativeResult();
            return Response.ok()
                    .entity(result)
                    .build();
        } catch (HibernateException ex) {
            throw new DataNotFoundException(ex.toString());
        } 
    }
}
