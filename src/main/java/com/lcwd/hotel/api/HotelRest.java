package com.lcwd.hotel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelRest {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Hotel>  create(@RequestBody Hotel hotel) {
		Hotel hotel2=this.hotelService.save(hotel);
		return new ResponseEntity<Hotel>(hotel2,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Hotel> getHotel(@PathVariable ("id") String id){
		Hotel hotel=this.hotelService.get(id);
		return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotels=this.hotelService.getAll();
		return new ResponseEntity<List<Hotel>>(hotels,HttpStatus.OK);
	}
}
