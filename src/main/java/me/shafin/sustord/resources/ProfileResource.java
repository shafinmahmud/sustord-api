/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.shafin.sustord.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import me.shafin.sustord.models.Message;

/**
 *
 * @author SHAFIN
 */
@Path("/profile")
public class ProfileResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Message getStudentProfile() {

        return new Message();
    }
}
