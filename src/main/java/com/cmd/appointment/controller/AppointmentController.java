package com.cmd.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.appointment.entities.Appointment;
import com.cmd.appointment.exception.AppointmentAlreadyExistException;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.DoctorNotFoundException;
import com.cmd.appointment.exception.PatientNotFoundException;
import com.cmd.appointment.service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ApppointmentService")
public class AppointmentController {

	@Autowired
	private AppointmentService appService;

	@GetMapping("/Appointment/getAllApoointment")
	public ResponseEntity<?> getAllAppointments() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.getAllAppointment(), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<String>(e.getMessage() ,HttpStatus.OK);
		}
		return response;
	}
	
	@PostMapping("/SaveAppointment")
	@Operation(summary = "to save appointment")
	public ResponseEntity<?> postAppointment(@RequestBody Appointment appointment) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.saveAppointment(appointment), HttpStatus.OK);
		} catch (AppointmentAlreadyExistException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<String>(e.getMessage() ,HttpStatus.OK);
		} catch (DoctorNotFoundException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<String>(e.getMessage() ,HttpStatus.OK);
		} catch (PatientNotFoundException e) {
			// TODO Auto-generated catch block
			response = new ResponseEntity<String>(e.getMessage() ,HttpStatus.OK);
		};
		
		return response;
	}

	@GetMapping("/Appointment/AcceptedAppointments")
	@Operation(summary = "to get accepted appointment count")
	public ResponseEntity<?> getAcceptedAppointment() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewAllAcceptedAppointmentSummary(), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/Appointment/Cancelledappointments")
	@Operation(summary = "to get cancelled appointment count")
	public ResponseEntity<?> getCancelledRequest() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewCancelledAppointmentSummary(), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/Appointment/{status}")
	@Operation(summary = "to get filtered appointment list")
	public ResponseEntity<?> getFilteredRequest(@PathVariable(value = "status") String status) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewFilterAppointmentsDTO(status), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

//	@GetMapping("/Appointments/{id}")
//	@Operation(summary = "to get All appointment list")
//	public ResponseEntity<?> getAllRequest(@PathVariable(value = "id") long id) {
//		ResponseEntity<?> response = null;
//		try {
//			response = new ResponseEntity<>(appService.viewAllAppointmentsForDoctor(id), HttpStatus.OK);
//		} catch (AppointmentNotFoundException e) {
//			// TODO Auto-generated catch block
//			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//		}
//		return response;
//	}

	@PutMapping("/acceptAppointment/{appId}")
	@Operation(summary = "To accept Appointment")
	public ResponseEntity<?> accpetAppointment(@PathVariable(value = "appId") long appId) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.AcceptAppointment(appId), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}

	@PutMapping("/CloseAppointment/{appId}")
	@Operation(summary = "To Close Appointment")
	public ResponseEntity<?> CloseAppointment(@PathVariable(value = "appId") long appId) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.CloseAppointment(appId), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}

	@PutMapping("/CancelAppointment/{appId}")
	@Operation(summary = "To Cancel Appointment")
	public ResponseEntity<?> CancelAppointment(@PathVariable(value = "appId") long appId) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.CancelAppointment(appId), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}


	@GetMapping("/ViewAcceptedAppointments/{docId}")
	@Operation(summary = "To view Accepted appointments for doctor")
	public ResponseEntity<?> getAcceptedAppointments(@PathVariable(value = "docId") long docId) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewAcceptedAppointment(docId), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewPendingAppointments/{docid}")
	@Operation(summary = "To view all pending appointments for doctor")
	public ResponseEntity<?> getPendingAppointments(@PathVariable(value = "docid") long docid) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewPendingAppointment(docid), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewCancelledAppointments/{docid}")
	@Operation(summary = "To view all cancelled appointments for Doctor")
	public ResponseEntity<?> getCancelledAppointments(@PathVariable(value = "docid") long docid) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewCancelledAppointment(docid), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewClosedAppointments/{docid}")
	@Operation(summary = "To view all closed appointments for Doctor")
	public ResponseEntity<?> getClosedAppointments(@PathVariable(value = "docid") long docid) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewClosedAppointment(docid), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@GetMapping("/ViewAppointmentsForDay/{docid}/{date}")
	@Operation(summary = "To view all appointments For The Day of Doctor")
	public ResponseEntity<?> getAppointmentsForDay(@PathVariable(value = "docid") long docid,
			@PathVariable(value = "date") String date) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.ViewAllAppointmentsForTheDay(docid, date), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/Appointment/getByDoctorId/{docid}")
	@Operation(summary = "To get All Appointment for Doctor")
	public ResponseEntity<?> viewAppointmentByDoctor(@PathVariable(value = "docid") long docid) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(appService.viewAllAppointmentsByDoctorId(docid), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}
}
