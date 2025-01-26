package com.exemplo.ingressos.repository;

import com.exemplo.ingressos.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}
