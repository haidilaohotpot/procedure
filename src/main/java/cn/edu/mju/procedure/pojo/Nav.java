package cn.edu.mju.procedure.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author yfl
 * 2019-9-22
 */
@Data
public class Nav implements Serializable {
    private static final long serialVersionUID = 961235512220891746L;
    /**
     * 导航栏ID
     */
    private Integer navId;
    /**
     * 导航栏名字
     */
    private String navName;
    /**
     * 导航栏链接
     */
    private String navLink;
    /**
     * 导航栏权重
     */
    private Integer navPriority;
    
}
