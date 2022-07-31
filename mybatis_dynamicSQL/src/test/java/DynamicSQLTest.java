import com.tcl.mybatis.mapper.DynamicSQLMapper;
import com.tcl.mybatis.pojo.Emp;
import com.tcl.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author tcl
 * @date 2022-07-29 17:11
 */
public class DynamicSQLTest {
    @Test
    public void getEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 23, "男");
        List<Emp> empByCondition = mapper.getEmpByCondition(emp);
        empByCondition.forEach(System.out::println);
    }

    @Test
    public void getEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "", 23, "男");
        List<Emp> empByCondition = mapper.getEmpByChoose(emp);
        empByCondition.forEach(System.out::println);
    }

    @Test
    public void testInsertMoreValue(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "hello", 23, "男");
        Emp emp1 = new Emp(null, "asd", 23, "男");
        Emp emp2= new Emp(null, "fas", 23, "男");
        List<Emp> emps = Arrays.asList(emp, emp1, emp2);
        mapper.insertMoreEmp(emps);
    }

    @Test
    public void testDeleteMoreValue(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = {5, 6};
        mapper.deleteMoreMap(empIds);
    }
}
