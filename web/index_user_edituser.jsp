<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户信息修改</title>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <sj:head compressed="true" jquerytheme="redmond" ajaxcache="false"/>
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/regedit.css">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <s:head/>
    <sj:head/>
</head>
<body>
<s:debug/>
<div class="top">
    <a href="user_list.action">返回上层</a>
</div>
<%--<h1>软件学院后台管理注册系统</h1>--%>
<div class="container">
    <h2>现在修改</h2>
    <s:actionerror/>
    <s:fielderror/>
    <s:form action="user_update" method="post" theme="simple">
                <s:hidden name="user.id"></s:hidden>
        <div>
            <span>用户:</span>
            <s:textfield name="user.username" label="" cssClass="name"/>
            <div class="clear"></div>
        </div>
        <div>
            <span>密码:</span>
            <s:textfield name="user.pass" label="" cssClass="password" />
            <div class="clear"></div>
        </div>
        <div>
            <span>性别:</span>
            <s:select name="user.sex" list="#{'男':'男', '女':'女'}" id="select" />
            <div class="clear"></div>
        </div>
        <div>
            <span>生日:</span>
            <sj:datepicker name="user.birth" id="birth" readonly="true"
                           displayFormat="%{getText('format.date.input')}"
                           showButtonPanel="true"  showOn="focus"
                           changeMonth="true" changeYear="true"
             minDate= "-1200M"  maxDate="+0D"/> <%--只读框，不用填写--%>
            <div class="clear"></div>
        </div>
        <div>
            <span>手机号:</span>
            <s:textfield name="user.phone" cssClass="name" id="phone" />
            <div class="clear"></div>
        </div>
        <div class="login-w3">
            <s:submit value="提交" cssClass="submit"/>
        </div>
        <div class="clear"></div>
    </s:form>
</div>
<div class="footer-w3l">
    <p> 软件学院后台修改系统</p>
</div>
</body>
</html>
