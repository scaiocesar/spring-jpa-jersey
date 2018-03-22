package br.com.cinq.spring.data.sample.application.repository;

import br.com.cinq.spring.data.sample.application.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by caio on 21/03/18.
 */
public interface CountryRepository extends JpaRepository<Country, Integer> {

    List<Country> findByNameContainingIgnoreCase(String name);

}
