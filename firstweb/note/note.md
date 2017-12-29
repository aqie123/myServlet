一：创建Web项目并部署servlet
    1.http://blog.csdn.net/antony9118/article/details/51800404
    2.Run -> 选择Edit Configuration  配置项目
    3.配置多个servlet
        1.http://localhost:8080/hello   HelloServlet
        2.http://localhost              index.jsp
        3.http://localhost:8080/reg     RequestServlet
        4.http://localhost:8080/reg2    Request2Servlet     判断浏览器
        5.http://localhost:8080/reg3    Request3Servlet     正在下载
        6.http://localhost:8080/reg4    Request4Servlet     获取参数数据
二：HttpServletRequest对象
    1. user-agent : 获取浏览器类型     Request2Servlet
    2. referer: 防止非法链接
        第一次：下载资源->下载页面->打开广告(下载链接)->开始下载
        第二次：点击下载链接->跳转广告页面(下载链接)->开始下载
        非法请求：1) 直接访问下载资源
                  2) 不是从广告页面过来的请求
        referer:只有从超链接过来的请求才有这个头
    3.获取参数数据 Request4Servlet
        1.get:请求行URI后面
        2.post:放在内容实体
        3.通用获取参数的方法
            1. req.getParameter();  根据参数名获取参数值
三：Map集合遍历(http://blog.csdn.net/tjcyjd/article/details/11111401)
    a.entrySet()  b.keySet()  c.values()
    1.在for-each循环中使用entries来遍历
    2.在for-each循环中遍历keys或values。
    3.使用Iterator遍历
    4.通过键找值遍历（效率低）
            