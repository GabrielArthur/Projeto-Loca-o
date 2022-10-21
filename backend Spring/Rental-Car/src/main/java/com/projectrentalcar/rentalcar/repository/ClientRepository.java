package com.projectrentalcar.rentalcar.repository;

import com.projectrentalcar.rentalcar.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
