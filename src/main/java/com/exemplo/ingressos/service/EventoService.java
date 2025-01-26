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
//os metodos abaixo irão verificar se ao criar um evento, o mesmo estara
// seguindo os requisistos de capacidade >0, conflito de horario com outro evento criado.
    public Evento criarEvento(Evento evento) {
        if (evento.getCapacidade() <= 0) {
            throw new IllegalArgumentException("Capacidade do evento deve ser maior que 0.");
        }
        return eventoRepository.save(evento);
    }

    public boolean verificarConflitoDeHorario(LocalDate data, String local) {
        List<Evento> eventosNoLocal = eventoRepository.findByLocalAndData(local, data);
        return !eventosNoLocal.isEmpty();
    }

    public boolean verificarCapacidade(Evento evento) {
        return evento.getCapacidade() > 0;
    }
}
