<%--
  Created by IntelliJ IDEA.
  User: 张总
  Date: 2018/6/20
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>软件学院管理系统用户登录</title>
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
    <link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/jQuery1.7.js"></script>
    <%--<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>--%>
    <%--<script type="text/javascript" src="js/jquery1.42.min.js"></script>--%>
    <script type="text/javascript">
        $(document).ready(function(){
            var $tab_li = $('#tab ul li');
            $tab_li.hover(function(){
                $(this).addClass('selected').siblings().removeClass('selected');
                var index = $tab_li.index(this);
                $('div.tab_box > div').eq(index).show().siblings().hide();
            });
        });
    </script>

    <script type="text/javascript">
        $(function(){
            $(".screenbg ul li").each(function(){
                $(this).css("opacity","0");
            });
            $(".screenbg ul li:first").css("opacity","1");
            var index = 0;
            var t;
            var li = $(".screenbg ul li");
            var number = li.size();
            function change(index){
                li.css("visibility","visible");
                li.eq(index).siblings().animate({opacity:0},3000);
                li.eq(index).animate({opacity:1},3000);
            }
            function show(){
                index = index + 1;
                if(index<=number-1){
                    change(index);
                }else{
                    index = 0;
                    change(index);
                }
            }
            t = setInterval(show,8000);
            //根据窗口宽度生成图片宽度
            /* var width = $(window).width();
            $(".screenbg ul img").css("width",width+"px"); */
        });
    </script>
</head>

<body>
<div id="tab">
    <ul class="tab_menu">
        <li class="selected">学生登录</li>
        <li>导师登录</li>
        <li>教务登录</li>
    </ul>
    <div class="tab_box">
        <!-- 学生登录开始 -->
        <div>
            <br>

        <form action="" method="post" >
                <div>
                    <label>学&nbsp;&nbsp;&nbsp;号：</label>
                    <input type="text" id="stu_username_hide" name="user.username" placeholder="输入学号" />

                </div>
                <div >
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="stu_password_hide" name="user.pass" placeholder="输入密码" />
                </div>
                <div id="code">
                    <label>验证码：</label>
                    <input type="text" id="stu_code_hide" name="code"  placeholder="输入验证码" nullmsg="验证码不能为空！" datatype="*4-4" errormsg="验证码有4位数！" sucmsg="验证码验证通过！"/>
                    <img src="image/captcha.jpg" title="点击更换" alt="验证码占位图"/> </div>
                <div>
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div>
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 学生登录结束-->
        <!-- 导师登录开始-->
        <div class="hide">

            <form action="" method="post" >
                <div id="username">
                    <label>教工号：</label>
                    <input type="text" id="tea_username_hide" name="username" placeholder="输入教工号" />

                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="tea_password_hide" name="password" placeholder="输入密码" />
                </div>
                <div id="code">
                    <label>验证码：</label>
                    <input type="text" id="tea_code_hide" name="code"  placeholder="输入验证码"/>
                    <img src="image/captcha.jpg" title="点击更换" alt="验证码占位图"/> </div>
                <div id="remember">
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 导师登录结束-->
        <!-- 教务登录开始-->
        <div class="hide">
            <s:actionerror cssStyle="color:red;font-weight: bold"/>
            <s:fielderror cssStyle="color:darkred;font-weight: bold" />
            <form action="checkLogin" method="post"">
                <div id="username">
                    <label>教务号：</label>
                    <input type="text" id="sec_username_hide" name="user.username" placeholder="输入教务号" />

                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" id="sec_password_hide" name="user.pass" placeholder="输入密码"  />
                </div>
                <div id="code">
                    <label>验证码：</label>
                    <input type="text" id="sec_code_hide" name="code"  placeholder="输入验证码"/>
                    <img src="image/captcha.jpg" title="点击更换" alt="验证码占位图"/> </div>
                <div id="remember">
                    <input type="checkbox" name="remember">
                    <label>记住密码</label>
                </div>
                <div id="login">
                    <button type="submit">登录</button>
                </div>
            </form>
        </div>
        <!-- 教务登录结束-->
    </div>
</div>
<div class="bottom">©2018 Leting <a href="javascript:;" target="_blank">关于</a> <span>京ICP证030173号</span>  More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></div>
<div class="screenbg">
    <ul>
        <li><a href="javascript:;"><img src="image/0.jpg" alt="0"/></a></li>
        <li><a href="javascript:;"><img src="image/1.jpg" alt="1"/></a></li>
        <li><a href="javascript:;"><img src="image/2.jpg" alt="2"/></a></li>
    </ul>
</div>


</body>
</html>
