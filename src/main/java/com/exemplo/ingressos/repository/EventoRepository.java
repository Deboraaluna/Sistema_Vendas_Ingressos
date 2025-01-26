package com.exemplo.ingressos.repository;

import com.exemplo.ingressos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByLocalAndData(String local, LocalDate data);
}

//esse metodo do spring jpa faz uma consulta personalizada no evento com base no horio e local

