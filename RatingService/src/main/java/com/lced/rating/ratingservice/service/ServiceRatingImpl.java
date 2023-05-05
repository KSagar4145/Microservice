package com.lced.rating.ratingservice.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lced.rating.ratingservice.entity.Rating;
import com.lced.rating.ratingservice.repository.IRatingRepository;

@Service
@Transactional
public class ServiceRatingImpl implements IRatingService {

	@Autowired
	private IRatingRepository ratingRepository;

	@Override
	public Rating createRaing(Rating rating) {
		rating.setRatingId(UUID.randomUUID().toString());
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
