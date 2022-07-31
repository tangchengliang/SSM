import com.tcl.mybatis.mapper.EmpMapper;
import com.tcl.mybatis.pojo.Emp;
import com.tcl.mybatis.pojo.EmpExample;
import com.tcl.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {

    @Test
    public void testMBG(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询所有数据
//        List<Emp> list = mapper.selectByExample(null);
//        list.forEach(emp -> System.out.println(emp));
        //根据条件查询
        EmpExample example = new EmpExample();
        example.createCriteria().andEmpNameEqualTo("张三").andAgeLessThanOrEqualTo(23);
        example.or().andGenderEqualTo("男");
        List<Emp> emps = mapper.selectByExample(example);
        emps.forEach(System.out::println);
    }
}
