package com.example.springboot_redis_cache_service.mapper;

import com.example.springboot_redis_cache_service.dto.EstadoDTO;
import com.example.springboot_redis_cache_service.model.Estado;

public class EstadoMapper {

    public static EstadoDTO toDTO(Estado estado) {
        if (estado == null) {
            return null;
        }
        return new EstadoDTO(
                estado.getId(),
                estado.getNome(),
                estado.getSigla());
    }

    public static Estado toModel(EstadoDTO estadoDto) {
        return new Estado(
                estadoDto.getId(),
                estadoDto.getNome(),
                estadoDto.getSigla());
    }
}
