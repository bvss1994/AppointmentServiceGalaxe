package com.cmd.appointment.mapper;

import org.mapstruct.Mapper;

import com.cmd.appointment.dtos.RecommendationDto;
import com.cmd.appointment.entities.Recommendation;

@Mapper
public interface RecommendationMapper {

//	@Mapping(source = "recommendationId", target = "recommendationId")
//	@Mapping(source = "doctor.doctorId", target = "doctorId")
//	@Mapping(source = "appointment.appointmentId", target = "appointmentId")
	public RecommendationDto convertToDto(Recommendation recommendation);
}
