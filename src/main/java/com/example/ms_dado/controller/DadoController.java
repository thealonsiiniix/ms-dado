package com.example.ms_dado.controller;

import com.example.ms_dado.model.Lanzamiento;
import com.example.ms_dado.service.DadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dado")
public class DadoController {

    private final DadoService dadoService;

    public DadoController(DadoService dadoService) {
        this.dadoService = dadoService;
    }

    @PostMapping("/lanzar")
    public ResponseEntity<Lanzamiento> lanzarDado() {

        Lanzamiento lanzamiento = dadoService.lanzarDado();

        return ResponseEntity.ok(lanzamiento);
    }

    @GetMapping
    public ResponseEntity<List<Lanzamiento>> obtenerTodos() {

        return ResponseEntity.ok(dadoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lanzamiento> obtenerPorId(@PathVariable Long id) {

        return dadoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
