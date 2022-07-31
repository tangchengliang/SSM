import com.tcl.mybatis.mapper.CacheMapper;
import com.tcl.mybatis.pojo.Emp;
import com.tcl.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheTest {
    @Test
    public void testCacheGetEmpById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empByEmpId = mapper.getEmpByEmpIdCache(1);
        System.out.println(empByEmpId);
        sqlSession.clearCache();
        Emp empByEmpId2 = mapper.getEmpByEmpIdCache(1);
        System.out.println(empByEmpId2);
    }

    @Test
    public void testSecondCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 获取 SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 获取SqlSession对象
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper = sqlSession1.getMapper(CacheMapper.class);
        Emp empByEmpIdCache = mapper.getEmpByEmpIdCache(1);
        System.out.println(empByEmpIdCache);
        sqlSession1.close();
        // 同一个sqlSessionFactory下的第二个sqlSession
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp empByEmpIdCache2 = mapper2.getEmpByEmpIdCache(1);
        System.out.println(empByEmpIdCache2);
        sqlSession2.close();
    }
}
