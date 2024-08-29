package com.example.springboot_redis_cache_service.service;

import com.example.springboot_redis_cache_service.cache.CacheManager;
import com.example.springboot_redis_cache_service.dto.CacheableResponseDTO;
import com.example.springboot_redis_cache_service.dto.EstadoDTO;
import com.example.springboot_redis_cache_service.mapper.EstadoMapper;
import com.example.springboot_redis_cache_service.model.Estado;
import com.example.springboot_redis_cache_service.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoService {
	
	@Autowired
	private Environment env;

    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    private CacheManager cacheManager;
   
    public List<EstadoDTO> findAll() {
        List<Estado> estados = estadoRepository.findAll();
        return estados.stream()
                .map(EstadoMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public CacheableResponseDTO<List<EstadoDTO>> findAllCacheable() {	
    	
        final String FIND_ALL_CACHE_KEY = "FIND_ALL_CACHE_KEY";
    	int TTL = Integer.parseInt(env.getProperty("TTL"));

    	CacheableResponseDTO<List<EstadoDTO>> cacheableResponse = cacheManager.getFromCache(FIND_ALL_CACHE_KEY);
    	
        if (cacheableResponse != null && cacheableResponse.getDateTime().isAfter(LocalDateTime.now().minusSeconds(TTL))) {
            return cacheableResponse;
        }

        List<Estado> estados = estadoRepository.findAll();
        
        if (estados != null && !estados.isEmpty()) {
	        
        	List<EstadoDTO> estatodDTO = estados.stream()
	        .map(EstadoMapper::toDTO)
	        .collect(Collectors.toList());
        
            CacheableResponseDTO<List<EstadoDTO>> newCacheableResponse = new CacheableResponseDTO<>(LocalDateTime.now(), estatodDTO);
            cacheManager.putInCache(FIND_ALL_CACHE_KEY, newCacheableResponse);
            
            return newCacheableResponse;
        }

		return cacheableResponse;
    }
    
    public CacheableResponseDTO<EstadoDTO> findById(Integer id) {

    	final String FIND_ESTADO_ID_CACHE_KEY = "FIND_ESTADO_ID_CACHE_KEY_" + id;
    	int TTL = Integer.parseInt(env.getProperty("TTL"));

        CacheableResponseDTO<EstadoDTO> cacheableResponse = cacheManager.getFromCache(FIND_ESTADO_ID_CACHE_KEY);

        if (cacheableResponse != null
                && cacheableResponse.getDateTime().isAfter(LocalDateTime.now().minusSeconds(TTL))) {
            return cacheableResponse;
        }

        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado não encontrado com id: " + id));

        EstadoDTO estatodDTO = EstadoMapper.toDTO(estado);

        CacheableResponseDTO<EstadoDTO> newCacheableResponse = new CacheableResponseDTO<>(LocalDateTime.now(),
                estatodDTO);
        cacheManager.putInCache(FIND_ESTADO_ID_CACHE_KEY, newCacheableResponse);

        return newCacheableResponse;

    }
}
 