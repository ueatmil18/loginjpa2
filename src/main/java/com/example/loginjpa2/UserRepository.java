/**
* @author: Prof. javier Juan Alvarez
* @Note: toma en cuenta que la tabla se llama user y 
* tiene tres campo: username, email,password
*/
package com.example.loginjpa2; // coloca el TU paquete

// estos import son necesarios
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    // Buscar por ID
        User findById(int id);

    // Grabar
        User save(User user);

    // Listar Todos
        List<User> findAll();

    // Borrar por ID
        void deleteById(int id);
}

    

