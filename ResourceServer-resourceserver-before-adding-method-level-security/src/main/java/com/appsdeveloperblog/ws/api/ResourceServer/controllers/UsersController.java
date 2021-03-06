package com.appsdeveloperblog.ws.api.ResourceServer.controllers;

import com.appsdeveloperblog.ws.api.ResourceServer.response.UserRest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/status/check")
    public String status() {
        return "Working...";
    }


    @PreAuthorize("hasRole('developer') or #id == #jwt.subject") // this and below annotation are equivalent
//	@Secured("ROLE_developer")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Delete user id " + id+"with subject"+jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId ==  #jwt.subject")
    @GetMapping(path = "/{id}")
    public UserRest getUser(@PathVariable String id,@AuthenticationPrincipal Jwt jwt){
        return new UserRest("Dhiraj","Kumar","b730a468-07ea-4d70-9290-8a4349e757b9");
    }


}
