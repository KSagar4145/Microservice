package com.lced.hotel.hotelservice.service;

import java.util.List;

import com.lced.hotel.hotelservice.entity.Hotel;

public interface IHotelService {

	public Hotel createHotel(Hotel hotel);

	public List<Hotel> getAllHotels();

	public Hotel getHotelById(String hotelId);
}
