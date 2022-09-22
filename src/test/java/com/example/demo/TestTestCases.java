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
import com.cmd.appointment.repository.TestRepository;
import com.cmd.appointment.service.TestService;
import com.cmd.appointment.serviceImpl.TestServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestTestCases {

	@Mock
	private TestRepository trepo;
	
	TestService testService;
	
	@BeforeEach
	void initUseCase() {
		
		testService = new TestServiceImpl(trepo);
	}
	
	@Test
	public void addTestTest() {
		
//		Doctor doctor = new Doctor(0,"sad", 2134567, "saf","sdasf", "asfdsggf",0);
		
//		Patient patient = new Patient(0, "saf", 30,"asfa","asd","asd","adsa",1242346,132, "aD", "SDA", "dfsdg", "dfsdf");
		
		Appointment appointment = new Appointment(0, "sdafd", "asd", "sadad", "sadfas",132412,123124);
		
		com.cmd.appointment.entities.Test test = new com.cmd.appointment.entities.Test();
		test.setTestId(0);
		test.setTestName("Test1");
		test.setAppointment(appointment);
		
		when(trepo.save(any(com.cmd.appointment.entities.Test.class))).thenReturn(test);
		com.cmd.appointment.entities.Test savedTest = trepo.save(test);
		assertThat(savedTest.getTestId()).isNotNull();
	}
	
	@Test
	public void viewTestByAppointmentId() {
		
		List<com.cmd.appointment.entities.Test> tests = trepo.getTestsByAppId(2);
		assertThat(tests.listIterator()).isNotNull();
	}
	
	
}
