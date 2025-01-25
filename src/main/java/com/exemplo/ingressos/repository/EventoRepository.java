package com.exemplo.ingressos.repository;

import com.exemplo.ingressos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}