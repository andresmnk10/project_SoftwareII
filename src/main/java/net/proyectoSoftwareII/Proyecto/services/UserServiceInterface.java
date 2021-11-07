package net.proyectoSoftwareII.Proyecto.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.proyectoSoftwareII.Proyecto.shared.dto.UserDTO;

public interface UserServiceInterface extends UserDetailsService {

    public UserDTO createUser (UserDTO userDTO);

}

