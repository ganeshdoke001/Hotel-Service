package com.lcwd.hotel.service;

import java.util.List;

import com.lcwd.hotel.entity.Hotel;

public interface HotelService {

	Hotel save(Hotel hotel);
	Hotel get(String id);
	List<Hotel> getAll();
}
