package com.cmd.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cmd.appointment.entities.Vital;

public interface VitalRepository extends JpaRepository<Vital, Long>{

	@Query(value="SELECT * \r\n" + 
			"FROM vital\r\n" + 
			"where appointment_id =:appointment_id",nativeQuery = true)
	public Vital getVitalsByAppId(@Param (value = "appointment_id") long appointment_id);
}
