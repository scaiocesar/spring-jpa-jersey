package br.com.cinq.spring.data.sample.application.controler;

import br.com.cinq.spring.data.sample.application.model.City;
import br.com.cinq.spring.data.sample.application.model.Country;
import br.com.cinq.spring.data.sample.application.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by caio on 21/03/18.
 */
@RestController
public class CityControler {

    @Autowired
    private CityRepository repository;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return new ResponseEntity("Its working", HttpStatus.OK);
    }

    /*
    @RequestMapping(value = "/rest/cities", method = RequestMethod.GET)
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = repository.findAll();
        return new ResponseEntity(cities, HttpStatus.OK);
    }
    */

    @RequestMapping(value = "/rest/cities", method = RequestMethod.GET )
    public ResponseEntity<List<City>> getCityByCountry(@RequestParam String country) {
        Country c = new Country();
        c.setName(country);
        List<City> cities = repository.findByCountryNameContainingIgnoreCase(country);
        return new ResponseEntity(cities, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/cities", method = RequestMethod.POST )
    public ResponseEntity<City> add(@RequestBody City city) {
        City cityResponse = repository.save(city);
        return new ResponseEntity(cityResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/rest/cities/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<City> update(@PathVariable Integer id) {
        City city = new City();
        city.setId(id);
        repository.delete(city);
        return new ResponseEntity(city, HttpStatus.OK);
    }


}
