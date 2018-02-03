package myJDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Repository
public class Dept3Dao{
    @Resource
    private DataSource dataSource;

    String sql = "insert into department(name) values(?)";
    public void save(Department dept){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,dept.getName());
    }

    // 通过beam.xml 简化
    @Resource
    private JdbcTemplate jdbcTemplate;
    public void save2(Department dept){
        jdbcTemplate.update(sql,dept.getName());
    }

}
