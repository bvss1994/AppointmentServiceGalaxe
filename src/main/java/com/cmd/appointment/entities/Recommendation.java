package com.cmd.appointment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recommendation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long recommendationId;
	private long doctorId;
	
	@OneToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;
}
