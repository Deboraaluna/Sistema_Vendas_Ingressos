package com.exemplo.ingressos.repository;

import com.exemplo.ingressos.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findByCompradorEmail(String email);
}

