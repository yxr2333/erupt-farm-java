package com.ssssheep.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import xyz.erupt.core.annotation.EruptScan;

/**
 * @author yxr
 */
@SpringBootApplication
@EntityScan
@EruptScan
public class EruptFarmJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EruptFarmJavaApplication.class, args);
    }

}
