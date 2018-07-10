<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>学生成绩</title>
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->

    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <!-- TABLE STYLES-->
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
    <s:include value="header_tea.jsp"></s:include>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div id="sideNav" href="">
            <i class="fa fa-caret-right"></i>
        </div>

        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a  href="#"><i class="fa fa-sitemap"></i> 个人信息<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="tea_find.action">个人信息查询</a>
                        </li>
                        <li>
                            <a href="index_tea_editinfo.jsp">修改密码</a>
                        </li>
                        <%--<li>
                            <a href="#">Second Level Link<span class="fa arrow"></span></a>
                            <ul class="nav nav-third-level">
                                <li>
                                    <a href="#">Third Level Link</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Link</a>
                                </li>
                                <li>
                                    <a href="#">Third Level Link</a>
                                </li>

                            </ul>

                        </li>--%>
                    </ul>
                </li>
                <li>
                    <a href="score_input.action"><i class="fa fa-edit"></i>学生成绩录入</a>
                </li>

                <li>
                    <a class="active-menu" href="score_list.action"><i class="fa fa-table"></i> 学生成绩查询</a>
                </li>
                <li>
                    <a href="index_tea_tcou.jsp"><i class="fa fa-bar-chart-o"></i> 授课表查询</a>
                </li>
                <li>
                    <a  href="table.html"><i class="fa fa-dashboard"></i> 图表展示</a>
                </li>
                <li>
                    <a href="tab-panel.html"><i class="fa fa-qrcode"></i> Tabs & Panels</a>
                </li>
                <li>
                    <a href="form.html"><i class="fa fa-desktop"></i> Forms </a>
                </li>
                <li>
                    <a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
                </li>
            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        成绩 <small>所有学生</small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->

            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Advanced Tables
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>学号</th>
                                        <th>学生姓名</th>
                                        <th>课程号</th>
                                        <th>课程名</th>
                                        <th>班级</th>
                                        <th>成绩</th>
                                        <th>修改</th>
                                        <th>删除</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <s:iterator value="scoresByObj" var="score">
                                        <tr>
                                            <td><s:property value="#score.Sno"/></td>
                                            <td><s:property value="#score.Sname"/></td>
                                            <td><s:property value="#score.Cno"/></td>
                                            <td><s:property value="#score.Cname"/></td>
                                            <td><s:property value="#score.Sclass"/></td>
                                            <s:if test="#score.Score>=60">
                                                <td><s:property value="#score.Score"/></td>
                                            </s:if>
                                            <s:else>
                                                <td style="background-color: #00a1cb"><s:property value="#score.Score"/></td>
                                            </s:else>
                                            <td><s:url var="editUrl" action="score_edit">
                                                <s:param name="score.score" value="#score.Score"/>
                                            </s:url>
                                                <a href="${editUrl}">edit</a></td>
                                            <td>
                                                <s:url var="delUrl" action="score_del">
                                                    <s:param name="score.score" value="#score.score"/>
                                                </s:url>
                                                <a href="${delUrl}" onClick="return readyDel(<s:property
                                                        value='#score.score'/>);">del</a></td>
                                        </tr>
                                    </s:iterator>
                                    </tbody>
                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
            <!-- /. ROW  -->
        </div>
        <!-- /. PAGE INNER  -->
    </div>
</div>
<!-- /. PAGE WRAPPER  -->
<!-- /. WRAPPER  -->
<!-- JS Scripts-->
<!-- jQuery Js -->
<script src="assets/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="assets/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="assets/js/dataTables/jquery.dataTables.js"></script>
<script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
<script>
    function readyDel(id) {
        return confirm("是否真的删除成绩为" + id + "的用户？");
    }
</script>
<script>
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
    $("#sideNav").click(function(){
        if($(this).hasClass('closed')){
            $('.navbar-side').animate({left: '0px'});
            $(this).removeClass('closed');
            $('#page-wrapper').animate({'margin-left' : '260px'});

        }
        else{
            $(this).addClass('closed');
            $('.navbar-side').animate({left: '-260px'});
            $('#page-wrapper').animate({'margin-left' : '0px'});
        }
    });
</script>
<!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>


</body>
</html>
