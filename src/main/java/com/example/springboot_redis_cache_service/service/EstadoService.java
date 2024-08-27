package com.example.springboot_redis_cache_service.service;

import com.example.springboot_redis_cache_service.dto.EstadoDTO;
import com.example.springboot_redis_cache_service.mapper.EstadoMapper;
import com.example.springboot_redis_cache_service.model.Estado;
import com.example.springboot_redis_cache_service.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoDTO> findAll() {
        List<Estado> estados = estadoRepository.findAll();
        return estados.stream()
                .map(EstadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EstadoDTO findById(Integer id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado com id: " + id));
        return EstadoMapper.toDTO(estado);
        
    }
}
 