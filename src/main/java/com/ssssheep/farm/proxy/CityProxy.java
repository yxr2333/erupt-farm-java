package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.City;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 0:50 星期四
 */
@Service
@RequiredArgsConstructor
public class CityProxy implements DataProxy<City> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(City city) {
        city.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(City city) {
        city.setUpdatedAt(timeUtil.generateDate());
    }
}
