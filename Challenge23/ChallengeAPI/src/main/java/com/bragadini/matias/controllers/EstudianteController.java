package com.bragadini.matias.controllers;


import com.bragadini.matias.model.Estudiante;
import com.bragadini.matias.services.EstudianteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")

public class EstudianteController {

    @Autowired
    EstudianteServices es;

    @GetMapping
    public List<Estudiante> getAllEstudiantes(){
        return es.getAll();

    }

    @GetMapping("/search/{dni}")
    public Estudiante getEstudiante(@PathVariable("dni") long dni){
        return es.getOne(dni);
    }


    @PostMapping("/createEstudiante")
    public void saveEstudiante(@RequestBody Estudiante e){
        es.insert(e);
    }

    @PutMapping("/update/{dni}")
    public void update(@RequestBody Estudiante pers) {
        es.update(pers);
    }

    @DeleteMapping("/delete/{dni}")
    public void deleteEstudiante(@PathVariable("dni") long dni){
        Estudiante est = es.getOne(dni);
        es.delete(est);
    }




}
