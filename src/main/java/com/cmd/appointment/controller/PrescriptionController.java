	package com.cmd.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cmd.appointment.entities.Prescription;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.PrescriptionNotFoundException;
import com.cmd.appointment.service.PrescriptionService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/PrescriptionService")
public class PrescriptionController {

	@Autowired
	private PrescriptionService presRepo;
	
	@PostMapping("/addPrescription")
	@Operation(summary = "to add prescription for appointment")
	public ResponseEntity<?> addPrescription(@RequestBody Prescription prescription) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(presRepo.savePrescription(prescription), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/ViewPrescriptions/a/{aid}")
	@Operation(summary = "To view all prescription")
	public ResponseEntity<?> getPrescriptions(@RequestParam (value = "aid") long aid) {
		ResponseEntity<?> response = null;
		try {
			response =  new ResponseEntity<>(presRepo.viewPrescriptionsByAppId(aid), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping("/deletePrescriptionById/{id}")
	@Operation(summary = "To delete prescription")
	public ResponseEntity<?> deletePrescription(@PathVariable (value = "id") long id){
		ResponseEntity<?> response = null;
		try {
			response =  new ResponseEntity<>(presRepo.deletePrescription(id), HttpStatus.OK);
		} catch (PrescriptionNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@PutMapping("/editPrescription")
	@Operation(summary = "To edit Prescription")
	public ResponseEntity<?> put(@RequestBody Prescription prescription) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(presRepo.editPrescription(prescription), HttpStatus.OK);
		} catch (PrescriptionNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
}
