package com.cmd.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cmd.appointment.entities.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

	@Query(value = "SELECT * FROM test t join appointment a on a.appointment_id= t.appointment_id where a.appointment_id = :appointment_id", nativeQuery = true)
	public List<Test> getTestsByAppId(@Param(value = "appointment_id") long appointment_id);
}
