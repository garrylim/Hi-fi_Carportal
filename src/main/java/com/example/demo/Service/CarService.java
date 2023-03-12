package com.example.demo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Car;
import com.example.demo.Repository.CarRepository;

@Service
@Transactional
public class CarService {
  

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    
    //used for both update and Save Car
    public void saveCar(Car car) {
       carRepository.save(car);
    }
    
	public Car get(Long id) {
		return carRepository.findById(id).get();
	}

	
	public void delete(Long id) {
		carRepository.deleteById(id);
	}
	
	public List<Car> search(String keyword) {
		return carRepository.search(keyword);
		
		}

}