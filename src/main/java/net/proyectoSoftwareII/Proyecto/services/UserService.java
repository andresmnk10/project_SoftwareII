package net.proyectoSoftwareII.Proyecto.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.proyectoSoftwareII.Proyecto.UserRepository;
import net.proyectoSoftwareII.Proyecto.entities.UserEntity;
import net.proyectoSoftwareII.Proyecto.shared.dto.UserDTO;

@Service
public class UserService implements UserServiceInterface {


    @Autowired
    UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        
        // TODO logica de la creacion del usuario
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword("testpassword");
        userEntity.setUserId("testUserId");

        UserEntity storedUserDetail =  userRepository.save(userEntity);

        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserDetail, userToReturn);
        return userToReturn;
    }
    
}
