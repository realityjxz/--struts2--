<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>用户注册</title>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
    <%--<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>--%>
    <sj:head compressed="true" jquerytheme="redmond" ajaxcache="false"/>
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="css/regedit.css">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <s:head/>
    <sj:head/>
    <%--<script>
        $(function() {
            $("#datepicker").datepicker({ minDate: -100, maxDate: "+1D" });
        });
        <%System.out.print("日期");%>
    </script>--%>
</head>
<body>
<s:debug/>
<div class="top">
    <a href="index.jsp">返回首页</a>
</div>
<%--<s:form action="regedit" method="post">
    <s:textfield name="username"  label="username" requiredLabel="true" requiredPosition="left" />
    <s:password name="pass" label="pass" errorPosition="bottom"/>
     <s:password name="repass" label="repass"/>
     <s:select name="sex" label="sex"  list="#{'男':'男', '女':'女'}" />
    <sj:datepicker name="birth" label="your birthday"
                   displayFormat="%{getText('format.date.input')}"
                   changeMonth="true" changeYear="true" />
    <s:textfield name="phone"  label="phone" />
    &lt;%&ndash;<s:textfield name="user.username" label="username"/>
    <sjr:ckeditor
            id="richtextEditor"
            name="echo"
            rows="10"
            cols="80"
            width="730"
            height="250"/>&ndash;%&gt;
    <s:submit/>
</s:form>--%>
<%--<h1>某某公司用户注册系统</h1>--%>
<div class="container">
    <h2>现在注册</h2>
    <s:actionerror/>
    <s:fielderror/>
    <s:form action="regedit" method="post" theme="simple">
        <div>
            <span>用户:</span>
            <s:textfield name="user.username" label="" cssClass="name"  requiredLabel="true"
                         requiredPosition="left" placeholder="请输入用户名"/>
            <div class="clear"></div>
        </div>
        <div>
            <span>密码:</span>
            <s:password name="user.pass" label="" cssClass="password"  requiredLabel="true"
                        errorPosition="bottom" placeholder="请输入密码"/>
            <div class="clear"></div>
        </div>
        <div>
            <span>确认密码:</span>
            <s:password name="repass" cssClass="password"  placeholder="请再次输入密码"/>
            <div class="clear"></div>
        </div>
        <div>
            <span>性别:</span>
            <s:select name="user.sex" list="#{'男':'男', '女':'女'}" id="select" cssClass=""/>
            <div class="clear"></div>
        </div>
        <div>
            <span>生日:</span>
            <sj:datepicker name="user.birth" id="birth" readonly="true"
                           displayFormat="%{getText('format.date.input')}"
                           showButtonPanel="true"  showOn="focus"
                           changeMonth="true" changeYear="true" cssClass=""
             minDate= "-1200M"  maxDate="+0D"/> <%--只读框，不用填写--%>
            <div class="clear"></div>
        </div>
        <div>
            <span>手机号:</span>
            <s:textfield name="user.phone" cssClass="name" id="phone" />
            <div class="clear"></div>
        </div>
        <div class="login-w3">
            <s:submit value="立即注册" cssClass="submit"/>
        </div>
        <div class="clear"></div>
    </s:form>
</div>
<div class="footer-w3l">
    <p> 某某公司用户注册系统</p>
</div>
</body>
</html>
