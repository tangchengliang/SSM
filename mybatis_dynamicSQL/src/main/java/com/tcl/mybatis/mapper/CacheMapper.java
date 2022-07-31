package com.tcl.mybatis.mapper;

import com.tcl.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
    // 通过empId查询 员工信息
    Emp getEmpByEmpIdCache(@Param("empId") Integer empId);
}
