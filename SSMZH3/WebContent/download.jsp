<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  
      //   得到文件名字和路径  
      String   filename   =   "20190425021217.xls";  
      String   filepath   =   "E:\\";
       
      //   设置响应头和下载保存的文件名  
      response.setContentType("APPLICATION/OCTET-STREAM");  
      response.setHeader("Content-Disposition",  
      "attachment;   filename=\""   +   filename   +   "\"");  
      System.out.println(filename);
     
      //   打开指定文件的流信息
      java.io.FileInputStream   fileInputStream   =   new   java.io.FileInputStream(filepath   +   filename);  
      
      //   写出流信息
      int   i;  
      while   ((i=fileInputStream.read())   !=   -1)   {  
        out.write(i);  
      }  
      fileInputStream.close();  
      out.close();  
    %>
</body>
</html>