package com.ssssheep.farm.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 0:48 星期四
 */
@Component
public class TimeUtil {

    public Date generateDate() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }
}
