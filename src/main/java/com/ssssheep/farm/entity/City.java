package com.ssssheep.farm.entity;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 0:35 星期四
 */
import javax.persistence.*;

import com.ssssheep.farm.proxy.CityProxy;
import lombok.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.jpa.model.BaseModel;

import java.util.Date;

@Erupt(
        name = "城市",
        dataProxy = CityProxy.class
)
@Table(name = "t_cities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class City extends BaseModel {

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
                    title = "所属省份",
                    column = "name"
            ),
            edit = @Edit(
                    title = "所属省份",
                    type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private Province province;

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
    private Date createdAt;

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
    private Date updatedAt;

}