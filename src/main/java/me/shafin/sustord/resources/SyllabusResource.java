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
import me.shafin.sustord.models.CourseModel;
import me.shafin.sustord.models.SyllabusModel;
import me.shafin.sustord.services.SyllabusService;
import org.hibernate.HibernateException;

/**
 *
 * @author SHAFIN
 */
public class SyllabusResource {

    @GET
    @Path("/{batch_tag}/{semester_no}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSemesterSyllabus(@PathParam("batch_tag") String batchTag,
            @PathParam("semester_no") Integer semester) {
        try {
            SyllabusModel syllabus = SyllabusService.getSemesterSyllabus(batchTag, semester, false);
            return Response.ok()
                    .entity(syllabus)
                    .build();
        } catch (HibernateException | NullPointerException | SQLException ex) {
            throw new DataNotFoundException(ex.toString());
        }
    }

    @GET
    @Path("/details/{batch_tag}/{semester_no}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSemesterSyllabusInDetails(@PathParam("batch_tag") String batchTag,
            @PathParam("semester_no") Integer semester){
         try {
            SyllabusModel syllabus = SyllabusService.getSemesterSyllabus(batchTag, semester, true);
            return Response.ok()
                    .entity(syllabus)
                    .build();
        } catch (HibernateException | NullPointerException | SQLException ex) {
            throw new DataNotFoundException(ex.toString());
        }
    }

    @GET
    @Path("/details/{course_code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCourseDetails(@PathParam("course_code") String courseCode) {
        try {
            CourseModel courseModel = SyllabusService.getCourseDetails(courseCode);
            return Response.ok()
                    .entity(courseModel)
                    .build();
        } catch (HibernateException | NullPointerException | SQLException ex) {
            throw new DataNotFoundException(ex.toString());
        }
    }
}
