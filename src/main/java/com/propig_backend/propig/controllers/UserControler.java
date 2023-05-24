package com.propig_backend.propig.controllers;

import com.propig_backend.propig.models.User;
import com.propig_backend.propig.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/user")
@Api(value = "API REST Propig Data")
@CrossOrigin(origins = "*")
public class UserControler {

    @Autowired
    UserService userService;

    @RequestMapping( value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "Salva um usuário")
    public ResponseEntity<Void> save(@RequestBody User user) {
        userService.save(user);
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/register").buildAndExpand(user.getCnpj()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value =  "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retorna um usuário")
    public ResponseEntity<?> find(@PathVariable Long id){
        User user = userService.find(id);
        return ResponseEntity.ok().body(user);
    }

}
