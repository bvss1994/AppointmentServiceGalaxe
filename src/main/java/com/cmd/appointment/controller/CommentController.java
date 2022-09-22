package com.cmd.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cmd.appointment.entities.Comment;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.CommentAlreadyExistException;
import com.cmd.appointment.exception.CommentNotFoundException;
import com.cmd.appointment.service.CommentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/ApppointmentService")
public class CommentController {

	@Autowired
	private CommentService comService;
	
	@PostMapping("/AddComment")
	@Operation(summary = "To add Comment")
	public ResponseEntity<?> postComment(@RequestBody Comment comment) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(comService.addComment(comment), HttpStatus.OK);
		} catch (CommentAlreadyExistException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/ViewComment/{aid}")
	@Operation(summary = "To view Comment")
	public ResponseEntity<?> getComment(@RequestParam(value = "appointment_id") long appointment_id) {
		ResponseEntity<?> response = null;
		try {
			response =  new ResponseEntity<>(comService.viewCommentByAppId(appointment_id), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

	@PutMapping("/editComment")
	@Operation(summary = "To edit Comment")
	public ResponseEntity<?> put(@RequestBody Comment comment) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(comService.editComment(comment), HttpStatus.OK);
		} catch (CommentNotFoundException e) {
			// TODO Auto-generated catch block
			response =  new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
}
