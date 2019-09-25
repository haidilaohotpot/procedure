package cn.edu.mju.procedure.service.impl;

import cn.edu.mju.procedure.mapper.NavMapper;
import cn.edu.mju.procedure.pojo.Nav;
import cn.edu.mju.procedure.service.NavService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author yfl
 * 2019-9-22
 */
@Service
@Transactional
public class NavServiceImpl implements NavService {
    
    @Autowired
    private NavMapper navMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    
    @Override
    public List<Nav> findAll() throws Exception{
        if (redisTemplate.hasKey("navs")){
            return JSONObject.parseArray(redisTemplate.opsForValue().get("navs"), Nav.class);
        }
        List<Nav> navs = navMapper.findAll();
        redisTemplate.opsForValue().set("navs", JSONObject.toJSON(navs).toString(), 100L);
        return navs;
    }
    
    @Override
    public Nav findById(Integer id) throws Exception{
        List<Nav> navs = JSONObject.parseArray(redisTemplate.opsForValue().get("navs"), Nav.class);
        for (Nav nav : navs) {
            if (nav.getNavId() == id){
                return nav;
            }
        }
        Nav byId = navMapper.findById(id);
        if (byId == null){
            throw new Exception("不存在该ID");
        }
        return byId;
    }
    
    @Override
    public void update(Nav nav) throws Exception{
        navMapper.update(nav);
        List<Nav> navs = navMapper.findAll();
        redisTemplate.opsForValue().set("navs", JSONObject.toJSON(navs).toString(), 100L);
    }
    
    @Override
    public void delete(Integer id) throws Exception{
        List<Nav> list = findAll();
        Boolean flag = false;
        for (Nav nav : list) {
            if (id == nav.getNavId()){
                navMapper.delete(id);
                flag = true;
            }
        }
        if (flag) {
            List<Nav> navs = navMapper.findAll();
            redisTemplate.delete("navs");
            redisTemplate.opsForValue().set("navs", JSONObject.toJSON(navs).toString(), 100L);
        }
        throw new Exception("不存在该ID");
    }
    
    @Override
    public void insert(Nav nav) throws Exception {
        List<Nav> list = findAll();
        for (Nav n : list) {
            if (n.getNavName().equals(nav.getNavName())){
                throw new Exception("该导航栏已存在");
            }
        }
        navMapper.insert(nav);
        List<Nav> navs = navMapper.findAll();
        redisTemplate.opsForValue().set("navs", JSONObject.toJSON(navs).toString(), 100L);
    }
}
