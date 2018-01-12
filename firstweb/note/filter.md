一：过滤器
    1.场景：servlet中获取用户参数:request.getParameter("参数名")
         遇到参数内容中文乱码
         post 提交：request.setCharacterEncoding("utf-8");
         get 提交：手动解码 name = new String(name.getBytes("iso-8859-1"),"utf-8");
         通过过滤器把重复操作写进过滤器
        场景2：登录页面->输入用户名密码->后台检查->登录成功->(数据放在session域中)
            判断用户登录权限
    2. 作用
        1.过滤器就是一个实现Filter接口 javax.servlet.Filter 的对象
        2.对象在请求资源(动静态网页),(请求和响应资源时),执行过滤任务
        
     
二：note
    1.Servlet有三大组件：
        Filter:
        Servlet:用于开发动态网页
        Listener
    2.sp有九大内置对象：application、session、request、response、out、page、pagecontent、config、exception
    3.javaEE三大组件技术：Servlet，JSP，EJB
三：servlet
    1.特点：
        1.组件配置到web.xml
        2.组件交给tomcat运行
