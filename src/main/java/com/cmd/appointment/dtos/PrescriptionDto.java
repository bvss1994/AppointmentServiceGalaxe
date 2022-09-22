package com.cmd.appointment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionDto {

	private String prescriptionDetail;
	private String medicineName;
	private int medicineDuration;
	private String medicineCycle;
	private String medicineTime;

}
