<%--
  Created by IntelliJ IDEA.
  User: 张
  Date: 2018/6/22
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="c" uri="/struts-tags" %>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <base href="<%=basePath%>">
    <title>CSS+JS实现兼容性很好的无限级下拉菜单</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/menu.css">
    <link rel="stylesheet" type="text/css" href="css/slide_picture.css">

    <%--<script type="text/javascript">document.execCommand("BackgroundImageCache", false, true);</script>--%>
    <!-- IE6背景图片闪烁问题  -->

</head>
<body>
<%--<s:debug/>--%>
<script language="javascript" src="js/slide_picture.js" charset="UTF-8"></script>
<div class="page">
        <h1>某某公司</h1>
    <div class="top">
    <%
        String name=(String)session.getAttribute("username");
        if (name==null){%>
        <a href="login.jsp">登录</a>&nbsp/
        <a href="regedit.jsp">注册</a>
        <%
            }
            else {%>
        <s:property value = "#session.username" /> 欢迎您！&nbsp&nbsp
        <a href="logout.action">退出</a>
        <%
            }
        %>

    </div>
    <div class="menu1">
        <div class="menu1-li">
            <div class="tit">
                一级标题
            </div>
            <ul>
                <li>
                    二级标题
                    <div class="list-3">
                        <div class="list-3Dom">
                            三级栏目
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="menu1-li">
            一级标题
        </div>
        <div class="menu1-li">
            一级标题
        </div>
        <div class="menu1-li">
            一级标题
        </div>
    </div>

    <div id="container">
        <div id="list" style="left: -900px;">
            <img src="image/love.jpg" alt="1"/>
            <img src="image/distance.jpg" alt="1"/>
            <img src="image/horse.jpg" alt="2"/>
            <img src="image/love.jpg" alt="3"/>
            <%--<img src="image/distance.jpg" alt="3"/>--%>
        </div>
        <div id="buttons">
            <span index="1" class="on"></span>
            <span index="2"></span>
            <span index="3"></span>
        </div>
        <a href="javascript:;" id="prev" class="arrow">&lt;</a>
        <a href="javascript:;" id="next" class="arrow">&gt;</a>
    </div>
</div>
</body>
</html>

