package com.mycompany.src.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("rest")
public class UsuarioController  {
    
    @GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }
}
