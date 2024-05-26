package com.mahery.backendjavasmarttix.repository;

import com.mahery.backendjavasmarttix.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}