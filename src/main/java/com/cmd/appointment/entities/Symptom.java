package com.cmd.appointment.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long symp_id;
	private String sympName;
	private long sympReadings;
	private long appointmentId;

}