package com.cmd.appointment.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmd.appointment.dtos.TestDto;
import com.cmd.appointment.entities.Test;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.TestAlreadyExistException;
import com.cmd.appointment.exception.TestNotFoundException;
import com.cmd.appointment.mapper.TestMapper;
import com.cmd.appointment.repository.AppointmentRepository;
import com.cmd.appointment.repository.TestRepository;
import com.cmd.appointment.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRepo;

	@Autowired
	private AppointmentRepository appRepo;

	@Autowired
	private TestMapper testMapper;

	public TestServiceImpl(TestRepository trepo) {
		// TODO Auto-generated constructor stub
		this.testRepo = trepo;
	}

	@Override
	public Test saveTest(Test test) throws TestAlreadyExistException {
		// TODO Auto-generated method stub
		if (testRepo.existsById(test.getTestId())) {
			throw new TestAlreadyExistException("Test already exists. Please add new one..");
		} else {
			testRepo.save(test);
		}
		return test;
	}

	@Override
	public List<TestDto> viewTestByAppId(long aid) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		if (appRepo.existsById(aid)) {
			List<Test> tests = testRepo.getTestsByAppId(aid);
			TestDto testDto = new TestDto();
			List<TestDto> testDtos = new ArrayList<TestDto>();
			for (Test test : tests) {
				testDto = testMapper.convertToDto(test);
				testDtos.add(testDto);
			}
			return testDtos;
		} else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}

	@Override
	public String removeTest(long id) throws TestNotFoundException {
		// TODO Auto-generated method stub
		if (testRepo.existsById(id)) {
			testRepo.deleteById(id);
		} else {
			throw new TestNotFoundException("Test not found");
		}
		return "Deleted";
	}

	@Override
	public Test editTest(Test test) {

		Test test1 = null;
		if (testRepo.existsById(test.getTestId())) {
			test1 = testRepo.findById(test.getTestId()).get();
			test1.setTestName(test.getTestName());
			test1.setAppointment(test.getAppointment());
			testRepo.save(test1);
		}
		return test1;
	}
}
