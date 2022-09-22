package com.cmd.appointment.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmd.appointment.entities.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	@Query(value = "select a from Appointment a")
	public List<Appointment> getAllAppointments();
	
	@Query(value = "select * from appointment where doctor_id=:doctorId",nativeQuery = true)
	public List<Appointment> viewAllAppointmentsForDoctor(@Param (value = "doctorId") long doctorId);
	
	@Query(value = "select a from Appointment a where a.status='Accepted' ")
	public List<Appointment> getAllAcceptedAppointments();
	
	@Query(value = "select a from Appointment a where a.status='Cancelled' ")
	public List<Appointment> getCancelledAppointments();
	
	@Query(value = "from Appointment a where a.status = :status")
	public List<Appointment> getFilteredAppointments(@Param (value = "status") String status);
	 
	@Query(value = "select * from appointment where status = 'Pending' and doctor_id=:doctorId",nativeQuery = true)
	public List<Appointment> viewPendingAppointments(@Param (value = "doctorId") long doctorId);
	
	@Query(value = "select * from appointment where status = 'Cancelled' and doctor_id=:doctorId",nativeQuery = true)
	public List<Appointment> viewCancelledAppointmentsForDoctor(@Param (value = "doctorId") long doctorId);
	
	@Query(value = "select * from appointment where status = 'Closed' and doctor_id=:doctorId",nativeQuery = true)
	public List<Appointment> viewClosedAppointmentsForDoctor(@Param (value = "doctorId") long doctorId);
	
	@Query(value = "select * from appointment where status = 'Accepted' and doctor_id=:doctorId",nativeQuery = true)
	public List<Appointment> viewAccptedAppointmentsForDoctor(@Param (value = "doctorId") long doctorId);
	
	@Query(value = "select * from appointment where appointment_date_time =:date and  doctor_id=:doctorId",nativeQuery = true)
	public List<Appointment> viewAppointmentsForDayForDoctor(@Param(value = "date")String date, @Param (value = "doctorId")long doctorId);
}