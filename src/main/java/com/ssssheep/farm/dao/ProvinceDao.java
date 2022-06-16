package com.ssssheep.farm.dao;

import com.ssssheep.farm.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 0:18 星期四
 */
@Repository
public interface ProvinceDao extends JpaRepository<Province,Long> {
}
