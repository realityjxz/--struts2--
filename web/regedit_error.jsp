<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <base href="<%=basePath%>">
    <title>用户注册失败</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">

    <%--<script type="text/javascript">document.execCommand("BackgroundImageCache", false, true);</script>--%>
    <!-- IE6背景图片闪烁问题  -->

</head>
<body>
    error
</body>
</html>
