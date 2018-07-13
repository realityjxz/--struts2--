<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>个人信息</title>
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
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
    <s:include value="header_stu.jsp"></s:include>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div id="sideNav" href="">
            <i class="fa fa-caret-right"></i>
        </div>

        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li>
                    <a class="active-menu" href="#"><i class="fa fa-sitemap"></i> 个人信息<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="stu_find.action">个人信息查询</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="stu_edit.action"><i class="fa fa-edit"></i> 修改密码 </a>
                </li>

                <li>
                    <a href="tcou_sno.action"><i class="fa fa-table"></i>课表查询</a>
                </li>

                <li>
                    <a href="#"><i class="fa fa-desktop"></i> 学生通讯录</a>
                </li>
                <li>
                    <a  href="index_stu.jsp"><i class="fa fa-dashboard"></i> 老师通讯录</a>
                </li>
                <li>
                    <a href="score_sno.action"><i class="fa fa-bar-chart-o"></i> 成绩查询</a>
                </li>

                <li>
                    <a href="#"><i class="fa fa-fw fa-file"></i> Empty Page</a>
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
                        info <small>student</small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-6">
                                <form role="form">
                                    <div class="form-group">
                                        <label>学号：</label>
                                        <input value="<s:property value="stu.Sno"/>" class="form-control"  type="text"  disabled="">
                                    </div>
                                    <div class="form-group">
                                        <label>姓名：</label>
                                        <input value="<s:property value="stu.Sname"/>" class="form-control"  type="text"  disabled="">
                                    </div>
                                    <div class="form-group">
                                        <label>性别：</label>
                                        <select name="tea.Tsex" id="disabledSelect" class="form-control" disabled="">
                                            <option><s:property value="stu.Ssex"/> </option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>生日：</label>
                                        <input vlaue="<s:property value="stu.Sbirth"/>" class="form-control"  type="text"  disabled="">
                                    </div>
                                    <div class="form-group">
                                    <label>手机号：</label>
                                    <input value="<s:property value="stu.Sphone"/>" class="form-control"  type="text"  disabled="">
                                </div>
                                    <div class="form-group">
                                        <label>所在班级：</label>
                                        <input value="<s:property value="stu.Sclass"/>" class="form-control"  type="text"  disabled="">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


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
