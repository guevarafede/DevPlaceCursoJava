package bootcamp.clase_12.Controller;

import bootcamp.clase_12.Exception.ResourceNotFoundException;
import bootcamp.clase_12.Menssage.MessageResponse;
import bootcamp.clase_12.Model.Client;
import bootcamp.clase_12.Model.User;
import bootcamp.clase_12.Repository.ClientRepository;
import bootcamp.clase_12.Repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class ClientController {

    @Autowired //para poder usar el repositorio que creamos, lo declaramos como una variable
    //con autowired, no tenemos que instanciarla, spring ya sabe que existe una instancia y cual utilizar
    ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return this.clientRepository.findAll(); //traigo el repositorio y con findAll obtengo todos los registros.
    }

    @ApiOperation(value = "Buscar usuario por id", notes="Notas....")
    @GetMapping("/{id}")
    public Client getUserById(@PathVariable(value = "id") long clientId) {
        return this.clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + clientId));
    }

    @PostMapping
    public ResponseEntity<?> createClient(@Valid @RequestBody Client client) {
        if( clientRepository.existsByDni(client.getDni()) )  {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: El DNI existe"));
        }
        if( clientRepository.existsByEmail(client.getEmail()) )  {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: El email existe"));
        }
        clientRepository.save(client);
        return ResponseEntity.ok(new MessageResponse("Usuario Registrado Correctamente"));
    }

    @PutMapping("/{id}")
    public Client updateClient(@RequestBody Client client, @PathVariable ("id") long clientId) {
        Client addClient = this.clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found" + clientId));
        addClient.setFirstName(client.getFirstName());
        addClient.setLastName(client.getLastName());
        addClient.setEmail(client.getEmail());
        addClient.setDni(client.getDni());
        addClient.setTelefono(client.getTelefono());
        return this.clientRepository.save(addClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable ("id") long clientId){
        Client existingClient = this.clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Error id not Found:" + clientId));
        this.clientRepository.delete(existingClient);
        return ResponseEntity.ok().build();
    }
}
