package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Entity.Car;
import com.example.demo.Entity.CarBidding;
import com.example.demo.Repository.BidRepository;


@Service
@Transactional
public class BidService {

	@Autowired
    private BidRepository bidRepository;

	public CarBidding save(CarBidding carBiding) {		
        return bidRepository.save(carBiding);	
	}

	public List<CarBidding> listAll() {
		return (List<CarBidding>) bidRepository.findAll();
	}

	public List<CarBidding> listBidInfo(Car car) {
		return (List<CarBidding>) bidRepository.findByCarid(car);
	}

}