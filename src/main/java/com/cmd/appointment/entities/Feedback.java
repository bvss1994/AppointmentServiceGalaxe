package com.cmd.appointment.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	private int ques1;
	private int ques2;
	private int ques3;
	private int ques4;
	private String additionalComment;
	
}
