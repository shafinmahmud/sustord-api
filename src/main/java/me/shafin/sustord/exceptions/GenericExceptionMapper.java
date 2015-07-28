/*
 */
package me.shafin.sustord.exceptions;

import javax.ws.rs.core.MediaType;
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
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable e) {
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorMessage("500", "ServerError", e.toString(), null))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
