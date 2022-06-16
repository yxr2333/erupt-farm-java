package com.ssssheep.farm.entity;

import lombok.*;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.DateType;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.security.acl.Group;
import java.util.Date;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 14:22 星期四
 */
@Erupt(name = "户籍信息")
@Table(name = "t_house_holds")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class HouseHold extends BaseModel {

    @EruptField(
            views = @View(
                    title = "户名称"
            ),
            edit = @Edit(
                    title = "户名称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;

    @EruptField(
            views = @View(
                    title = "所属组",
                    column = "name"
            ),
            edit = @Edit(
                    title = "所属组",
                    type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private IGroup group;

    @EruptField(
            views = @View(
                    title = "创建时间", sortable = true
            )
    )
    private Date createdAt;

    @EruptField(
            views = @View(
                    title = "更新时间", sortable = true
            )
    )
    private Date updatedAt;

}
