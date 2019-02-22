package com.springboot.redis.service;

import com.springboot.redis.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static int count = 0;
    private static Map<Integer, User> db = new HashMap<>();

    static {
        User user = new User();
        user.setId(count);
        user.setUsername("zhangsan");
        db.put(count, user);
    }
    /**
     *  [@CachePut] 表示方法返回的结果存储到缓存中
     *  value 缓存中指定的分组
     * */
    @CachePut(value = "BasicDataCache", key = "'user_'+#result.id")
    public User insertUser(User user) {
        user.setId(count++);
        db.put(count, user);
        return user;
    }

    /**
     *  [@Cacheable : 先从缓存中获取数据， 如果没有数据则再去查询
     * */
    @Cacheable(value = "BasicDataCache", key = "'user_' + #id")
    public User getUser(int id) {
        System.out.println("没有走缓存查询");
        return db.get(id);
    }

    /**
     *  修改缓存数据
     *  condition = "result != null " 条件判断， 如果为 null 则继续存放到缓存中
     */
    @CachePut(value = "BasicDataCache", key = "'user_' + #result.id", condition = "#result != null ")
    public User updateUser(User user) {
        User dbUser = this.getUser(user.getId());
        if (dbUser == null) {
            return null;
        }
        db.put(user.getId(), user);
        return user;
    }

    /**
     *  删除缓存  CacheEvict
     */
    @CacheEvict(value = "BasicDataCache", key = "'user_'+#id")
    public void deleteUser(Integer id) {

    }

}
