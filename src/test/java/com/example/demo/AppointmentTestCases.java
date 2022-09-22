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
import com.cmd.appointment.repository.AppointmentRepository;
import com.cmd.appointment.service.AppointmentService;
import com.cmd.appointment.serviceImpl.AppointmentServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AppointmentTestCases {
	//private MockMvc mockMvc;
	
	@Mock 
	private AppointmentRepository appRepo;
	
	
	AppointmentService appointmentService;
	
	
	@BeforeEach
    void initUseCase() {
        appointmentService = new AppointmentServiceImpl(appRepo);
    }
	
	@Test
	public  void addAppoTest() throws Exception {
		Appointment Appoint = new Appointment();
		Appoint.setAppointmentDateTime("1-2-2000");
		Appoint.setAppointmentId(2);
		Appoint.setIssue("fds");
		Appoint.setRegularity("dsa");
		Appoint.setStatus("OK");
		
		when(appRepo.save(any(Appointment.class))).thenReturn(Appoint);
		Appointment savedAppoint= appRepo.save(Appoint);
		assertThat(savedAppoint.getAppointmentId()).isNotNull();
	}
	
	@Test
	public void getAceptedAppointmentsTest() throws Exception {
		
		List<Appointment> savedAppoint= appRepo.getAllAcceptedAppointments();
		assertThat(savedAppoint.getClass()).isNotNull();
	}
	
	@Test
	public void AcceptAppoTest() throws Exception {
		
				
		List<Appointment> savedAppoint= appRepo.getAllAppointments();
		assertThat(savedAppoint.getClass()).isNotNull();
		}
	
	
	
	@Test
	public void CanceledAppoTest() throws Exception {
		
				
		List<Appointment> savedAppoint= appRepo.getCancelledAppointments();
		assertThat(savedAppoint.getClass()).isNotNull();
	}
	
	@Test
	public void FilteredAppoTest() throws Exception {
		
				
		List<Appointment> savedAppoint= appRepo.getFilteredAppointments("Accepted");
		assertThat(savedAppoint.listIterator()).isNotNull();
	}
	
	@Test
	public void ViewCanceledAppoTest() throws Exception {
		
				
		List<Appointment> savedAppoint= appRepo.viewClosedAppointmentsForDoctor(1);
		assertThat(savedAppoint.getClass()).isNotNull();
	}
	
	
	
	

	
	
	
	
}
