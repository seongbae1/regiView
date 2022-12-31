package com.psc.regiView.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Constant {

	@Value("${ip}")
	public String ip = "localhost";
	
	@Value("${port}")
	public String port = "5000"; 
	
	
	public String getImageListUrl() {
		return "http://"+ ip +":" + port +"/v2/_catalog";
	}
	
	public String getTagListUrl(String image) {
		return "http://"+ ip +":" + port +"/v2/"+ image +"/tags/list";
	}
	

	
}
