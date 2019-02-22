package com.springboot.transacltional.typehandler;

import com.springboot.transacltional.entity.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  mybatis 类型转换器， 该类要实现 {@link BaseTypeHandler} 抽象类
 *  <br> @MappedJdbcTypes: 注解指定与数据库中对应的类型
 *  <br> @MappedTypes： 注解指定与 java 中对应的数据类型
 */
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    /* 设置非空性别参数*/
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getCode());
    }
    /* 通过数据库列名性别 */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        return getSexEnum(sex);
    }
    /* 通过下标获取性别*/
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        return getSexEnum(sex);
    }

    private SexEnum getSexEnum(int sex) {
        if (sex != 1 && sex != 2) {
            return null;
        }
        return SexEnum.getEnumById(sex);
    }
    /* 通过存储过程获取性别*/
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        return getSexEnum(sex);
    }
}
