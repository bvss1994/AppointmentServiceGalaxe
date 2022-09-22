package com.cmd.appointment.entities;

import javax.persistence.CascadeType;
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
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long prescriptionId;
	private String prescriptionDetail;
	private String medicineName;
	private int medicineDuration;
	private String medicineCycle;
	private String medicineTime;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;
}
