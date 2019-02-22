package com.springboot.transacltional.dao;

import com.springboot.transacltional.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insertUser(User user);

    User getUser(@Param("id") int id);
}
