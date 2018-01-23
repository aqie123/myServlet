一：分页查询  pagination
    1.分页核心：设计一个可以存储当前页所有分页相关数据的javabean对象
        a. PageServlet
            1.接收用户输入的员工查询条件,封装EmployeeQuery
            2.
            3.
        b. PageService
        c. PageDao : List<Employee> pageData(currentPage,pageSize)
        d. PageBean 分页对象 (
            data : 当页数据,
            totalCount:总记录数
           )
    2.编写Dao     : pagination.PageDao
        1.PageDao中实例化DepartmentDao
        2.PageDao自行封装结果集 MyEmployeeResultSetHandler
        3.findCurrentPageInfo 中 MyEmployeeResultSetHandler 代替 BeanListHandler
    3.service     : pagination.PageService
    4.jsp         : pagination/empList.jsp
      servlet     : pagination.PageServlet
    5. entity     : Employee  EmployeeQuery
        1.Employee 类中维护Department
    6.http://192.168.0.135:8080/pagination/list?pageSize=3&currentPage=2
二：条件查询  pagination
    1. 模糊查询        
        -- 模糊查询（1个条件）
        IF 负责人不为空 THEN
        SELECT * FROM department WHERE principal LIKE '%李%';    
        -- -- 模糊查询（2个条件）
        IF 部门名称不为空 且 负责人不为空 THEN
        SELECT * FROM department WHERE deptName LIKE '%应用%' AND principal LIKE '%李%';   
        -- 改造sql
        SELECT * FROM department WHERE 1=1; -- 恒等
        IF 部门名称不为空 THEN
             AND deptName LIKE '%应用%';
        IF 负责人不为空 THEN
             AND principal LIKE '%李%';
        IF 职能不为空 THEN		
            AND functional LIKE '开发';
    2.  entity : Department , DepartmentQuery
        Dao     : DepartmentDao
        service : DepartmentService
        servlet : DepartmentServlet   pagination/department
            1.接收输入的查询条件参数,封装成DepartmentQuery对象
            2.调用findByCondition,传入DepartmentQuery参数
            3.得到list数据,转发到jsp页面
        jsp     : pagination/departmentList.jsp
        1. 访问路径 http://192.168.0.135:8080/pagination/department
三：分页+条件查询 pagination
    1.关键：在分页基础上,加上组合模糊条件影响到了PageBean两个数据 ： 当前页数据,总记录数
    2.策略：改变当前页数据sql,改变总记录数sql
四：note
    1.int 整型互转 ： http://blog.csdn.net/memray/article/details/7312817/
    2.常用查询封装 ： MetaData.MyDbutils