package com.example.springboot_redis_cache_service.controller;

import com.example.springboot_redis_cache_service.dto.CacheableResponseDTO;
import com.example.springboot_redis_cache_service.dto.EstadoDTO;
import com.example.springboot_redis_cache_service.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<EstadoDTO> findAll() {
        return estadoService.findAll();
    }
    
    @GetMapping("/cacheable")
    public CacheableResponseDTO<List<EstadoDTO>> findAllCacheable() {
        return estadoService.findAllCacheable();
    }

    @GetMapping("/{id}")
    public EstadoDTO findById(@PathVariable Integer id) {
        return estadoService.findById(id);
    }

}
