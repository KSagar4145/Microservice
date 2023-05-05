package com.lced.rating.ratingservice.service;

import java.util.List;

import com.lced.rating.ratingservice.entity.Rating;

public interface IRatingService {

	public Rating createRaing(Rating rating);

	public List<Rating> getAllRatings();

	public List<Rating> getRatingByUserId(String userId);

	public List<Rating> getRatingByHotelId(String hotelId);
}
