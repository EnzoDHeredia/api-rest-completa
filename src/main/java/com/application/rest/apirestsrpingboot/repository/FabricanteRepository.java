package com.application.rest.apirestsrpingboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.application.rest.apirestsrpingboot.entities.Fabricante;

@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Long>{

}
