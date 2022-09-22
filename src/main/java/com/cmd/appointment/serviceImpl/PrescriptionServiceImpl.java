package com.cmd.appointment.serviceImpl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmd.appointment.dtos.PrescriptionDto;
import com.cmd.appointment.entities.Prescription;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.PrescriptionAlreadyExistException;
import com.cmd.appointment.exception.PrescriptionNotFoundException;
import com.cmd.appointment.mapper.PrescriptionMapper;
import com.cmd.appointment.repository.AppointmentRepository;
import com.cmd.appointment.repository.PrescriptionRepository;
import com.cmd.appointment.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	private PrescriptionRepository prerepo;

	@Autowired
	private AppointmentRepository appRepo;
	
	@Autowired
	private PrescriptionMapper prescriptionMapper;

	public PrescriptionServiceImpl(PrescriptionRepository preRepository) {
		// TODO Auto-generated constructor stub
		this.prerepo = preRepository;
	}

	@Override
	public Prescription savePrescription(Prescription prescription) throws PrescriptionAlreadyExistException {
		// TODO Auto-generated method stub
		Prescription prescription1 = null;
		if (prerepo.existsById(prescription.getPrescriptionId())) {
			throw new PrescriptionAlreadyExistException("Prescription already exists. Please add new one..");
		} else {
			prescription1 = prerepo.save(prescription);
		}

		return prescription1;
	}

	@Override
	public List<PrescriptionDto> viewPrescriptionsByAppId(long aid) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		if (appRepo.existsById(aid)) {
			List<Prescription> prescriptions = prerepo.getPrescriptionsByAppId(aid);
			PrescriptionDto prescriptionDto = new PrescriptionDto();
			List<PrescriptionDto> prescriptionDtos = new ArrayList<PrescriptionDto>();
			for(Prescription prescription : prescriptions) {
				prescriptionDto = prescriptionMapper.convertToDto(prescription);
				prescriptionDtos.add(prescriptionDto);
			}
			return prescriptionDtos;
		} else {
			throw new AppointmentNotFoundException("Appointment not found");
		}
		
	}

	@Override
	public Prescription editPrescription(Prescription prescription) throws PrescriptionNotFoundException {
		// TODO Auto-generated method stub
		Prescription prescription1 = null;
		if (appRepo.existsById(prescription.getPrescriptionId())) {
			prescription1 = prerepo.findById(prescription.getPrescriptionId()).get();
			prescription1.setPrescriptionDetail(prescription.getPrescriptionDetail());
			prescription1.setMedicineTime(prescription.getMedicineTime());
			prescription1.setMedicineName(prescription.getMedicineName());
			prescription1.setMedicineDuration(prescription.getMedicineDuration());
			prescription1.setMedicineCycle(prescription.getMedicineCycle());
		} else {
			throw new PrescriptionNotFoundException("Prescription not found");
		}
		return prescription1;
	}

	@Override
	public String deletePrescription(long id) throws PrescriptionNotFoundException {
		// TODO Auto-generated method stub
		if (appRepo.existsById(id)) {
			prerepo.deleteById(id);
		} else {
			throw new PrescriptionNotFoundException("Prescription not found");
		}
		return "Deleted";
	}
}
