package myJDBC;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Dept4Dao implements Dao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Department dept) {
        String sql = "insert into department(name) values(?)";
        jdbcTemplate.update(sql,dept.getName());
    }

    @Override
    public void update(Department dept) {
        String sql = "update department set name=? where id=?";
        jdbcTemplate.update(sql,dept.getName(),dept.getId());
    }

    @Override
    public void delete(Serializable id) {
        String sql = "delete from department where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Department findById(Serializable id) {
        // queryForList 把每一行都封装为map对象，再添加到list中
        //List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_dept");

        String sql = "select * from department where id=?";
        List<Department> list = jdbcTemplate.query(sql,new MyRowMapper(),id);
        return (list!=null&&list.size()>0)?list.get(0):null;
    }

    @Override
    public List<Department> getAll() {
        String sql = "select * from department";
        List<Department> list = jdbcTemplate.query(sql,new MyRowMapper());
        return list;
    }

    class MyRowMapper implements RowMapper<Department>{
        @Override
        public Department mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department = new Department();
            department.setId(resultSet.getInt("id"));
            department.setName(resultSet.getString("name"));
            return department;
        }
    }
}
