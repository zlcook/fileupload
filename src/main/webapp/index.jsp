<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>服务调用测试</title>
</head>
<body>
<div id="container " style="margin-left: 20px;margin-top: 20px;">

    <form action='upload.html' method="post" enctype="multipart/form-data" >
        <div>
	     <span   >
             服务接口调用
		</span>
        </div>

        <input type="file" name="myfile"   id="myfile"  >
        <input type="submit" value="提交" >
    </form>
</div>
</body>
</html>
