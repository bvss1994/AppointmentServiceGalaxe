package com.cmd.appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cmd.appointment.dtos.AppointmentDto;
import com.cmd.appointment.entities.Appointment;

@Mapper
public interface AppointmentMapper{

	@Mapping(source = "appointment.appointmentId", target = "appointmentId")//Source=Entity, Target=Dto
	@Mapping(source = "appointmentDateTime", target = "appointmentDateTime")
	@Mapping(source = "issue", target = "issue")
	@Mapping(source = "regularity", target = "regularity")
	@Mapping(source = "status", target = "status")
	public AppointmentDto convertToDto(Appointment appointment);//Entity to Dto
}
