/**
* @author: Prof. javier Juan Alvarez
* @Note: toma en cuenta que la tabla se llama user y 
* tiene tres campo: username, email,password
*/
package com.example.loginjpa2; // coloca el TU paquete

// estos import son necesarios
import java.util.List; // para usar List
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired; // para usar @Autowired 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping; // para usar  @DeleteMapping
import org.springframework.web.bind.annotation.GetMapping; // para usar  @GetMapping
import org.springframework.web.bind.annotation.PathVariable; // para usar  @PathVariable
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController; // para usar  @RestController

@RestController
public class UserController {

@Autowired 
private UserRepository repo;

// Home page - pagina principal, con ella sabes si esta conectado
@GetMapping("/") // para que funcione colocar en browser o postman localhost:8080/
public String bienvenida(){
        return "<h1>Bienvenidos, esta funcionando, en principio</h1> <html><body> </body></html>";
}

// Get muestra todos los usuarios
@GetMapping("/lista") // para que funcione colocar en browser o postman localhost:8080/lista
public List<User> getAllNotes(){
        return repo.findAll();
    }
  
// Get datos del usuario por el ID
@GetMapping("/usu/{id}") // para que funcione colocar en browser o postman localhost:8080/usuario/nro ID
public User getUserById(@PathVariable(value = "id") int id){
        return repo.findById(id);
    }

// borra usuario por ID 
@DeleteMapping("/borr/{id}") // para que funcione colocar en browser o postman localhost:8080/usuario/nro ID
public void deleteUsuario(@PathVariable(value = "id") int id) {
        repo.deleteById(id);
}

// Agrega un registro a la tabla, con metodo POST
// tenes que pasarle un JSON, con los datos  @RequestBody
@PostMapping("/usuario")
@ResponseStatus(HttpStatus.CREATED)
public User addUsu(@RequestBody User user)
    {
        return repo.save(user);
    }
  
// veamos....

// Agrega un registro a la tabla, con metodo PUT
// tenes que pasarle un JSON, con los datos  @RequestBody
// y el ID nuevo @PathVariable
@PutMapping("/usuario/{id}")
public ResponseEntity<Object> updateUsu(@RequestBody User user,@PathVariable int id)
{
  
    Optional<User> usuRepo = Optional.ofNullable(repo.findById(id));

    if (!usuRepo.isPresent())
        return ResponseEntity.notFound().build();

    user.setUserId(id);

    repo.save(user);

    return ResponseEntity.noContent().build();
}
     
}
