package com.school.BOC.service;

import com.school.BOC.model.City;
import com.school.BOC.model.Student;
import com.school.BOC.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("cityService")
public class CityServiceImpl implements CityService{
    @Autowired
    CityRepository cityRepository;

    @Override
    public Optional<City> get(long cityId) {
        return cityRepository.findById(cityId);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> create(String nameCity, Student cityOwner) {

        Optional<City> cityExistWithOwnerId = getByOwnerId(cityOwner.getId());

        if (cityExistWithOwnerId.isPresent()){
            cityExistWithOwnerId.get().setNameCity(nameCity);

            return Optional.of(cityRepository.save(cityExistWithOwnerId.get()));
        }

        City city = new City();
        city.setNameCity(nameCity);
        city.setStudent(cityOwner);

        return Optional.of(cityRepository.save(city));
    }

    @Override
    public Optional<City> getByOwnerId(long cityOwnerId) {
        return cityRepository.findByStudentId(cityOwnerId);
    }
}
