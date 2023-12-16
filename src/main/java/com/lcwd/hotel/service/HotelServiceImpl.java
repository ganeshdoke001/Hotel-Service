package com.lcwd.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.exception.ResourceNotFoundException;
import com.lcwd.hotel.repo.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel save(Hotel hotel) {
		String id=UUID.randomUUID().toString();
		hotel.setId(id);
		return this.hotelRepo.save(hotel);
	}

	@Override
	public Hotel get(String id) {
		return this.hotelRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" Hotel with given id not found"+id));
	}

	@Override
	public List<Hotel> getAll() {
		return this.hotelRepo.findAll();
	}

}
