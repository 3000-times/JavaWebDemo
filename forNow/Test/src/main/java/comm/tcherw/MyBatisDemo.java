package comm.tcherw;

import comm.tcherw.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws IOException {

        //加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //SqlSession对象，用它执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
        List<Brand> brands = sqlSession.selectList("wangtichang.selectAll");

        System.out.println(brands);

        //释放资源
        sqlSession.close();
    }
}
