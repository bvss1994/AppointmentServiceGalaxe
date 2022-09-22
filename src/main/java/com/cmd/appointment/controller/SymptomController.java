package com.cmd.appointment.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cmd.appointment.entities.Symptom;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/SymptomService")
public class SymptomController {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(value = "/addSymptom/{appId}")
	@Operation(summary = "To add Symptom")
	public String addSymptom(@PathVariable long appId, @RequestBody Symptom sym) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Symptom> entity = new HttpEntity<Symptom>(sym, headers);

		return restTemplate.exchange("http://localhost:8002/SymptomsProfiles/addSymptom/" + appId, HttpMethod.POST,
				entity, String.class).getBody();
	}

	@GetMapping(value = "/getSymptoms/{appId}")
	@Operation(summary = "To get Symptom")
	public String getSymptom(@PathVariable long appId) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange("http://localhost:8002/SymptomsProfiles/getSymptomsByAppointmentId/" + appId,
				HttpMethod.GET, entity, String.class).getBody();
	}

	@PutMapping(value = "/editSymptom")
	@Operation(summary = "To Edit Symptom")
	public String updateSymptom(@RequestBody Symptom symptom) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Symptom> entity = new HttpEntity<Symptom>(symptom, headers);

		return restTemplate
				.exchange("http://localhost:8002/SymptomsProfiles/editsymptom", HttpMethod.PUT, entity, String.class)
				.getBody();
	}

	@DeleteMapping(value = "/deleteSymptom/{id}")
	@Operation(summary = "To Delete Symptom")
	public String deleteProduct(@PathVariable("id") long id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Symptom> entity = new HttpEntity<Symptom>(headers);

		return restTemplate.exchange("http://localhost:8002/SymptomsProfiles/delete/" + id, HttpMethod.DELETE, entity,
				String.class).getBody();
	}
}
