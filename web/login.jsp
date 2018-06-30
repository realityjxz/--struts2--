<%--
  Created by IntelliJ IDEA.
  User: 张总
  Date: 2018/6/20
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>用户登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <!--
    <link rel="bookmark" href="favicon.ico" />
    <link rel="shortcut icon" href="https://tool.lu/favicon.ico">
    -->
</head>

<body>
<s:debug/>
    <div class="top">
        <a href="index.jsp">返回首页</a>
    </div>
<h1>某某公司后台登录系统</h1>
<div class="container">
    <h2>现在登录</h2>
    <s:actionerror cssStyle="color:red;font-weight: bold"/>
    <s:fielderror cssStyle="color:darkred;font-weight: bold" />
    <form action="checkLogin" method="post">
        <div>
            <span>用户:</span>
            <input type="text" name="user.username" class="name" placeholder="请输入用户名" > <%--required="required"此处判断action里不判断--%>
            <div class="clear"></div>
        </div>
        <div>
            <span>密码:</span>
            <input type="password" name="user.pass" class="password" placeholder="请输入密码" >
            <div class="clear"></div>
        </div>
        <div class="rem-for-agile">
            <input type="checkbox" name="remember" class="remember" title="">记得我
            　　
            <br><br>
            <a href="#">忘记了密码</a><br>
        </div>
        <div class="login-w3">
            <input type="submit" class="login" value="Login">
        </div>
        <div class="clear"></div>
    </form>
</div>
<div class="footer-w3l">
    <p> 某某公司后台登录系统</p>
</div>
</body>
</html>
