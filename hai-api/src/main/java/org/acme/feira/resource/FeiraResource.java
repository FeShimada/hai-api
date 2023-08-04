package org.acme.feira.resource;


import java.util.List;
import java.util.UUID;

import org.acme.feira.controller.FeiraController;
import org.acme.feira.dto.FeiraDto;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * @author Felipe Shimada <felipe.shimada@kepha.com.br>
 * @version 1.0
 */
@Path("/feira")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FeiraResource {

    @Inject
    FeiraController feiraController;

    @POST
    public Response create(FeiraDto feiraDto) {
        return Response.ok().entity(feiraController.create(feiraDto)).build();
    }

    @GET
    @Path("{id}")
    public Response retrieveById(@PathParam("id") String uuid) {
        return Response.ok().entity(feiraController.retrieve(UUID.fromString(uuid))).build();
    }

    @GET
    public Response retrieveAll() {
        List<FeiraDto> feiras = feiraController.retrieve();
        return Response.ok(feiras).build();
    }

    @PUT
    public Response update(FeiraDto feiraDto) {
        return Response.ok().entity(feiraController.update(feiraDto)).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") String uuid) {
        if (feiraController.delete(UUID.fromString(uuid))) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }
    
}
