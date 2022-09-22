package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cmd.appointment.entities.Appointment;
import com.cmd.appointment.entities.Vital;
import com.cmd.appointment.repository.VitalRepository;
import com.cmd.appointment.service.VitalService;
import com.cmd.appointment.serviceImpl.VitalServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VitalTestCases {

	@Mock
	private VitalRepository vrepo;
	
	VitalService vitalService;
	
	@BeforeEach
	void initUseCase() {
		
		vitalService = new VitalServiceImpl(vrepo);
	}
	
	@Test
	public void addVitalTest() {
		
//		Doctor doctor = new Doctor(0,"sad", 2134567, "saf","sdasf", "asfdsggf",0);
		
//		Patient patient = new Patient(0, "saf", 30,"asfa","asd","asd","adsa",1242346,132, "aD", "SDA", "dfsdg", "dfsdf");
		
		Appointment appointment = new Appointment(0, "sdafd", "asd", "sadad", "sadfas",132412,123124);
//		
		Vital vital = new Vital();
		vital.setVitalId(6);
		vital.setTemperature(30);
		vital.setRespirationRate(98);
		vital.setECG(90);
		vital.setDiabetes(100);
		vital.setAppointment(appointment);
		
		when(vrepo.save(any(Vital.class))).thenReturn(vital);
		Vital savedVital = vrepo.save(vital);
		assertThat(savedVital.getVitalId()).isNotNull();
	}
	
//	@Test
//	public void viewVitalByAppointmentId() {
//		
//		com.cmd.appointment.entities.Vital newvital = vrepo.getVitalsByAppId(2);
//		assertThat(newvital.getVitalId()).isNotNull();
//	}

}
