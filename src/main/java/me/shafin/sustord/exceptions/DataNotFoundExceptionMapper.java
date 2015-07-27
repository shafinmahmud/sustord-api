/*
 */
package me.shafin.sustord.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import me.shafin.sustord.models.ErrorMessage;

/**
 *
 * @author SHAFIN
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

    @Override
    public Response toResponse(DataNotFoundException e) {
        System.out.println("this is here");
        ErrorMessage error = new ErrorMessage();
        error.setErrorTitle("NotFound");
        error.setErrorBody(e.toString());
        
        return Response.status(Status.NOT_FOUND)
                .entity(error)
                .build();
    }

}
