package com.ssssheep.farm.proxy;

import com.ssssheep.farm.entity.Questionnaire;
import com.ssssheep.farm.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/17 21:56 星期五
 */
@Service
@RequiredArgsConstructor
public class QuestionnaireProxy implements DataProxy<Questionnaire> {

    final TimeUtil timeUtil;

    @Override
    public void beforeAdd(Questionnaire questionnaire) {
        questionnaire.setCreatedAt(timeUtil.generateDate());
    }

    @Override
    public void beforeUpdate(Questionnaire questionnaire) {
        questionnaire.setUpdatedAt(timeUtil.generateDate());
    }
}
