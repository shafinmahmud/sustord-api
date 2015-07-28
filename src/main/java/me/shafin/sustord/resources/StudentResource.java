/*
 */
package me.shafin.sustord.resources;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author SHAFIN
 */
@Path("/student")
public class StudentResource {

    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResource getLoginResource() {
        return new LoginResource();
    }

    @Path("/profile")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileResource getProfileResource() {
       //throw new DataNotFoundException("this is error");
       return new ProfileResource();
    }
    
    @Path("/syllabus")
    @Produces(MediaType.APPLICATION_JSON)
    public SyllabusResource getSyllabusResource() {
       return new SyllabusResource();
    }
    
    @Path("/result")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultResource getResultResource() {
       return new ResultResource();
    }
}
