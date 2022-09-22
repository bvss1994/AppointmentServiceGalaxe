package com.cmd.appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cmd.appointment.dtos.PrescriptionDto;
import com.cmd.appointment.entities.Prescription;

@Mapper
public interface PrescriptionMapper {

	@Mapping(source = "prescriptionDetail", target = "prescriptionDetail")
	@Mapping(source = "medicineName", target = "medicineName")
	@Mapping(source = "medicineDuration", target = "medicineDuration")
	@Mapping(source = "medicineCycle", target = "medicineCycle")
	@Mapping(source = "medicineTime", target = "medicineTime")
	
	public PrescriptionDto convertToDto(Prescription prescription);
}
