package com.exemplo.ingressos.service;

import com.exemplo.ingressos.model.Evento;
import com.exemplo.ingressos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    // Método cria evento, validando se a capacidade é >0
    public Evento criarEvento(Evento evento) {
        if (evento.getCapacidade() <= 0) {
            throw new IllegalArgumentException("Capacidade do evento deve ser maior que 0.");
        }
        return eventoRepository.save(evento);
    }

    // corrigir para verificar conflito de horário
    // a lista de data que o metodo list de repository chama

    public boolean verificarConflitoDeHorario(LocalDate data, String local) {
        // corrigido
        List<Evento> eventosNoLocal = eventoRepository.findByLocalAndDatasContaining(local, data);
        return !eventosNoLocal.isEmpty();  // Retorna true se já houver conflito de evento
    }

    // verifica se a capacidade do evento é > 0
    public boolean verificarCapacidade(Evento evento) {
        return evento.getCapacidade() > 0;
    }
}
