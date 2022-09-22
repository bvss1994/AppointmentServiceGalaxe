package com.cmd.appointment;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cmd.appointment.mapper.*;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Appointment Service", version = "1.0", description = "API for Appointment Service"))
//@EnableEurekaClient
public class CmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmdApplication.class, args);
	}

	@Bean
	public AppointmentMapper getAppointmentMapper() {
		return new AppointmentMapperImpl();
	}

	@Bean
	public PrescriptionMapper getPrescriptionMapper() {
		return new PrescriptionMapperImpl();
	}

	@Bean
	public CommentMapper getCommentMapper() {
		return new CommentMapperImpl();
	}

//	@Bean
//	public FeedbackMapper getFeedbackMapper() {
//		return new FeedbackMapperImpl();
//	}

	@Bean
	public RecommendationMapper getRecommendationMapper() {
		return new RecommendationMapperImpl();
	}

	@Bean
	public TestMapper getTestMapper() {
		return new TestMapperImpl();
	}

	@Bean
	public VitalMapper getVitalMapper() {
		return new VitalMapperImpl();
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
