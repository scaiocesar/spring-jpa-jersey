package br.com.cinq.spring.data.sample.application.repository;

import br.com.cinq.spring.data.sample.application.model.City;
import br.com.cinq.spring.data.sample.application.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by caio on 21/03/18.
 */
public interface CityRepository extends JpaRepository<City,Integer> {

    List<City> findByCountryNameContainingIgnoreCase(String country);

    List<City> findByCountry(Country country);
}
