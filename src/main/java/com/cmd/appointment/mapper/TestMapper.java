package com.cmd.appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cmd.appointment.dtos.TestDto;
import com.cmd.appointment.entities.Test;

@Mapper
public interface TestMapper {

	@Mapping(source = "testName", target = "testName")
	public TestDto convertToDto(Test test);
}
