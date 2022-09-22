package com.cmd.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.cmd.appointment.entities.Feedback;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/FeedbackController")
public class FeedbackController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value = "/ViewFeedback/{appId}")
	@Operation(summary = "To view Feedback")
	public String viewFeedback(@PathVariable("appId") long appId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Feedback> entity = new HttpEntity<Feedback>(headers);

		return restTemplate.exchange("http://localhost:8002/FeedbackProfiles/viewAppointmentFeedback/"+appId, HttpMethod.GET, entity, String.class).getBody();
	}
}
