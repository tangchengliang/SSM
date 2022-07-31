import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tcl.mybatis.mapper.EmpMapper;
import com.tcl.mybatis.pojo.Emp;
import com.tcl.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageTest {
    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        // 查询之前，需要开启分页
        Page<Object> page = PageHelper.startPage(2, 4);
        List<Emp> emps = mapper.selectByExample(null);
        emps.forEach(System.out::println);

    }
}
