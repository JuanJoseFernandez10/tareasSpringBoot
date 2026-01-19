package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entidad.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long>{

	
}
