package com.cmd.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.appointment.entities.Recommendation;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.RecommendationAlreadyExistException;
import com.cmd.appointment.exception.RecommendationNotFoundException;
import com.cmd.appointment.service.RecommendationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/RecomendationService")
public class RecommendationController {

	@Autowired
	private RecommendationService recSer;

	@PostMapping("/recomendation")
	@Operation(summary = "To add recomendation")
	public ResponseEntity<?> post(@RequestBody Recommendation recomendation) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(recSer.addRecomendation(recomendation), HttpStatus.OK);
		} catch (RecommendationAlreadyExistException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}	

		return response;
	}

	@DeleteMapping("/delete/{Id}")
	@Operation(summary = "To Delete Recomendation")
	public ResponseEntity<?> delete(@PathVariable(value = "Id") long Id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(recSer.removeRecomendation(Id), HttpStatus.OK);
		} catch (RecommendationNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/ViewReccomendation/{aid}")
	@Operation(summary = "To view Reccomendation")
	public ResponseEntity<?> getComment(@RequestParam(value = "appointment_id") long appointment_id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(recSer.viewRecomendationByAppId(appointment_id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
}
