package bootcamp.clase_12.Repository;


import bootcamp.clase_12.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //aca va la clase que implementa la mayoria de los metodos que queremos implementar con la base de datos.
//<tipo de dato que tiene,tipo de identificador>
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByDni(int dni);
    User existsByEmail(String email);


}