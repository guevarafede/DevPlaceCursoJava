package bootcamp.clase_12.Repository;

import bootcamp.clase_12.Model.Product;
import bootcamp.clase_12.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Boolean existsByCodigo(int codigo);
}

