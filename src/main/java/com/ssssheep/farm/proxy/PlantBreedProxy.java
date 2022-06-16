package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.PlantBreed;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 15:04 星期四
 */
@Service
@RequiredArgsConstructor
public class PlantBreedProxy implements DataProxy<PlantBreed> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(PlantBreed plantBreed) {
        plantBreed.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(PlantBreed plantBreed) {
        plantBreed.setUpdatedAt(timeUtil.generateDate());
    }
}
