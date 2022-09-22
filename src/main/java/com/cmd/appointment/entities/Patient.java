package com.cmd.appointment.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patientId;
	private String patientName;
	private int patientAge;
	private String patientGender;
	private String DOB;
	private int patientHeight;
	private String patientBloodGroup;
	private String allergies;
	private String activeIssues;
	private String medicalProblems;
	private long patientMobileNumber;
	private String email;
	private String Address;
	
	
}
