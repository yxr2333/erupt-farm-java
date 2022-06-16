package com.ssssheep.farm.dao;

import com.ssssheep.farm.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 1:22 星期四
 */
@Repository
public interface CityDao extends JpaRepository<City,Long> {

    /**
     * 根据省份id判断城市是否存在
     * @param id 省份id
     * @return 城市是否存在
     */
    Boolean existsByProvinceId(Long id);
}
