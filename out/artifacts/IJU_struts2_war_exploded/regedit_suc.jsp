<%--
  Created by IntelliJ IDEA.
  User: 张总
  Date: 2018/6/21
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <meta charset="utf-8">
    <title>注册成功</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>

        * {
            line-height: 1.7;
            margin: 0;
            box-sizing: border-box;
        }

        html {
            background-color: #f3f3f3;
            color: #888;
            display: table;
            font-family: Helvetica, "Helvetica Neue", Arial, sans-serif;
            height: 100%;
            width: 100%;
        }

        body {
            display: table-cell;
            vertical-align: middle;
            margin: 2em auto;
        }

        h1 {
            color: #555;
            font-size: 2em;
        }

        a {
            color: #06a;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }

        p, .p { margin: 10px 0 15px; }

        input, button {
            font-size: 16px;
            padding: 6px 10px;
            border: none;
            border-radius: 2px;
        }
        input {
            background-color: #f3f3f3;
            width: 60%;
        }
        button {
            min-width: 80px;
            background-color: #009a61;
            text-align: center;
            color: #fff;
            cursor: pointer;
        }
        button:hover,
        button:active {
            background-color: #008151;
        }

        .error { color: #d9534f; }
        .text-center { text-align: center; }

        .box {
            margin: 0 auto;
            padding: 40px;
            background-color: #fff;
            width: 540px;
        }

        .figure {
            float: right;
            line-height: 0;
        }
        .figure img {
            width: 300px;
            height: 200px;
        }

        .footer {
            margin: 15px 0 0;
            color: #999;
            text-transform: uppercase;
            font-size: 13px;
        }
        .footer a {
            color: #999;
        }

        @media only screen and (max-width: 480px) {

            .box {
                padding: 20px;
                width: 100%;
            }

            h1 {
                font-size: 1.5em;
                margin: 0 0 0.3em 0;
            }

            .figure {
                float: none;
            }

        }

        .clearfix:before,
        .clearfix:after {
            content: " ";
            display: table;
        }
        .clearfix:after {
            clear: both;
        }

    </style>
</head>
<body>
<div class="box">
    <div class="clearfix">
        <figure class="figure"><img src="image/clown.jpg" alt="小丑"></figure>

        <h1>成功注册！</h1>

        <div class="p">恭喜你<br/>
            username-session <s:property value="#session.username"/></div>

        <div class="p"><button type="button" onclick="window.location.href='login.jsp'">去登录</button></div>
    </div>
</div>
<div class="footer text-center">
    1024 &copy; <a href="https://segmentfault.com">SegmentFault</a>
</div>

<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-918487-8', 'auto');
    ga('send', 'pageview');

</script>

<script>
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?e23800c454aa573c0ccb16b52665ac26";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>


