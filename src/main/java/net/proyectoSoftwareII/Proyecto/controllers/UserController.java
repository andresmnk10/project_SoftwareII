package net.proyectoSoftwareII.Proyecto.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.proyectoSoftwareII.Proyecto.models.reponses.UsersRest;
import net.proyectoSoftwareII.Proyecto.models.request.UserDetailRequestModel;

@RestController
@RequestMapping ("/users")
public class UserController {

    @GetMapping
    public String getUser (){
        return "Obtener usuarios";
    }

    @PostMapping
    public UsersRest createUser (@RequestBody UserDetailRequestModel userDetails){
        return null;
    } 

  
    
}
