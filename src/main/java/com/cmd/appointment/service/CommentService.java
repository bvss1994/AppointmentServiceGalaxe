package com.cmd.appointment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cmd.appointment.dtos.CommentDto;
import com.cmd.appointment.entities.Comment;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.CommentAlreadyExistException;
import com.cmd.appointment.exception.CommentNotFoundException;

@Service
public interface CommentService {

//	public Comment addCommentToAppointment(Comment comment, long appId);
	public List<Comment> getAllComments() throws CommentNotFoundException;
	
	public Comment editComment(Comment comment) throws CommentNotFoundException;

	public Comment addComment(Comment comment) throws CommentAlreadyExistException;
	
	public CommentDto viewCommentByAppId(long aid) throws AppointmentNotFoundException;	
}
