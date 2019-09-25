package cn.edu.mju.procedure.mapper;

import cn.edu.mju.procedure.pojo.Nav;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yfl
 * 2019-9-22
 */
@Repository
@Mapper
public interface NavMapper {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from y_nav")
    List<Nav> findAll() throws Exception;
    
    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @Select("select * from y_nav where nav_id = #{id}")
    Nav findById(Integer id) throws Exception;
    
    /**
     * 更新导航栏
     * @param nav
     */
    @Update("update y_nav set nav_name=#{nav.navName}," +
                    " nav_link=#{nav.navLink}, nav_priority=#{nav.navPriority} " +
                    " where nav_id=#{nav.navId}")
    void update(@Param("nav") Nav nav) throws Exception;
    
    /**
     * 删除
     * @param id
     */
    @Delete("delete from y_nav where nav_id=#{id}")
    void delete(Integer id) throws Exception;
    
    /**
     * 增加
     * @param nav
     * @throws Exception
     */
    @Insert("insert into y_nav(nav_name, nav_link, nav_priority) " +
                    "values(#{nav.navName}, #{nav.navLink}, #{nav.navPriority})")
    void insert(@Param("nav") Nav nav) throws Exception;
}
