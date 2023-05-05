package com.lced.hotel.hotelservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

	@Id
	private String hotelId;
	private String hotelName;
	private String hotelLocation;
	private String hotelAbout;
}
