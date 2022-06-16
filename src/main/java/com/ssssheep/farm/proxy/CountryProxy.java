package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.Country;
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
public class CountryProxy implements DataProxy<Country> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(Country country) {
        country.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(Country country) {
        country.setUpdatedAt(timeUtil.generateDate());
    }
}
