package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.HouseHold;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 14:22 星期四
 */
@Service
@RequiredArgsConstructor
public class HouseHoldProxy implements DataProxy<HouseHold> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(HouseHold houseHold) {
        houseHold.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(HouseHold houseHold) {
        houseHold.setUpdatedAt(timeUtil.generateDate());
    }
}
