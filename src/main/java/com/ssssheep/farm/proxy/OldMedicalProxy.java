package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.OldMedical;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/17 21:42 星期五
 */
@Service
@RequiredArgsConstructor
public class OldMedicalProxy implements DataProxy<OldMedical> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(OldMedical oldMedical) {
        oldMedical.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(OldMedical oldMedical) {
        oldMedical.setUpdatedAt(timeUtil.generateDate());
    }
}
