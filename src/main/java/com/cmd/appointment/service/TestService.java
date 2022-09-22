package com.cmd.appointment.service;

import java.util.List;

import com.cmd.appointment.dtos.TestDto;
import com.cmd.appointment.entities.Test;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.TestAlreadyExistException;
import com.cmd.appointment.exception.TestNotFoundException;

public interface TestService {

	public Test saveTest(Test test) throws TestAlreadyExistException;

	public String removeTest(long id) throws TestNotFoundException;

	public List<TestDto> viewTestByAppId(long aid) throws AppointmentNotFoundException;

	public Test editTest(Test test);
}
