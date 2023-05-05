package com.lced.user.service.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lced.user.service.entities.Hotel;
import com.lced.user.service.entities.Rating;
import com.lced.user.service.entities.User;
import com.lced.user.service.exceptiondefined.ResourceNotFoundException;
import com.lced.user.service.externalservices.HotelService;
import com.lced.user.service.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private HotelService hotelService;

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User with given id not found on server!!!!!! " + userId));

		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(),
				Rating[].class);
		logger.info("{}", ratingsOfUser);

		List<Rating> ratings = Arrays.stream(ratingsOfUser).collect(Collectors.toList());

		List<Rating> ratingList = ratings.stream().map(rating -> {
//			ResponseEntity<Hotel> forEntity = restTemplate
//					.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//			Hotel hotel = forEntity.getBody();
			
			Hotel hotel=hotelService.getHotel(rating.getHotelId());
//			logger.info("response status code: {}", forEntity.getStatusCode());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);

		return user;
	}

}
