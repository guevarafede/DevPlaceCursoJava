package com.federico.challenge19.Service;

import com.federico.challenge19.Model.Client;
import com.federico.challenge19.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService {
    @Autowired
    ClientRepository cr;

    //GET ALL USERS:
    public List<Client> getAllClients(){
        return (List<Client>) cr.findAll();
    }
    //Get a specific user

    public Client findByDni(long dni){
        return cr.findByDni(dni);
    }

    public void insertClient(Client c){
        cr.save(c);
    }

    public void deleteClient(Client c ){
        cr.delete(c);
    }


    public boolean updateClient(Client cl){
        cr.save(cl);
        return true;
    }

}
