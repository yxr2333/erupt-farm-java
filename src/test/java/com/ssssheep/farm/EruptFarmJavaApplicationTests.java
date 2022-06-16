package com.ssssheep.farm;

import com.ssssheep.farm.dao.CityDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EruptFarmJavaApplicationTests {

    @Autowired
    private CityDao cityDao;

    @Test
    void contextLoads() {
        System.out.println(cityDao.existsByProvinceId(10L));
    }

}
