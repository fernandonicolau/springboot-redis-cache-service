package com.example.springboot_redis_cache_service.cache;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CacheManager {
    private final Map<String, Object> cache = new ConcurrentHashMap<>();

    public <T> void putInCache(String key, T value) {
        cache.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getFromCache(String key) {
        return (T) cache.get(key);
    }

    public void removeFromCache(String key) {
        cache.remove(key);
    }
}
