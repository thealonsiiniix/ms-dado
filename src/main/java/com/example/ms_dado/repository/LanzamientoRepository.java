package com.example.ms_dado.repository;

import com.example.ms_dado.model.Lanzamiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanzamientoRepository extends JpaRepository<Lanzamiento, Long> {
}