package com.ssssheep.farm.entity;

import javax.persistence.*;

import com.ssssheep.farm.proxy.EducationProxy;
import lombok.*;
import xyz.erupt.annotation.*;
import xyz.erupt.annotation.sub_erupt.*;
import xyz.erupt.annotation.sub_field.*;
import xyz.erupt.annotation.sub_field.sub_edit.*;
import xyz.erupt.upms.model.base.HyperModel;
import xyz.erupt.jpa.model.BaseModel;
import java.util.Set;
import java.util.Date;

/**
 * Created By Intellij IDEA
 *
 * @author Xinrui Yu
 * @version 1.0
 * @date 2022/6/16 16:02 星期四
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Erupt(name = "教育信息",dataProxy = EducationProxy.class)
@Table(name = "t_educations")
@Entity
public class Education extends BaseModel {

    @EruptField(
            views = @View(
                    title = "是否是学生"
            ),
            edit = @Edit(
                    title = "是否是学生",
                    boolType = @BoolType(trueText = "是", falseText = "否"),
                    search = @Search, notNull = true
            )
    )
    private Boolean isStudent;

    @EruptField(
            views = @View(
                    title = "是否为适龄儿童"
            ),
            edit = @Edit(
                    title = "是否为适龄儿童",
                    boolType = @BoolType(trueText = "是", falseText = "否"),
                    search = @Search, notNull = true
            )
    )
    private Boolean isChild;

    @EruptField(
            views = @View(
                    title = "是否完成义务教育"
            ),
            edit = @Edit(
                    title = "是否完成义务教育",
                    boolType = @BoolType(trueText = "是", falseText = "否"),
                    search = @Search, notNull = true
            )
    )
    private Boolean isDutyEdu;

    @EruptField(
            views = @View(
                    title = "是否辍学"
            ),
            edit = @Edit(
                    title = "是否辍学",
                    boolType = @BoolType(trueText = "是", falseText = "否"),
                    search = @Search, notNull = true
            )
    )
    private Boolean isDropout;

    @EruptField(
            views = @View(
                    title = "人员",
                    column = "name"
            ),
            edit = @Edit(
                    title = "人员",
                    type = EditType.REFERENCE_TREE, search = @Search, notNull = true,
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name")
            )
    )
    @ManyToOne
    private IMember member;

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
