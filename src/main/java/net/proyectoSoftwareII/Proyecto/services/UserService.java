package net.proyectoSoftwareII.Proyecto.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.proyectoSoftwareII.Proyecto.UserRepository;
import net.proyectoSoftwareII.Proyecto.entities.UserEntity;
import net.proyectoSoftwareII.Proyecto.shared.dto.UserDTO;

@Service
public class UserService implements UserServiceInterface {


    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDto) {
        if (userRepository.findUserByEmail(userDto.getEmail())!= null) 
        throw new RuntimeException("El e-mail ingresado ya existe"); //Se valida si el email ya existe en BD

        //TODO logica para crea un usuario
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword(
            bCryptPasswordEncoder.encode(userDto.getPassword())); //La clave que se recibe del cliente se encripta y queda en "blanco"


        UUID userId = UUID.randomUUID(); //Identificador unico para el usuario creado
        userEntity.setUserId(userId.toString());


        UserEntity storedUserDetail =  userRepository.save(userEntity);

        UserDTO userToReturn = new UserDTO();
        BeanUtils.copyProperties(storedUserDetail, userToReturn);
        return userToReturn;
    }

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
    
}
