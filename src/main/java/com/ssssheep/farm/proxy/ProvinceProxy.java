package com.ssssheep.farm.proxy;

import com.ssssheep.farm.dao.CityDao;
import com.ssssheep.farm.entity.Province;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.core.exception.EruptApiErrorTip;
import xyz.erupt.core.view.EruptApiModel;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 0:10 星期四
 */
@Service
@RequiredArgsConstructor
public class ProvinceProxy implements DataProxy<Province> {
    final TimeUtil timeUtil;
    final CityDao cityDao;

    @Override
    public void beforeAdd(Province province) {
        province.setCreated_at(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(Province province) {
        province.setUpdated_at(timeUtil.generateDate());
    }

    @Override
    public void beforeDelete(Province province) {
        if(cityDao.existsByProvinceId(province.getId())){
            throw new EruptApiErrorTip("该省份下存在城市，不能删除", EruptApiModel.PromptWay.MESSAGE);
        }
    }
}
