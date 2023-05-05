package com.lced.hotel.hotelservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lced.hotel.hotelservice.entity.Hotel;
import com.lced.hotel.hotelservice.service.IHotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private IHotelService hotelService;

	@PostMapping
	public ResponseEntity<?> createHotel(@RequestBody Hotel hotel) {
		System.err.println(">>>>>>>>>>>>>>>>>");
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
	}

	@GetMapping
	public ResponseEntity<?> getAllHotels() {
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<?> getAllHotels(@PathVariable String hotelId) {
		System.err.println("XXXXXXXXXXXXXXXXXXXXXXXXXXX");
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
	}

}
