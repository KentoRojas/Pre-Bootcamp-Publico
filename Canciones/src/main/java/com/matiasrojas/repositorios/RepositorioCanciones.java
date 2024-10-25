package com.matiasrojas.repositorios;

import com.matiasrojas.modelos.Cancion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
    List<Cancion> findAll();
    
    Optional<Cancion> findById(Long id);
}
