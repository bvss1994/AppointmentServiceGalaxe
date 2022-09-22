package com.cmd.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cmd.appointment.entities.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

	@Query(value = "SELECT * FROM prescription where appointment_id=:appointment_id", nativeQuery = true)
	public List<Prescription> getPrescriptionsByAppId(@Param(value = "appointment_id") long appointment_id);
}
