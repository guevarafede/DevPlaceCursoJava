package bootcamp.clase_12.Controller;

import bootcamp.clase_12.Exception.ResourceNotFoundException;
import bootcamp.clase_12.Menssage.MessageResponse;
import bootcamp.clase_12.Model.Product;
import bootcamp.clase_12.Model.User;
import bootcamp.clase_12.Repository.ProductRepository;
import bootcamp.clase_12.Repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController//le decimos que es una clase Rest y spring la reconoce como tal
@RequestMapping("/apires/product")

public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping //aca no uso ResponseEntity porque estoy con spring boot?
    public List<Product> getAllProducts() {
        return this.productRepository.findAll(); //traigo el repositorio y con findAll obtengo todos los registros.
    }

    //ESTO ES UN EJEMPLO DE UN VIDEO.   (esto de usar ResponeseEmntity seria para API REST pura creo...)
    /* Cons ResponseEntity, trae un Producto.
    @GetMapping
    public ResponseEntity<Product> getProduct(){
        Product product = new Product();
        product.setIg(1L);
        product.setName("Producto 1");
        return ResponseEntity.ok(product);
    }*/
    /*PARA TRAER TODOS LOS PRODUCTOS:
    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
    List<Product> products = productRepository.fidAll();
    return ResponseEntity.ok(products);
     */


    @ApiOperation(value = "Buscar product por id", notes="Notas....") //que es?
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") long productId) {
        return this.productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + productId));
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {
        if( productRepository.existsByCodigo(product.getCodigo())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: El codigo existe"));
        }
        productRepository.save(product);
        return ResponseEntity.ok(new MessageResponse("Producto Registrado Correctamente"));
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable ("id") long productId) {
        Product addProducts = this.productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found" + productId));
        addProducts.setProductName(product.getProductName());
        addProducts.setCodigo(product.getCodigo());
        addProducts.setCantidad(product.getCantidad());
        return this.productRepository.save(addProducts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable ("id") long productId){
        Product existingProduct = this.productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found:" + productId));
        this.productRepository.delete(existingProduct);
        return ResponseEntity.ok().build();
    }
}
