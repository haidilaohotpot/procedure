package cn.edu.mju.procedure.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/22
 */
@Data
public class Tag {

    private Integer tagId;

    private String tagName;

    /**
     * 父标签的id
     */
    private Integer tagParent;

    /**
     * 标签状态
     * 1.可用 2.不可用
     */
    private Integer state;


    private List<Tag> children = new ArrayList<>();

}
