package com.cmd.appointment.service;

import java.util.List;

import com.cmd.appointment.dtos.PrescriptionDto;
import com.cmd.appointment.entities.Prescription;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.PrescriptionAlreadyExistException;
import com.cmd.appointment.exception.PrescriptionNotFoundException;

public interface PrescriptionService {

	public Prescription savePrescription(Prescription prescription) throws PrescriptionAlreadyExistException;

	public List<PrescriptionDto> viewPrescriptionsByAppId(long aid) throws AppointmentNotFoundException;

	public Prescription editPrescription(Prescription prescription) throws PrescriptionNotFoundException;

	public String deletePrescription(long id) throws PrescriptionNotFoundException;
	
}
