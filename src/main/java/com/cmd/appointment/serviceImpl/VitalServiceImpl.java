package com.cmd.appointment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cmd.appointment.dtos.VitalDto;
import com.cmd.appointment.entities.Vital;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.VitalAlreadyExistException;
import com.cmd.appointment.exception.VitalNotFoundException;
import com.cmd.appointment.mapper.VitalMapper;
import com.cmd.appointment.repository.AppointmentRepository;
import com.cmd.appointment.repository.VitalRepository;
import com.cmd.appointment.service.VitalService;

@Service
public class VitalServiceImpl implements VitalService {

	@Autowired
	private VitalRepository vrepo;

	@Autowired
	private AppointmentRepository appRepo;

	@Autowired
	private VitalMapper vitalMapper;

	public VitalServiceImpl(VitalRepository vrepo) {
		// TODO Auto-generated constructor stub
		this.vrepo = vrepo;
	}

	@Override
	public Vital addvital(Vital vital) throws VitalAlreadyExistException {
		// TODO Auto-generated method stub
		long appId = vital.getAppointment().getAppointmentId();
		if (vrepo.getVitalsByAppId(appId) != null) {
			throw new VitalAlreadyExistException("Vital already exists");
		} else {
			vrepo.save(vital);
			return vital;
		}	
	}

	@Override
	public VitalDto viewVitalByAppId(long aid) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		if (appRepo.existsById(aid)) {
			Vital vital = vrepo.getVitalsByAppId(aid);
			VitalDto vitalDto = new VitalDto();
			vitalDto = vitalMapper.convertToDto(vital);
			return vitalDto;
		} else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
	}

	@Override
	public Vital editvitals(Vital vital) throws VitalNotFoundException {
		Vital vital1 = null;
		if (vrepo.existsById(vital.getVitalId())) {
			vital1 = vrepo.findById(vital.getVitalId()).get();
			vital1.setDiabetes(vital.getDiabetes());
			vital1.setECG(vital.getECG());
			vital1.setRespirationRate(vital.getRespirationRate());
			vital1.setTemperature(vital.getTemperature());
			vrepo.save(vital1);
		} else {
			throw new VitalNotFoundException("Vital not found");
		}
		return vital1;
	}

	@Override
	public String DeleteVital(long id) throws VitalNotFoundException {
		if (vrepo.existsById(id)) {
			vrepo.deleteById(id);
		} else {
			throw new VitalNotFoundException("Vital not found");
		}
		return "Deleted";
	}

}
