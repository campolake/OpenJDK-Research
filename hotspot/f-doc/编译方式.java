##执行步骤
C:\VC2010\VC\bin\vcvars32.bat
set HOTSPOTMKSHOME=c:\Cygwin\bin 
create C:\jdk1.8.0_25
电脑上装了三个版本的VS，在第一步尝试用VS2015和VS2013均不成功，最后第一步用VS2010，编译的时候用VS2013打开顺利编译完毕。
编译注意事项：
1、编译的时候需要把VS的将警告视为错误关闭。
2、错误1
错误	65	error MSB3073: 命令“cd G:\sourcecode\OpenJDK-Research\hotspot\build\vs-i486\compiler1\debug
set HOTSPOTMKSHOME=c:\Cygwin\bin 
set JAVA_HOME=C:\jdk1.8.0_25
c:\Cygwin\bin \sh G:\sourcecode\OpenJDK-Research\hotspot\\make\windows\build_vm_def.sh -nosa 1000
:VCEnd”已退出，代码为 9009。	
C:\Program Files (x86)\MSBuild\Microsoft.Cpp\v4.0\V120\Microsoft.CppCommon.targets	127	5	jvm

报这个错误是因为build_vm_def.sh的格式是windows格式的，
使用notepad++打开该文件，打开编辑->档案格式转换->转换为UNIX格式即可。
如果报git错误，需要在path环境变量中删除git的路径，重新运行该命令。

然后打开jvm.vcxproj文件，将其中的
c:\Cygwin\bin \sh G:\sourcecode\OpenJDK-Research\hotspot\\make\...
修改为
c:\Cygwin\bin\sh G:\sourcecode\OpenJDK-Research\hotspot\make\...

这一步应该是生成脚本中有空格，直接修改生成脚本也可以。