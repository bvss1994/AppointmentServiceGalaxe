package com.cmd.appointment.service;

import com.cmd.appointment.dtos.RecommendationDto;
import com.cmd.appointment.entities.Recommendation;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.RecommendationAlreadyExistException;
import com.cmd.appointment.exception.RecommendationNotFoundException;

public interface RecommendationService {

	public Recommendation addRecomendation(Recommendation recomendation) throws RecommendationAlreadyExistException;

	public String removeRecomendation(long id) throws RecommendationNotFoundException;

	public RecommendationDto viewRecomendationByAppId(long aid) throws AppointmentNotFoundException;

}
