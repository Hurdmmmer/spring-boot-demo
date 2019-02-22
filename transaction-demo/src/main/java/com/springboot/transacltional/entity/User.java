package com.springboot.transacltional.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("user")  /*指定实体类的别名*/
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String mobile;
    /* 枚举类型， 该类型需要转换器*/
    private SexEnum sex;
}
