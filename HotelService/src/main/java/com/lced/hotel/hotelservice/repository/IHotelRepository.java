package com.lced.hotel.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lced.hotel.hotelservice.entity.Hotel;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, String> {

}
