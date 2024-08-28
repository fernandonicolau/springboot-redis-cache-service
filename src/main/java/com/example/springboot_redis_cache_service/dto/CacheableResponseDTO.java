package com.example.springboot_redis_cache_service.dto;

import java.time.LocalDateTime;
import java.sql.Timestamp;

public class CacheableResponseDTO<T> {
    private LocalDateTime dateTime;
    private Number timestamp;
    private T result;

    public CacheableResponseDTO(LocalDateTime dateTime, T result) {
    	this.dateTime = dateTime;
        this.timestamp = Timestamp.valueOf(dateTime).getTime();
        this.result = result;
    }
    
    public CacheableResponseDTO() {
    }

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Number getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Number timestamp) {
		this.timestamp = timestamp;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

    
}
