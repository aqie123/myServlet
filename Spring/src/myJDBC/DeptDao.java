package myJDBC;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class DeptDao {
    // 原始jdbc代码
    public void save(Department dept) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection collection = DriverManager.getConnection("jdbc:mysql:///test",
                "root","root");
        PreparedStatement ps = collection.prepareStatement("insert into department(name) values('推广部')");
        ps.executeUpdate();
        ps.close();
        collection.close();
    }
}
