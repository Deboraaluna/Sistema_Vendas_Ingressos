package com.exemplo.ingressos.service;

import com.exemplo.ingressos.model.Compra;
import com.exemplo.ingressos.model.Ingresso;
import com.exemplo.ingressos.repository.CompraRepository;
import com.exemplo.ingressos.repository.IngressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class VendaIngressoService {

    @Autowired
    private IngressoRepository ingressoRepository;

    @Autowired
    private CompraRepository compraRepository;

    /**
     * Método para realizar a compra de um ingresso.
     * @param ingressoId ID do ingresso a ser comprado.
     * @param compradorNome Nome do comprador.
     * @param compradorEmail E-mail do comprador.
     * @param quantidade Quantidade de ingressos a ser comprada.
     * @return Resultado da compra (pode ser uma mensagem ou status).
     */
    public String comprarIngresso(Long ingressoId, String compradorNome, String compradorEmail, Integer quantidade) {
        // Verifica se o ingresso existe
        Ingresso ingresso = ingressoRepository.findById(ingressoId).orElse(null);
        if (ingresso == null) {
            return "Ingresso não encontrado.";
        }

        // Verifica se há ingressos disponíveis
        if (!ingresso.getStatus().equalsIgnoreCase("disponível")) {
            return "Ingressos não disponíveis para venda.";
        }

        // Verifica se a quantidade que o comprador solicitou é maior do que a quantidade de ingressos disponível
        if (quantidade > ingresso.getQuantidade()) {
            return "Quantidade de ingressos solicitada maior que a disponível.";
        }

        // Cria a compra
        Compra compra = new Compra();
        compra.setIngresso(ingresso);
        compra.setCompradorNome(compradorNome);
        compra.setCompradorEmail(compradorEmail);
        compra.setQuantidade(quantidade);
        compra.setTotal(ingresso.getPreco() * quantidade);
        compra.setDataCompra(LocalDateTime.now());

        // armazena a compra
        compraRepository.save(compra);

        // Atualiza o ingresso (diminui a quantidade de ingressos disponíveis)
        ingresso.setQuantidade(ingresso.getQuantidade() - quantidade);
        if (ingresso.getQuantidade() == 0) {
            ingresso.setStatus("vendido");
        }
        ingressoRepository.save(ingresso);

        return "Compra realizada com sucesso!";
    }

    /**
     * Método para verificar se existe e a situação do ingresso...
     * pelo ingressoId ID (disponível, vendido, etc).
     */
    public String verificarStatusIngresso(Long ingressoId) {
        // Verifica se o ingresso existe
        Ingresso ingresso = ingressoRepository.findById(ingressoId).orElse(null);
        if (ingresso == null) {
            return "Ingresso não encontrado.";
        }

        return "Status do ingresso: " + ingresso.getStatus();
    }
}
