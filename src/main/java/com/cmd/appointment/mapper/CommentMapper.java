package com.cmd.appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cmd.appointment.dtos.CommentDto;
import com.cmd.appointment.entities.Comment;

@Mapper
public interface CommentMapper {

	@Mapping(source = "commentDesc", target = "commentDesc")
	public CommentDto convertToDto(Comment comment);
}
