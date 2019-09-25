package cn.edu.mju.procedure.service;

import cn.edu.mju.procedure.pojo.Nav;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author yfl
 * 2019-9-22
 */
public interface NavService {
    /**
     * 查询所有
     * @return
     */
    List<Nav> findAll() throws Exception;
    
    /**
     * 通过ID查询
     * @param id
     * @return
     */
    Nav findById(Integer id) throws Exception;
    
    /**
     * 更新导航栏
     * @param nav
     */
    void update(Nav nav) throws Exception;
    
    /**
     * 删除
     * @param id
     */
    void delete(Integer id) throws Exception;
    
    /**
     * 增加
     * @param nav
     * @throws Exception
     */
    void insert(@Param("nav") Nav nav) throws Exception;
}
