package com.cmd.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.appointment.entities.Test;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.TestNotFoundException;
import com.cmd.appointment.service.TestService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/TestService")
public class TestController {

	@Autowired
	private TestService testRepo;
	
	@PostMapping("/test")
	@Operation(summary = "To add test")
	public ResponseEntity<?> post(@RequestBody Test test) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(testRepo.saveTest(test), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@DeleteMapping("/deleteTest/{Id}")
	@Operation(summary = "To Delete Test")
	public ResponseEntity<?> deleteTest(@PathVariable(value = "Id") long Id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(testRepo.removeTest(Id), HttpStatus.OK);
		} catch (TestNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;

	}

	@GetMapping("/ViewTests/{aid}")
	@Operation(summary = "To view all Tests")
	public ResponseEntity<?> getTests(@RequestParam (value = "appointment_id") long appointment_id) {
		ResponseEntity<?> response = null;
		try {
			response =  new ResponseEntity<>(testRepo.viewTestByAppId(appointment_id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping("/editTest")
	@Operation(summary = "to edit Test")
	public ResponseEntity<?> put(@RequestBody Test test) throws TestNotFoundException {
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(testRepo.editTest(test), HttpStatus.OK);
		return response;
	}
}
