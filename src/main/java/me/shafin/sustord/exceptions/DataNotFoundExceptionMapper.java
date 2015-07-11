/*
 */
package me.shafin.sustord.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author SHAFIN
 */
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoudException>{

    @Override
    public Response toResponse(DataNotFoudException e) {
        return null;
    }
    
}
