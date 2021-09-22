package net.proyectoSoftwareII.Proyecto.controllers;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import net.proyectoSoftwareII.Proyecto.models.reponses.UsersRest;
import net.proyectoSoftwareII.Proyecto.models.request.UserDetailRequestModel;
import net.proyectoSoftwareII.Proyecto.shared.dto.UserDTO;

@RestController
@RequestMapping ("/users")
public class UserController {

    @GetMapping
    public String getUser (){
        return "Obtener usuarios";
    }

    @PostMapping
    public UsersRest createUser (@RequestBody UserDetailRequestModel userDetails){

        UserRest userToReturn = new UserRest();
        
        UserDTO userDTO = new UserDTO ();

        BeanUtils.copyProperties(userDetails, userDTO);

        UserDTO createdUser = userService.createdUser(userDTO);
        
        BeanUtils.copyProperties(createdUser, userToReturn);
         

        return null;
    } 

  
    
}
