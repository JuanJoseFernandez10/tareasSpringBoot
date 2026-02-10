package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entidad.Evento;
import java.util.List;
import java.util.Optional;


@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

	Optional<Evento> findByNombre(String nombre);
}
