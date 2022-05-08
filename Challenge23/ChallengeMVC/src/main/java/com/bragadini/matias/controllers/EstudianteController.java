package com.bragadini.matias.controllers;

import com.bragadini.matias.models.Estudiante;
import com.bragadini.matias.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    EstudianteService es;

    @GetMapping("/all")
    public String getEstudiantes(Model model){
        model.addAttribute("estudiantes", es.getEstudiantes());
        return "EstudianteIndex";
    }

    @GetMapping("/create")
    public String estudianteForm(Model model){
        Estudiante e = new Estudiante();
        model.addAttribute("estudiante", e);
        return "EstudianteCreate";
    }

    @PostMapping("/create")
    public String createEstudiante(@ModelAttribute("estudiante") Estudiante e){
        es.saveEstudiante(e);
        return "redirect:/estudiantes/all";
    }

    @GetMapping("/update/{dni}")
    public String showFormUpdate(@PathVariable("dni") long dni, Model model){
        Estudiante est = es.getEstudianteDNI(dni);
        model.addAttribute("estudiante", est);
        return "EstudianteUpdate";
    }

    @PostMapping("/update/{dni}")
    public String updateEstudiante(@ModelAttribute("estudiante") Estudiante est, @PathVariable("dni") long dni){
        es.updateEstudiante(est);
        return "redirect:/estudiantes/all";
    }

    @GetMapping("/delete/{dni}")
    public String deleteEstudiante(@PathVariable("dni") long dni){
     es.deleteEstudiante(dni);
     return "redirect:/estudiantes/all";
    }



}
