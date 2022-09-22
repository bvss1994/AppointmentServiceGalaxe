package com.cmd.appointment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long testId;
	private String testName;
	
	@ManyToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;
}
