package com.example.ms_dado.service;

import com.example.ms_dado.model.Lanzamiento;
import com.example.ms_dado.repository.LanzamientoRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DadoService {

    private final LanzamientoRepository lanzamientoRepository;

    private final SecureRandom random = new SecureRandom();

    public DadoService(LanzamientoRepository lanzamientoRepository) {
        this.lanzamientoRepository = lanzamientoRepository;
    }

    public Lanzamiento lanzarDado() {

        int resultado = random.nextInt(6) + 1;

        Lanzamiento lanzamiento = new Lanzamiento();
        lanzamiento.setResultado(resultado);
        lanzamiento.setFecha(LocalDateTime.now());

        return lanzamientoRepository.save(lanzamiento);
    }

    public List<Lanzamiento> obtenerTodos() {
        return lanzamientoRepository.findAll();
    }

    public Optional<Lanzamiento> obtenerPorId(Long id) {
        return lanzamientoRepository.findById(id);
    }

    public void eliminar(Long id) {
        lanzamientoRepository.deleteById(id);
    }
}