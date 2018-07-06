<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">

    <link href="assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet"/>
    <!-- Morris Chart Styles-->

    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet"/>
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>
    <!-- TABLE STYLES-->
    <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet"/>


    <title>用户信息表</title>
</head>

<body>
<div id="wrapper">
    <s:include value="header_stu.jsp"></s:include>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a href="index.html"><i class="fa fa-dashboard"></i> Dashboard</a>
                </li>
                <li>
                    <a href="ui-elements.html"><i class="fa fa-desktop"></i> UI Elements</a>
                </li>
                <li>
                    <a href="chart.html"><i class="fa fa-bar-chart-o"></i> Charts</a>
                </li>
                <li>
                    <a href="tab-panel.html"><i class="fa fa-qrcode"></i> Tabs & Panels</a>
                </li>

                <li>
                    <a href="table.html" class="active-menu"><i class="fa fa-table"></i> Responsive Tables</a>
                </li>
                <li>
                    <a href="form.html"><i class="fa fa-edit"></i> Forms </a>
                </li>


                <li>
                    <a href="#"><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="#">Second Level Link</a>
                        </li>
                        <li>
                            <a href="#">Second Level Link</a>
                        </li>
                        <li>
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

                        </li>
                    </ul>
                </li>
                <li>
                    <a href="empty.html"><i class="fa fa-fw fa-file"></i> Empty Page</a>
                </li>
            </ul>

        </div>

    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper" >
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        Tables Page <small>Responsive tables</small>
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
                                        <th>ID</th>
                                        <th width="130">用户名</th>
                                        <th width="130">密码</th>
                                        <th width="130">性别</th>
                                        <th width="130">手机号</th>
                                        <th width="130">出生年月</th>
                                        <th width="130">修改</th>
                                        <th width="130">删除</th>
                                    </tr>
                                    </thead>

                                    <tbody>
                                    <s:iterator value="usersByObj" var="user">
                                        <tr>
                                            <td><s:property value="#user.id"/></td>
                                            <td><s:property value="#user.username"/></td>
                                            <td><s:property value="#user.pass"/></td>
                                            <td><s:property value="#user.sex"/></td>
                                            <td><s:property value="#user.phone"/></td>
                                            <td><s:property value="#user.birth"/></td>
                                            <td><s:url var="editUrl" action="user_edit">
                                                <s:param name="user.id" value="#user.id"/>
                                            </s:url>
                                                <a href="${editUrl}">edit</a></td>
                                            <td>
                                                <s:url var="delUrl" action="user_del">
                                                    <s:param name="user.id" value="#user.id"/>
                                                </s:url>
                                                <a href="${delUrl}" onClick="return readyDel(<s:property
                                                        value='#user.id'/>);">del</a></td>
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
    </div>
    <!-- /. PAGE INNER  -->
</div>

<script>
    function readyDel(id) {
        return confirm("是否真的删除学号为" + id + "的用户？");
    }
</script>



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
    $(document).ready(function () {
        $('#dataTables-example').dataTable();
    });
</script>
<!-- Custom Js -->
<script src="assets/js/custom-scripts.js"></script>

</body>
</html>