package com.example.springboot_redis_cache_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppConfig {

	@Value("${POSTGRESS_URL}")
	String POSTGRESS_URL;

	@Value("${POSTGRESS_USERNAME}")
	String POSTGRESS_USERNAME;

	@Value("${POSTGRESS_PASSWORD}")
	String POSTGRESS_PASSWORD;

	@Value("${REDIS_HOST}")
	String REDIS_HOST;

	@Value("${REDIS_PORT}")
	String REDIS_PORT;

	@Value("${REDIS_USERNAME}")
	String REDIS_USERNAME;

	@Value("${REDIS_PASSWORD}")
	String REDIS_PASSWORD;

	@Value("${TTL}")
	String TTL;

	public String getPOSTGRESS_URL() {
		return POSTGRESS_URL;
	}

	public void setPOSTGRESS_URL(String pOSTGRESS_URL) {
		POSTGRESS_URL = pOSTGRESS_URL;
	}

	public String getPOSTGRESS_USERNAME() {
		return POSTGRESS_USERNAME;
	}

	public void setPOSTGRESS_USERNAME(String pOSTGRESS_USERNAME) {
		POSTGRESS_USERNAME = pOSTGRESS_USERNAME;
	}

	public String getPOSTGRESS_PASSWORD() {
		return POSTGRESS_PASSWORD;
	}

	public void setPOSTGRESS_PASSWORD(String pOSTGRESS_PASSWORD) {
		POSTGRESS_PASSWORD = pOSTGRESS_PASSWORD;
	}

	public String getREDIS_HOST() {
		return REDIS_HOST;
	}

	public void setREDIS_HOST(String rEDIS_HOST) {
		REDIS_HOST = rEDIS_HOST;
	}

	public String getREDIS_PORT() {
		return REDIS_PORT;
	}

	public void setREDIS_PORT(String rEDIS_PORT) {
		REDIS_PORT = rEDIS_PORT;
	}

	public String getREDIS_USERNAME() {
		return REDIS_USERNAME;
	}

	public void setREDIS_USERNAME(String rEDIS_USERNAME) {
		REDIS_USERNAME = rEDIS_USERNAME;
	}

	public String getREDIS_PASSWORD() {
		return REDIS_PASSWORD;
	}

	public void setREDIS_PASSWORD(String rEDIS_PASSWORD) {
		REDIS_PASSWORD = rEDIS_PASSWORD;
	}

	public String getTTL() {
		return TTL;
	}

	public void setTTL(String tTL) {
		TTL = tTL;
	}

}