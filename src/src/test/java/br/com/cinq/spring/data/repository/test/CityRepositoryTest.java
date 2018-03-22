package br.com.cinq.spring.data.repository.test;


import br.com.cinq.spring.data.sample.application.Application;
import br.com.cinq.spring.data.sample.application.model.City;
import br.com.cinq.spring.data.sample.application.model.Country;
import br.com.cinq.spring.data.sample.application.repository.CityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Eye candy: implements a sample in using JpaRespositories
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
    classes = Application.class)

public class CityRepositoryTest {

    @Autowired
    private CityRepository repository;

    @Test
    public void testQueryPerson() {

        Assert.assertNotNull(repository);
        
        Assert.assertTrue(repository.count()>0);

        Country country = new Country();
        country.setId(1); // Should be France

        List<City> list = repository.findByCountry(country);

       Assert.assertEquals(4, list.size());
    }
}
