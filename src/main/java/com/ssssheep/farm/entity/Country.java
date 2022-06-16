package com.ssssheep.farm.entity;

import com.ssssheep.farm.proxy.CountryProxy;
import lombok.*;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 0:57 星期四
 */
@Erupt(name = "县",dataProxy = CountryProxy.class)
@Table(name = "t_country")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Country extends BaseModel {

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
                    title = "所属城市",
                    column = "name"
            ),
            edit = @Edit(
                    title = "所属城市",
                    type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private City city;

    @EruptField(
            views = @View(
                    title = "创建时间", sortable = true
            )
//            ,
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
//            ,
//            edit = @Edit(
//                    title = "更新时间",
//                    type = EditType.DATE, search = @Search, notNull = true,
//                    dateType = @DateType(type = DateType.Type.DATE_TIME)
//            )
    )
    private Date updatedAt;
}