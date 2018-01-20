1.java.rmi.server.ExportException: Port already in use: 1099; nested exception is: 
	java.net.BindException: Address already in use: JVM_Bind
	    1.netstat -ano  找到错误信息中的端口 1099 : 3764  进程号(pid)  : 
	    2.记下进程号：这里是55512
	    3. taskkill /pid 3764 -t -f;  taskkill /pid 3764 /f