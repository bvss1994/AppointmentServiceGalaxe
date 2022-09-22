package com.cmd.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cmd.appointment.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

	@Query(value="SELECT * FROM comment",nativeQuery = true)
	public List<Comment> getAllComment();
	
	@Query(value="SELECT * FROM comment where appointment_id=:appointment_id",nativeQuery = true)
	public Comment getCommentByAppId(@Param (value = "appointment_id") long appointment_id);
}
