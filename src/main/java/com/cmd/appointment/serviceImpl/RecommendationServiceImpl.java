package com.cmd.appointment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cmd.appointment.dtos.RecommendationDto;
import com.cmd.appointment.entities.Doctor;
import com.cmd.appointment.entities.Recommendation;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.RecommendationAlreadyExistException;
import com.cmd.appointment.exception.RecommendationNotFoundException;
import com.cmd.appointment.mapper.RecommendationMapper;
import com.cmd.appointment.repository.AppointmentRepository;
import com.cmd.appointment.repository.RecommendationRepository;
import com.cmd.appointment.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	@Autowired
	private RecommendationRepository reRepo;

	@Autowired
	private AppointmentRepository appRepo;

	@Autowired
	private RecommendationMapper recommendationMapper;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Recommendation addRecomendation(Recommendation recomendation)
			throws RecommendationAlreadyExistException {
		
		long docId = recomendation.getDoctorId();
		
		// TODO Auto-generated method stub
		if (reRepo.getReccomendationByAppId(recomendation.getAppointment().getAppointmentId()) != null) {
			throw new RecommendationAlreadyExistException("Recommendation already exists");
		} else {

			String URL1 = "http://localhost:8003/settings_doctor/getDoctor";

			ResponseEntity<Doctor[]> response1 = restTemplate.getForEntity(URL1, Doctor[].class);
			Doctor[] doctors = response1.getBody();

			for (int i = 0; i < doctors.length; i++) {
				if (doctors[i].getDoctorId() == docId) {
					recomendation.setDoctorId(docId);
					reRepo.save(recomendation);
				}
			}
		}
		return recomendation;
	}

	public String removeRecomendation(long Id) throws RecommendationNotFoundException {
		// TODO Auto-generated method stub
		if (reRepo.existsById(Id)) {
			reRepo.deleteById(Id);
		} else {
			throw new RecommendationNotFoundException(" Recommendation not found");
		}
		return "Deleted";
	}

	@Override
	public RecommendationDto viewRecomendationByAppId(long aid) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		if (appRepo.existsById(aid)) {
			Recommendation reccomendation = reRepo.getReccomendationByAppId(aid);
			RecommendationDto recommendationDto = recommendationMapper.convertToDto(reccomendation);
			return recommendationDto;

		} else {
			throw new AppointmentNotFoundException(" Appointment not found");
		}
	}
}
