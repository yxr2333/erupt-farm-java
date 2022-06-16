package com.ssssheep.farm.entity;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 14:38 星期四
 */
import javax.persistence.*;

import com.ssssheep.farm.proxy.GuaranteesProxy;
import lombok.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Set;
import java.util.Date;

@Erupt(name = "两不愁三保障", dataProxy = GuaranteesProxy.class)
@Table(name = "t_guarantees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Guarantees extends BaseModel {

    @EruptField(
            views = @View(
                    title = "安全住房是否有保障？"
            ),
            edit = @Edit(
                    title = "安全住房是否有保障？",
                    boolType = @BoolType(trueText = "有",falseText = "无"), search = @Search, notNull = true
            )
    )
    private Boolean isSaveHouse;

    @EruptField(
            views = @View(
                    title = "安全住房有何问题"
            ),
            edit = @Edit(
                    showBy = @ShowBy(
                            dependField = "isSaveHouse",
                            expr = "value === false"
                    ),
                    title = "安全住房有何问题",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String safeHouseDesc;

    @EruptField(
            views = @View(
                    title = "安全饮水是否保障"
            ),
            edit = @Edit(
                    title = "安全饮水是否保障",
                    boolType = @BoolType(trueText = "有",falseText = "无"), search = @Search, notNull = true
            )
    )
    private Boolean isSafeDrink;

    @EruptField(
            views = @View(
                    title = "安全饮水有何问题"
            ),
            edit = @Edit(
                    showBy = @ShowBy(
                            dependField = "isSafeDrink",
                            expr = "value === false"
                    ),
                    title = "安全饮水有何问题",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String safeDrinkDesc;

    @EruptField(
            views = @View(
                    title = "家庭中有几个学生"
            ),
            edit = @Edit(
                    title = "家庭中有几个学生",
                    type = EditType.NUMBER, search = @Search, notNull = true,
                    numberType = @NumberType
            )
    )
    private Integer studentCount;

    @EruptField(
            views = @View(
                    title = "基础教育是否有保障"
            ),
            edit = @Edit(
                    title = "基础教育是否有保障",
                    boolType = @BoolType(trueText = "有",falseText = "无"), search = @Search, notNull = true
            )
    )
    private Boolean isBasicEdu;

    @EruptField(
            views = @View(
                    title = "基本教育有何问题"
            ),
            edit = @Edit(
                    title = "基本教育有何问题",
                    showBy = @ShowBy(
                            dependField = "isBasicEdu",
                            expr = "value === false"
                    ),
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String basicEduDesc;

    @EruptField(
            views = @View(
                    title = "户籍信息",
                    column = "name"
            ),
            edit = @Edit(
                    title = "户籍信息",
                    type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private HouseHold houseHold;

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
