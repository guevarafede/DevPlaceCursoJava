package com.bragadini.matias.services;

import com.bragadini.matias.model.Estudiante;
import com.bragadini.matias.repositories.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServices {

    @Autowired
    EstudianteRepo er;

    public List<Estudiante> getAll(){
        return (List<Estudiante>) er.findAll();

    }

    public Estudiante getOne(long dni){
        return er.getById(dni);
    }

    public void insert(Estudiante e){
        er.save(e);
    }

    public void delete(Estudiante e){
        er.delete(e);
    }

    public boolean update(Estudiante pers) {
        if(er.existsById(pers.getDni())) {
            er.save(pers);
            return true;
        } else
            return false;
    }

}
