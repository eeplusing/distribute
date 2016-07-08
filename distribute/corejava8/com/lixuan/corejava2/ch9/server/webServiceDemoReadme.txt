wsgen -keep -cp ./bin -r ./wsdl -s ./corejava8part2 -d ./bin -wsdl com.lixuan.corejava2.ch9.server.Warehouse

wsimport -keep -p com.lixuan.corejava2.ch9.client http://localhost:8080/WebService/warehouse?wsdl 
	//http://localhost:8080/WebService/warehouse?wsdl 被编码在WarehouseService类中


用法: WSGEN [options] <SEI>

\其中 [options] 包括:
  -classpath <path>          指定查找输入类文件的位置
  -cp <path>                 与 -classpath <path> 相同
  -d <directory>             指定放置生成的输出文件的位置
  -encoding <encoding>       指定由源文件使用的字符编码
  -extension                 允许供应商扩展 - 不按规范
                             指定功能。使用扩展可能会
                             导致应用程序不可移植或
                             无法与其他实现进行互操作
  -help                      显示帮助
  -keep                      保留生成的文件
  -r <directory>             资源目标目录, 指定放置
                             资源文件 (例如 WSDL) 的位置
  -s <directory>             指定放置生成的源文件的位置
  -verbose                   有关编译器在执行什么操作的输出消息
  -version                   输出版本信息
  -wsdl[:protocol]           生成 WSDL 文件。协议是可选的。
                             有效协议是[soap1.1, Xsoap1.2],
                             默认值为 soap1.1。
                             非标准协议[Xsoap1.2]
                             只能与
                             -extension 选项结合使用。
  -inlineSchemas             生成的 wsdl 中的内嵌模式。必须
                             与 -wsdl 选项结合使用。
  -servicename <name>        指定要用在生成的 WSDL 中的服务名
                             与 -wsdl 选项结合使用。
  -portname <name>           指定要用在生成的 WSDL 中的端口名
                             与 -wsdl 选项结合使用。

Extensions:
  -Xnocompile                do not compile generated Java files

\示例:
  wsgen -cp . example.Stock
  wsgen -cp . example.Stock -wsdl -servicename {http://mynamespace}MyService


