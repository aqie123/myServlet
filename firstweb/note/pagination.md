一：分页查询  pagination(Entity(PageBean Employee EmployeeQuery Department))->Dao->service->PageServlet->empList.jsp)
    1.分页核心：设计一个可以存储当前页所有分页相关数据的javabean对象
        a. Entity
            1.PageBean 分页对象 (
                data : 当页数据,
                totalCount:总记录数
              )
               维护要分页的对象 Employee
            2.Employee : 内部维护关联Department对象
            3.EmployeeQuery : 条件查询对象
            4.Department : 部门类
        b. PageDao : 
            1.List<Employee> pageData(currentPage,pageSize)
            2.自行封装结果集 : MyEmployeeResultSetHandler
        c. PageService
        d. PageServlet
            1.从用户参数中获取当前页数据和每页大小
            2.封装PageBean对象
            3.接收用户输入的员工查询条件,封装EmployeeQuery查询对象
            4.查询数据库,传入当页数据
            5.查询部门信息
            6.PageBean对象放入域对象中
            7.转发jsp页面展示数据     
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