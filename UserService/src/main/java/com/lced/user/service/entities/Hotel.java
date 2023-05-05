package com.lced.user.service.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hotel {
	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private String hotelAbout;
}
