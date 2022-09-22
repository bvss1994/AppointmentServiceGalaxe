package com.cmd.appointment.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VitalDto {


	private int ECG;
	private float temperature;
	private int diabetes;
	private int respirationRate;
}
