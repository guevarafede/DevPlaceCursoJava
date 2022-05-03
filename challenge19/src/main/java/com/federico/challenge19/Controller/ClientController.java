package com.federico.challenge19.Controller;

import com.federico.challenge19.Model.Client;
import com.federico.challenge19.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller //MVC = USO CONTROLLER, API = RESTCONTROLLER.
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    ClientService cs;

    @GetMapping
    public String getAllClient(Model model){
        model.addAttribute("clientes", cs.getAllClients());
        return "ClientIndex";
    }

    //Aca voy a tener mis dos metodos para el add.
    //Un metodo get y otro post. uno es para el formulario
    //y el otro para mandar a bbdd.
    @GetMapping("/add")
    public String showFormClient(Model model){
        Client c = new Client();
        model.addAttribute("cliente", c);
        return "ClientCreate";
    }

    @PostMapping("/add")
    public String insertClient(@ModelAttribute("clientes") Client c){
        cs.insertClient(c);
        return "redirect:/clientes";
    }

    @GetMapping("/update/{dni}")
    public String showUpdateCliente(@PathVariable("dni") long dni, Model model){
        Client c = cs.findByDni(dni);
        model.addAttribute("cliente", c);
        return "updateCliente";
    }

    @PostMapping("/update/{dni}")
    public String updateClient(@ModelAttribute("cliente") Client cl, @PathVariable("dni") long dni){
        cl.setDni(dni);
        cs.updateClient(cl);
        return "redirect:/clientes";
    }

    @GetMapping("/delete/{dni}")
    public String deleteClient(@PathVariable("dni") long dni){
        cs.deleteClient(cs.findByDni(dni));
        return "redirect:/clientes";
    }

}
