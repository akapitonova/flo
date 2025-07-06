package com.kap.flowershop.front.rest;

import com.kap.flowershop.back.service.UserService;
import com.kap.flowershop.back.entity.Users;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Objects;

@Component
@Path("/jersey")
public class RestService {
    @Autowired
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/check_user_login")
    public String validateUserLogin(String json) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        Users user = userService.getUserByUsername(jsonObject.get("username").getAsString());
        return Objects.nonNull(user) ? "true" : "false";
    }
}
