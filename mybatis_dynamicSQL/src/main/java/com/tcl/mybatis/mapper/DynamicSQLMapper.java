package com.tcl.mybatis.mapper;

import com.tcl.mybatis.pojo.Emp;

import java.util.List;

/**
 * @author tcl
 * @date 2022-07-29 16:45
 */
public interface DynamicSQLMapper {

    // 根据条件查询员工信息
    List<Emp> getEmpByCondition(Emp emp);

    // 根据choose查询员工信息
    List<Emp> getEmpByChoose(Emp emp);
}
