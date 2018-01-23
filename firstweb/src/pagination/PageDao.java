package pagination;

import FileUpload.FileBean;
import MetaData.MyDbutils;
import mysql.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class PageDao {
    DepartmentDao departmentDao = new DepartmentDao();
    private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
    // 查询所有数据
    public List<Employee> findAll(){
        try {
            return (List<Employee>)qr.query("select * from employee",
                    new BeanListHandler<>(Employee.class),
                    new Object[]{});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    // 查询总数量
    public long countNumber(){
        String sql = "select count(*) from employee";
        try {
            return MyDbutils.selectCount(sql,qr);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 查询当前页数据(联表查询)
    public List<Employee> findCurrentPageInfo(int currentpage,int pagesize){
        int length = (currentpage-1)*pagesize;
        try {
            return (List<Employee>)qr.query("select * from employee limit ?,?",
                    new MyEmployeeResultSetHandler(),
                    new Object[]{length,pagesize});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 查询当前页数据 (联表 + 模糊查询)
    public List<Employee> queryEmployee(int currentpage,int pagesize, EmployeeQuery query){
        StringBuffer sql = new StringBuffer("select * from employee where 1=1 ");

        if(query!=null){
            if(query.getName()!=null && !query.getName().trim().equals("")){
                sql.append(" and name like '%"+query.getName()+"%'");
            }
            if(query.getGender()!=null && !query.getGender().trim().equals("")){
                sql.append(" and gender='"+query.getGender()+"'");
            }
            if(query.getPosition()!=null && !query.getPosition().trim().equals("")){
                sql.append(" and title like '%"+query.getPosition()+"%'");
            }
            if(query.getEmail()!=null && !query.getEmail().trim().equals("")){
                sql.append(" and email like '%"+query.getEmail()+"%'");
            }
            //
            if(query.getBeginSalary()!=0){
                sql.append(" and salary>='"+query.getBeginSalary()+"'");
            }
            if(query.getEndSalary()!=0){
                sql.append(" and salary<='"+query.getEndSalary()+"'");
            }
            //
            if(query.getDpID()!=0){
                sql.append(" and dpID="+query.getDpID()+"");
            }
        }
        //
        sql.append(" limit ?,?");
        System.out.println(sql.toString());

        int length = (currentpage-1)*pagesize;
        try {
            List<Employee> list = (List<Employee>)qr.query(sql.toString(), new MyEmployeeResultSetHandler(), new Object[]{length,pagesize});
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    // 自行封装结果集
    class MyEmployeeResultSetHandler implements ResultSetHandler{

        @Override
        public Object handle(ResultSet resultSet) throws SQLException {
            List<Employee> list = new ArrayList<>();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getInt("gender"));
                employee.setPosition(resultSet.getString("position"));
                employee.setEmail(resultSet.getString("email"));
                employee.setSalary(resultSet.getDouble("salary"));

                // 部门id
                int departmentID = resultSet.getInt("dpID");
                // 根据id查询部门对象
                Department department = departmentDao.findByID(departmentID);
                employee.setDepartment(department);
                list.add(employee);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        PageDao dao = new PageDao();
        /*List<Employee> list = dao.findAll();
        for(Employee e : list){
            System.out.println(e);
        }*/
        // System.out.println(dao.countNumber());
        EmployeeQuery query = new EmployeeQuery();
        query.setDpID(4);
        List<Employee> list = dao.queryEmployee(1,2,query);
        for(Employee e : list){
            System.out.println(e);
        }
    }
}
