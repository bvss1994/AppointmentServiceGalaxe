package com.cmd.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cmd.appointment.entities.Recommendation;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {

	@Query(value = "SELECT * FROM recommendation where appointment_id= :appointment_id", nativeQuery = true)
	public Recommendation getReccomendationByAppId(@Param(value = "appointment_id") long appointment_id);

}
