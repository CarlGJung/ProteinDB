package com.server.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author zhanghaijun
 */
@Path("/ststic")
public class ResourceService {

    @GET
    public String getUser() {
        return "6666666666";
    }

}
