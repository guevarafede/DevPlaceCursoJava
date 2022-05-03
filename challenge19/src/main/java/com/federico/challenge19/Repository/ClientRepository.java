package com.federico.challenge19.Repository;

import com.federico.challenge19.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findByDni(long dni);
}
