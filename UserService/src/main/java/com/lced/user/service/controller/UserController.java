package com.lced.user.service.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lced.user.service.entities.User;
import com.lced.user.service.service.IUserService;
import com.lced.user.service.service.UserServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserService userService;

	private Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	int retryCount = 1;

	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
//	@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallBack")
//	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<?> getSingleUser(@PathVariable String userId) {
		logger.info("Get Single User Handler: UserController");
//		logger.info("Retry count : {}", retryCount);
//		retryCount++;
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(userId));
	}

	// creating callBack method for circuitbreaker method

	public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex) {
		logger.info("FallBack is executed because service is down : ", ex.getMessage());
		User user = User.builder().email("dummy@gmail.com").name("Dummy")
				.about("This user is commited because some services from server are down").userId("14123").build();
		return ResponseEntity.status(HttpStatus.OK).body(user);

	}

	@GetMapping
	public ResponseEntity<?> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
	}

}
