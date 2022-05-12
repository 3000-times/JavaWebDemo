package comm.tcherw;

import comm.tcherw.mapper.brandMapper;
import comm.tcherw.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class MyBatisDemo2Test {

    @Test
    public void test() throws IOException {

        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //SqlSession对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
//        List<Brand> brands = sqlSession.selectList("wangtichang.selectAll");
        //获取接口代理对象
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        //执行方法，执行sql语句
//        List<Brand> brands = mapper.selectAll();
//        System.out.println(brands);

        Brand brand = new Brand();
        brand.setBrandName("华为");
        List<Brand> a = mapper.selectSingle(brand);
        System.out.println(a);


        //释放资源
        sqlSession.close();

    }

}