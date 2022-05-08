package com.federico.challenge19.Controller;

import com.federico.challenge19.Model.Client;
import com.federico.challenge19.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


@Controller //MVC = USO CONTROLLER, API = RESTCONTROLLER.
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientRepository cr;

    @GetMapping
    public String findAll(Model model) {
        Iterable<Client> clients =cr.findAll();
        model.addAttribute("clients",clients );
        return "clients";
    }

    //Aca voy a tener mis dos metodos para el add.
    //Un metodo get y otro post. uno es para el formulario
    //y el otro para mandar a bbdd.
    @GetMapping("/new")
    public String clientForm(Model model){
        Client client = new Client();
        model.addAttribute("title", "Crear Clientes");
        model.addAttribute("client", client);
        return "formulario";
    }

    @PostMapping()
    public String saveClients(@RequestParam(name="file", required = false) MultipartFile foto,
                              @ModelAttribute("client") Client client, RedirectAttributes redirectAttrs) {
        if(!foto.isEmpty()) {
            String ruta = "C://Temp//uploads";
            try{
                byte[] bytes = foto.getBytes();
                Path rutaAbsoluta = Paths.get(ruta +"//" + foto.getOriginalFilename());
                Files.write(rutaAbsoluta, bytes);
                client.setFoto(foto.getOriginalFilename());
            }catch (Exception e ){
                //TODO: handle exception
            }
            cr.save(client);
            redirectAttrs
                    .addFlashAttribute("succes", "Agregado correctamente");
        }
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String clientsFormEdit(@PathVariable (value = "id") long userId,Model model){
        Optional<Client> clients = cr.findById(userId);
        model.addAttribute("title", "Editar Clientes");
        model.addAttribute("client", clients);
        return "formulario";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable(value ="id") long userId, Model model){
        cr.deleteById(userId);
        return "redirect:/clients";
    }

    @GetMapping("/principals")
    public String principal(Model model){
        return "vista";
    }

}
