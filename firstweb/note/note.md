一：创建Web项目并部署servlet
    1.http://blog.csdn.net/antony9118/article/details/51800404
    2.Run -> 选择Edit Configuration  配置项目
    3.配置多个servlet
        1.http://localhost:8080/hello   HelloServlet
        2.http://localhost              index.jsp
        3.http://localhost:8080/req     RequestServlet
        4.http://localhost:8080/req2    Request2Servlet     判断浏览器
        5.http://localhost:8080/req3    Request3Servlet     正在下载
        6.http://localhost:8080/req4    Request4Servlet     获取参数数据
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
    4.修改响应数据   Request5Servlet
        1. http://localhost:8080/req5
    5. 请求重定向 302 (一次重定向向服务器发送两次请求) Request5Servlet
        浏览器拿到302状态码,会再次向服务器发出新请求,
        请求地址就是location地址
    6. 定时刷新/每个n秒跳转页面    Request5Servlet
    7. 设置编码
    8. 以下载方式
三：Map集合遍历(http://blog.csdn.net/tjcyjd/article/details/11111401)
    a.entrySet()  b.keySet()  c.values()
    1.在for-each循环中使用entries来遍历
    2.在for-each循环中遍历keys或values。
    3.使用Iterator遍历
    4.通过键找值遍历（效率低）
四：http响应 (响应行->响应头->一个空行->实体内容)
    1.响应行：http协议版本  状态码
    2.响应头：
        Location : 重定向地址,结合302状态完成重定向
        Connection:Keep-Alive 连接状态
        Server:Apache/2.4.23 (Win32) OpenSSL/1.0.2j mod_fcgid/2.3.9 服务器类型
        Content-Encoding:服务器发送给浏览器数据压缩格式
        Content-Length:数据长度
        Content-Language:服务器支持语言
        Content-Type: text/html; charset=UTF-8  数据类型和数据编码格式
        Last-Modified:服务器最后修改时间
        Refresh:定时刷新或每个n秒跳转资源
        Content-Disposition: 以下载方式打开资源
        Transfer-Encoding:
        Set-Cookie:SS=Q0=5Lb_nQ;path=/search    通知浏览器不使用缓存
        Expires:-1
        Cache-Control:no-cache
        Pragma:no-cache
        Date:Fri, 29 Dec 2017 23:28:39 GMT  响应发出时间
    3.
            