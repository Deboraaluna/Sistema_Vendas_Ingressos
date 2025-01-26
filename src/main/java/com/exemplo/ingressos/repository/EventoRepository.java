package com.exemplo.ingressos.repository;

import com.exemplo.ingressos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Consulta para verificar se há eventos no mesmo local com a mesma data através do list
    List<Evento> findByLocalAndDatasContaining(String local, LocalDate data);
}
