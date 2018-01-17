一：文件上传下载
    1.http://192.168.0.135:8080/fileUpload/upload.jsp
    2.自定义上传 ：http://192.168.0.135:8080/fileupload/self
    3.fileupload 上传:http://192.168.0.135:8080/fileupload/single
    4,文件列表页 http://192.168.0.135:8080/fileUpload/uploadSuccess.jsp
二：手动解析上传文件
三：fileupload 上传文件
    依赖文件：引入commons-fileupload-1.2.1.jar     引入依赖包commons-io-1.4.jar
    1.FileItemFactory 文件上传工厂类（把每一个请求表单项封装为一个个FileItem对象）
    2.ServletFileUpload 文件上传核心类，可以获取所有的FileItem对象
        list pload.parseRequest(request);
        Boolean isMultipartContent(request);判断表单类型，文件上传表单但会true
        upload.setFileSizeMax(fileSizeMax);设置单个上传文件的最大值
        upload.setSizeMax(sizeMax);设置总上传文件大总的最大值
        upload.setHeaderEcoding("UTF-8");设置上传文件名的编码
    3.FileItem 封装了普通表单项的值以及文件上传表单元素的值
        item.getFiledName();获取上传表单元素的名称
        item.getString();获取上传数据；
        item.getString("UTF-8");获取上传数据，处理中文
        item.getContentType();获取上传文件类型[文件上传项]
        item.getInputStream();获取文件流[文件上传项]
        item.getName();获取文件名[文件上传项]
        item.write(file);把数据写到file文件
        item.delete();删除临时文件
    4.DiskFileItemFactory  设置上传文件的缓存大小和缓存目录
    5.ServletFileUpload    解析上传的所有文件
        List<FileItem>parserRequest(HttpServletRequest request)
        FileItem对象 : 代表一个上传文件(文件名称,大小,类型,内容)
    6.
    7.
    8.
    9.
四：fileupload组件动态多文件上传
五：servlet 下载文件
六：上传下载 数据库

七：web项目 获取文件路径
    1. 放在web目录下  getServletContext().getRealPath()
    2.
    