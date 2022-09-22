package com.cmd.appointment.service;

import com.cmd.appointment.dtos.VitalDto;
import com.cmd.appointment.entities.Vital;
import com.cmd.appointment.exception.AppointmentNotFoundException;
import com.cmd.appointment.exception.VitalAlreadyExistException;
import com.cmd.appointment.exception.VitalNotFoundException;

public interface VitalService {

	public VitalDto viewVitalByAppId(long aid) throws AppointmentNotFoundException;

	public Vital addvital(Vital vital) throws VitalAlreadyExistException;

	public Vital editvitals(Vital vital) throws VitalNotFoundException;

	public String DeleteVital(long id) throws VitalNotFoundException;

}
