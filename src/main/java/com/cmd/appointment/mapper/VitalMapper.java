package com.cmd.appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cmd.appointment.dtos.VitalDto;
import com.cmd.appointment.entities.Vital;

@Mapper
public interface VitalMapper {

	@Mapping(source = "ECG",target = "ECG")
	@Mapping(source = "temperature",target = "temperature")
	@Mapping(source = "diabetes",target = "diabetes")
	@Mapping(source = "respirationRate",target = "respirationRate")
	public VitalDto convertToDto(Vital vital);
}