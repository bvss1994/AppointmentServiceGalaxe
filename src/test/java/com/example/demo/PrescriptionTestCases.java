package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cmd.appointment.entities.Appointment;
import com.cmd.appointment.entities.Prescription;
import com.cmd.appointment.repository.PrescriptionRepository;
import com.cmd.appointment.service.PrescriptionService;
import com.cmd.appointment.serviceImpl.PrescriptionServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PrescriptionTestCases {

	@Mock
	private PrescriptionRepository prescriptionRepository;
	
	PrescriptionService prescriptionService;
	
	@BeforeEach
	void initUseCase() {
		
		prescriptionService = new PrescriptionServiceImpl(prescriptionRepository);
	}
	
	@Test
	public void addPreTest() {
		
//		Doctor doctor = new Doctor(0,"sad", 2134567, "saf","sdasf", "asfdsggf", 0);
		
//		Patient patient = new Patient(0, "saf", 30,"asfa","asd","asd","adsa",1242346,132, "aD", "SDA", "dfsdg", "dfsdf");
		
		Appointment appointment = new Appointment(0, "sdafd", "asd", "sadad", "sadfas",132412,123124);
		
		Prescription prescription = new Prescription();
		prescription.setPrescriptionId(0);
		prescription.setPrescriptionDetail("pre1");
		prescription.setMedicineTime("3.00");
		prescription.setMedicineName("Crocine");
		prescription.setMedicineDuration(3);
		prescription.setMedicineCycle("daily");
		prescription.setAppointment(appointment);
		
		when(prescriptionRepository.save(any(Prescription.class))).thenReturn(prescription);
		Prescription savedPrescription = prescriptionRepository.save(prescription);
		assertThat(savedPrescription.getPrescriptionId()).isNotNull();
	}
	
	@Test
	public void viewPrescriptionByAppointmentId() {
		
		List<Prescription> prescription = prescriptionRepository.getPrescriptionsByAppId(2);
		assertThat(prescription.listIterator()).isNotNull();
	}
	
	
	
}
