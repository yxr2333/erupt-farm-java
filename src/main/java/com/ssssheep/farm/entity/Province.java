package com.ssssheep.farm.entity;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/15 23:52 星期三
 */
import javax.persistence.*;

import com.ssssheep.farm.proxy.ProvinceProxy;
import lombok.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import java.util.Date;

@Erupt(name = "省份",dataProxy = ProvinceProxy.class)
@Table(name = "t_provinces")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Province extends BaseModel {

    @EruptField(
            views = @View(
                    title = "名称"
            ),
            edit = @Edit(
                    title = "名称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

    @EruptField(
            views = @View(
                    title = "创建时间", sortable = true
            )
//            edit = @Edit(
//                    title = "创建时间",
//                    type = EditType.DATE, search = @Search, notNull = true,
//                    dateType = @DateType(type = DateType.Type.DATE_TIME)
//            )
    )
    private Date created_at;

    @EruptField(
            views = @View(
                    title = "更新时间", sortable = true
            )
//            edit = @Edit(
//                    title = "更新时间",
//                    type = EditType.DATE, search = @Search, notNull = true,
//                    dateType = @DateType(type = DateType.Type.DATE_TIME)
//            )
    )
    private Date updated_at;

}