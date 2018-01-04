一：URLEncoder  URLDecode类  MyURLEncoder.java 对中文进行加密解密
    1. url加密
    2.
二：会话管理
    1.一次回话 打开浏览器->访问服务器->关闭浏览器
    2.context域会覆盖之前数据
    3.使用request域,一定要使用转发技术来跳转页面
    4.session
    5.cookie
三：cookie
    1.创建cookie对象 new Cookie();
    2.修改Cookie对象
        setPath()
        setMaxAge()
        setValue()
    3.cookie数据发送给浏览器保存
        response.add(cookie)
    4.浏览器带着cookie访问服务器,服务器接收
        request.getCookie();
    5. cookie原理
        1.服务器创建cookie对象,保存会话数据,Cookie发送给浏览器
            resp.addCookie(cookie);  响应头：resp.setHeader("set-cookie","name=aqie123");
        2.浏览器获取cookie数据,保存在浏览器缓存区,下次访问服务器携带cookie数据
        3.服务器获取浏览器数据   req.getCookies();
    6.cookie 细节
        1.中文先加密再解密
        2.数据类型只能字符串
        3.setPath() 修改cookie有效路径
        4.setMaxAge(整数) 设置cookie有效时间
            正整数：保存浏览器缓存目录 ，时间
            负整数:保存浏览器内存,关闭浏览器消失
            0：删除同名cookie
        5.每个站点最多存放20个cookie，浏览器最多300个,每个大小4KB
    7.应用：
        1.上次访问时间
        2.显示最近浏览商品
            1.数据库中所有商品数据,商品数据展示到浏览器
            2.获取商品编号,根据商品编号到数据库查询对应商品,
             找到商品展示到浏览器
            3.http://localhost:8080/product
            4. recent, cookie.ProductServlet, libs.PublicFunctions
            5.
    8.开发顺序
        1.数据库(xml)->实体对象->DAO类->servlet类->用户
    9.缺点
        1.会话数据在浏览器端,不安全
        2.数据类型只能String，且有大小限制
四：session
    1.优点
        1.会话数据在服务端，相对安全
        2.任意数据类型，无大小限制
    2.方法
        1.创建HttpSession对象,保存会话数据
            request.getSession()/ request.getSession(true)  创建或获取session对象
        2.修改HttpSession对象
            setMaxInactiveInterval(int interval 秒数)  设置有效时间
                1.默认等待30分钟空闲时间,session销毁
            void invalidate()                     手动销毁
            void setAttribute("name",object)      保存会话数据(作为域对象) 
            java.lang.Object getAttribute("name")         获取数据
            void removeAttribute()                        删除数据
        3. session.SessionServlet  保存和读取session
    3.流程
        1. 服务器创建session对象，给session对象分配一个唯一标记的SessionID
        2. SESSIONID 作为cookie发送给浏览器
        3. 浏览器保存sessionID,携带SESSIONID访问浏览器
        4. 服务器得到SESSIONID，在服务器内存中搜索是否存在指定SESSIONID的对象
        5. 存在则返回，不存在则返回null或再创建
    4.应用：用户登录
        1.login.html users.xml index.html 
        2. 创建User类 UserDao类
        3. LoginServlet  UserIndexServlet
五：Xml中SelectSingleNode方法中的xpath用法
    1.http://blog.csdn.net/sky786905664/article/details/53696076