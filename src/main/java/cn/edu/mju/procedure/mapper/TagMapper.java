package cn.edu.mju.procedure.mapper;

import cn.edu.mju.procedure.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/9/22
 */

public interface TagMapper{


    /**
     * 查询所有的标签
     * @return
     */
    List<Tag> selectAll();

    /**
     * 插入一个标签
     * @param tag
     * @return
     */
    int insert(@Param("tag")Tag tag);

    /**
     * 根据查询条件查询标签
     * @param tag
     * @return
     */
    Tag select(@Param("tag")Tag tag);

    /**
     * 更新
     * @param tag
     * @return
     */
    int update(@Param("tag")Tag tag);
}
