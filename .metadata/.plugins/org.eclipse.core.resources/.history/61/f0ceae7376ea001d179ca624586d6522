package com.lced.rating.ratingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lced.rating.ratingservice.entity.Rating;

@Repository
public interface IRatingRepository extends JpaRepository<Rating, String> {

	// custom findermethod
	List<Rating> findByUserId(String userId);

	List<Rating> findByHotelId(String hotelId);
}
