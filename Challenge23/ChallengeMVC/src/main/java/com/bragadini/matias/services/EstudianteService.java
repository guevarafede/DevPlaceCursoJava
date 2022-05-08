package com.bragadini.matias.services;


import com.bragadini.matias.models.Estudiante;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class EstudianteService {
    public ArrayList<Estudiante> getEstudiantes() {
        String url = "http://localhost:8080/estudiantes";
        RestTemplate rt = new RestTemplate();
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes = rt.getForObject(url, ArrayList.class);
        return estudiantes;
    }

    public void saveEstudiante(Estudiante es) {
        String url = "http://localhost:8080/estudiantes/createEstudiante";
        RestTemplate rt = new RestTemplate();
        rt.postForObject(url, es, Estudiante.class);
    }

    public void deleteEstudiante(long dni) {
        String url = "http://localhost:8080/estudiantes/delete/" + dni;
        RestTemplate rt = new RestTemplate();
        rt.delete(url);
    }

    public void updateEstudiante(Estudiante es) {
        String url = "http://localhost:8080/estudiantes/update/" + es.getDni();
        RestTemplate rt = new RestTemplate();
        rt.put(url, es, Estudiante.class);
    }

    public Estudiante getEstudianteDNI(long dni){
        String url = "http://localhost:8080/estudiantes/search/"+dni;
        RestTemplate rt = new RestTemplate();
        Estudiante estudiante;
        estudiante = rt.getForObject(url,Estudiante.class);
        return estudiante;
    }

}
