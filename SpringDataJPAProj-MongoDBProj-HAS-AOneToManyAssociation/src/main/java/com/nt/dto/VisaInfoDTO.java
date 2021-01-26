package com.nt.dto;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisaInfoDTO {
	private Integer visaNo;
	private String country;
	private LocalDate expiryDate;
}
