package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.Health;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/17 21:25 星期五
 */
@Service
@RequiredArgsConstructor
public class HealthProxy implements DataProxy<Health> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(Health health) {
        health.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(Health health) {
        health.setUpdatedAt(timeUtil.generateDate());
    }
}
