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

import com.cmd.appointment.entities.Vital;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.VitalNotFoundException;
import com.cmd.appointment.service.VitalService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/VitalService")
public class VitalController {

	@Autowired
	private VitalService vitService;

	@PostMapping("/addVital")
	@Operation(summary = "to add Vital for appointment")
	public ResponseEntity<?> addVital(@RequestBody Vital vital) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(vitService.addvital(vital), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@PutMapping("/Vital/Edit")
	@Operation(summary = "to edit Vitals")
	public ResponseEntity<?> put(@RequestBody Vital vital) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(vitService.editvitals(vital), HttpStatus.OK);
		} catch (VitalNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "To delete Vital by using id")
	public ResponseEntity<?> deleteVital(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(vitService.DeleteVital(id), HttpStatus.OK);
		} catch (VitalNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewVitals/v/{aid}")
	@Operation(summary = "To view all Vital")
	public ResponseEntity<?> getVitals(@RequestParam(value = "aid") long aid) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(vitService.viewVitalByAppId(aid), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
}
