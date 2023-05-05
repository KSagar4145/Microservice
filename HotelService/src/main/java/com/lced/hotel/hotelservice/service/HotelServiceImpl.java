package com.lced.hotel.hotelservice.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.lced.hotel.hotelservice.entity.Hotel;
import com.lced.hotel.hotelservice.exceptionHandler.ResourceNotFoundException;
import com.lced.hotel.hotelservice.repository.IHotelRepository;

@Service
@Transactional
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String randomHotelId = UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel of given Id " + hotelId + " not found"));
	}

}
