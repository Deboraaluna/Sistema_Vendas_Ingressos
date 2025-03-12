package com.exemplo.ingressos.service;

import com.exemplo.ingressos.model.Ingresso;
import com.exemplo.ingressos.repository.IngressoRepository;
import com.exemplo.ingressos.exception.IngressoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngressoService {

    @Autowired
    private IngressoRepository ingressoRepository;

    /**
     * Cria um ingresso com um código único (gerado automaticamente no construtor da classe Ingresso)
     *
     * @param ingresso Ingresso a ser criado.
     * @return O ingresso salvo com o código único gerado.
     */
    public Ingresso criarIngresso(Ingresso ingresso) {
        // Validação básica para garantir que o evento e comprador não estão vazios
        if (ingresso.getEvento() == null || ingresso.getEvento().getNome() == null || ingresso.getEvento().getNome().isEmpty()) {
            throw new IllegalArgumentException("Evento é obrigatório!");
        }
        if (ingresso.getComprador() == null || ingresso.getComprador().isEmpty()) {
            throw new IllegalArgumentException("Comprador é obrigatório!");
        }

        // Salva o ingresso no banco de dados
        return ingressoRepository.save(ingresso);
    }

    /**
     * Atualiza um ingresso existente.
     *
     * @param id O ID do ingresso a ser atualizado.
     * @param ingresso O ingresso com os dados atualizados.
     * @return O ingresso atualizado.
     * @throws IngressoNaoEncontradoException Caso o ingresso não seja encontrado.
     */
    public Ingresso atualizarIngresso(Long id, Ingresso ingresso) {
        // Verifica se o ingresso existe antes de tentar atualizar
        if (!ingressoRepository.existsById(id)) {
            throw new IngressoNaoEncontradoException("Ingresso não encontrado!");
        }

        // Atualiza o ID e salva
        ingresso.setId(id);
        return ingressoRepository.save(ingresso);
    }
}
