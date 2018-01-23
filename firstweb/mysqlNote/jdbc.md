一：jdbc优化
    1.连接池
        1.提高Connection利用率,提高SQL执行效率
        2.控制Connection创建数量
    2.常用连接池工具
        1.DBCP连接池
            BasicDataSource对象,(实现DataSource接口),getConnection获取连接
            将连接放回连接池,Connection.close() (被代理重写)
        2.C3P0连接池
            ComboPooledDataSource对象(实现DataSource接口),getConnection获取连接
            将连接放回连接池,Connection.close() (被代理重写)
    3.BeanUtils 工具,操作javabean对象
        1.拷贝一个属性BeanUtils.copyProperty(拷贝到对象,拷贝属性,值)
        2.拷贝一个javabean对象,BeanUtils.copyProperties(拷贝到对象,原来的对象)
        3.Map集合拷贝到javabean,BeanUtils.copyProperties(拷贝到对象,map集合)
            map集合的key是javabean的属性名称,value 是拷贝的值
            Map<key,value> request.getParameterMap();
    4.JDBC元数据
        1.DatabaseMetaData 接口：数据库元数据对象
            数据库名，版本，版本驱动
        2.ParameterMetaData 接口:参数元数据对象
            得到参数数量
            写出通用的参数赋值代码
        3.ResultSetMetaData 接口：结果集元数据对象
            得到列数量，得到列名称
            写出通用的遍历结果集代码
    5.DBUtils 工具，jdbc简单封装框架
        1.QueryRunner类，执行sql语句
            update() ;更新操作(DDL+DML)
            query(): 执行查询操作(DQL)
        2.ResultSetHandler接口：将结果集封装成不同对象
        3.常用实现类
            1.ArrayHandler : 结果集第一行数据
            2.ArrayListHandler:每行数据封装成对象数组,每个对象数组放入list
                (表字段名和javabean属性名一致)
            3.BeanHandler : 结果集第一行数据封装到javabean对象
            4.BeanListHandler:
        
    