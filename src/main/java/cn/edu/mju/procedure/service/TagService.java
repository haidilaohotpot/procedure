package cn.edu.mju.procedure.service;

import cn.edu.mju.procedure.dto.TagDTO;
import cn.edu.mju.procedure.entity.Tag;
import cn.edu.mju.procedure.exception.TagOperationException;

import javax.swing.text.html.HTML;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/9/22
 */
public interface TagService {

    /**
     * 查询所有标签
     * @return
     */
    TagDTO list();

    /**
     * 增加标签
     * @param tag
     * @return
     */
    TagDTO add(Tag tag) throws TagOperationException;


    /**
     * 移除标签
     * @param tag
     * @return
     */
    TagDTO removeById(Tag tag) throws TagOperationException;


    /**
     * 修改标签
     * @param tag
     * @return
     */
    TagDTO update(Tag tag) throws TagOperationException;


    /**
     * 通过标签名称查询
     * @param tag
     * @return
     */
    TagDTO getByTagName(Tag tag);


    /**
     * 通过标签ID查询
     * @param tag
     * @return
     */
    TagDTO getByTagId(Tag tag);


}
