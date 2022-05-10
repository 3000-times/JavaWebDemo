package comm.tcherw;

//import com.alibaba.druid.pool.DruidDataSourceFactory;
import comm.tcherw.pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class jdbcTest {

    public static void main(String[] args) throws Exception {


        //注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "xiaogui";
        Connection connection = DriverManager.getConnection(url, username, password);
        //定义sql
        String sql = "select * from tb_brand";

//        //solution1 最常规的写法
//        //获取执行SQL对象
//        Statement statement = connection.createStatement();
//        //执行SQL
//        ResultSet rs = statement.executeQuery(sql);

        //solution2 使用PrepareStatement防止sql注入、预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();


//        //solution3 使用druid连接池 ----一直没有解决“程序包com.alibaba.druid.pool不存在”的问题
//        //加载配置文件
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("druid.properties"));
//        //获取连接池对象
//        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
//        //获取数据库连接
//        Connection connection1 = dataSource.getConnection();
//
//        PreparedStatement preparedStatement = connection1.prepareStatement(sql);
//        ResultSet rs = preparedStatement.executeQuery();

        ArrayList<Brand> brands = new ArrayList<Brand>();

        while (rs.next()){
            Brand brand = new Brand();

            brand.setId(rs.getInt("id"));
            brand.setBrand_name((rs.getString("brand_name")));
            brand.setCompany_name(rs.getString("company_name"));
            brand.setOrdered(rs.getInt(4));
            brand.setDescription(rs.getString(5));
            brand.setStat(rs.getInt(6));

            brands.add(brand);
        }

        Iterator<Brand> it = brands.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }

//        statement.close();
        preparedStatement.close();
        connection.close();
    }
}
