package com.tcl.mybatis.mapper;

import com.tcl.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tcl
 * @date 2022-07-28 15:02
 */
public interface EmpMapper {

    // 通过empId查询 员工信息
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    // 通过empId查询 员工信息和部门信息
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    // 通过empId 分步查询 员工信息和部门信息
    /**
     * 第一步：通过分步查询查询员工信息
     * @author tcl
     * @date 2022/7/28 17:11
     * @param empId
     * @return com.tcl.mybatis.pojo.Emp
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    //一对多分步查询第二步
    List<Emp> getDeptAndEmpByDeptIdStepTwo(@Param("deptId") Integer deptId);
}
