package com.tcl.mybatis.mapper;

import com.tcl.mybatis.pojo.Dept;
import com.tcl.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tcl
 * @date 2022-07-28 17:16
 */
public interface DeptMapper {

    // 分步查询第二步
    /**
     * 根据员工所对应的did查询部门信息
     * @author tcl
     * @date 2022/7/28 17:19
     * @param deptId 
     * @return com.tcl.mybatis.pojo.Dept
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    // 通过部门id，获取当前部门所有员工信息
    List<Emp> getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    // 分步查询
    // 第一步，查询部门ID的所有信息
    Dept getDeptAndEmpByDeptIdStepOne(@Param("deptId") Integer deptId);
}
