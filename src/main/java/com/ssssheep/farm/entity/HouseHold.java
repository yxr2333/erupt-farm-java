package com.ssssheep.farm.entity;

import com.ssssheep.farm.proxy.HouseHoldProxy;
import lombok.*;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;
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
@Erupt(name = "户籍信息",dataProxy = HouseHoldProxy.class,power = @Power(export = true,importable = true))
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
                    title = "门牌号"
            ),
            edit = @Edit(
                    title = "门牌号",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String doorPlate;

    @EruptField(
            views = @View(
                    title = "户主",
                    column = "name"
            ),
            edit = @Edit(
                    title = "户主",
                    type = EditType.REFERENCE_TABLE, notNull = true,
                    referenceTableType = @ReferenceTableType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private IMember head;

    @EruptField(
            views = @View(
                    title = "家庭人口数", sortable = true
            ),
            edit = @Edit(
                    title = "家庭人口数",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer population;

    @EruptField(
            views = @View(
                    title = "入户公路状况"
            ),
            edit = @Edit(
                    title = "入户公路状况",
                    type = EditType.CHOICE, search = @Search, notNull = true,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "极差", label = "极差"),
                            @VL(value = "较差", label = "较差"),
                            @VL(value = "正常", label = "正常"),
                            @VL(value = "较好", label = "较好"),
                            @VL(value = "很好", label = "很好"),
                    })
            )
    )
    private String roadCondition;

    @EruptField(
            views = @View(
                    title = "耕地面积"
            ),
            edit = @Edit(
                    title = "耕地面积",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType(
                            suffix = {
                                    @VL(value = "平方米", label = "平方米"),
                                    @VL(value = "亩", label = "亩"),
                                    @VL(value = "平方千米", label = "平方千米"),
                                    @VL(value = "公顷", label = "公顷"),
                                    @VL(value = "公亩", label = "公亩"),
                            })
            )
    )
    private String field;

    @EruptField(
            views = @View(
                    title = "山地面积"
            ),
            edit = @Edit(
                    title = "山地面积",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType(
                            suffix = {
                                    @VL(value = "平方米", label = "平方米"),
                                    @VL(value = "亩", label = "亩"),
                                    @VL(value = "平方千米", label = "平方千米"),
                                    @VL(value = "公顷", label = "公顷"),
                                    @VL(value = "公亩", label = "公亩"),
                            })
            )
    )
    private String mountain;

    @EruptField(
            views = @View(
                    title = "林地面积"
            ),
            edit = @Edit(
                    title = "林地面积",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType(
                            suffix = {
                                    @VL(value = "平方米", label = "平方米"),
                                    @VL(value = "亩", label = "亩"),
                                    @VL(value = "平方千米", label = "平方千米"),
                                    @VL(value = "公顷", label = "公顷"),
                                    @VL(value = "公亩", label = "公亩"),
                            })
            )
    )
    private String forest;

    @EruptField(
            views = @View(
                    title = "堰塘面积"
            ),
            edit = @Edit(
                    title = "堰塘面积",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType(
                            suffix = {
                                    @VL(value = "平方米", label = "平方米"),
                                    @VL(value = "亩", label = "亩"),
                                    @VL(value = "平方千米", label = "平方千米"),
                                    @VL(value = "公顷", label = "公顷"),
                                    @VL(value = "公亩", label = "公亩"),
                            })
            )
    )
    private String pipeline;

    @EruptField(
            views = @View(
                    title = "创建时间"
            )
    )
    private Date createdAt;

    @EruptField(
            views = @View(
                    title = "更新时间"
            )
    )
    private Date updatedAt;

}
