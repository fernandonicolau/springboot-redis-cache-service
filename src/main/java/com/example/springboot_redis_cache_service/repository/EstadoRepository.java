package com.example.springboot_redis_cache_service.repository;

import com.example.springboot_redis_cache_service.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EstadoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Estado> findAll() {
        String sql = "SELECT * FROM estados";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Estado.class));
    }

    public Optional<Estado> findById(Integer id) {
        String sql = "SELECT * FROM estados WHERE id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Estado.class), id)
                           .stream()
                           .findFirst();
    }
}

