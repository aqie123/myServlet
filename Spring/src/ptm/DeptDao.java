package ptm;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class DeptDao implements Dao{
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public void save() {
        jdbcTemplate.update("insert into department(name) value ('artist')");
    }
    public void update(){

    }
}
