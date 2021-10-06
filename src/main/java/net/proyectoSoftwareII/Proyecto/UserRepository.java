package net.proyectoSoftwareII.Proyecto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.proyectoSoftwareII.Proyecto.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    public UserEntity findUserByEmail (String email);



    
}
 