package myJDBC;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class Dept2Dao {
    // 接收容器注入的DataSource 对象
    @Resource
    private DataSource dataSource;

    public void save(Department dept) throws Exception{
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into department(name) values('推广部')");
        ps.executeUpdate();
        ps.close();
        connection.close();
    }
}
