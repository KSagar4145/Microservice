package com.lced.rating.ratingservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	@Min(0)
	@Max(10)
	private int rating;
	private String feedback;

}
