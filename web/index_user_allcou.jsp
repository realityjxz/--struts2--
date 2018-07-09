<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ch">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="左右结构项目，属于大人员的社交工具">
    <meta name="keywords" content="左右结构项目 社交 占座 ">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, cla-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <title>Bootstrap后台管理-课程</title>
    <link rel="shortcut icon" href="image/favicon.ico" type="image/x-icon">
</head>
<body>

<div id="wrap">
    <!-- 左侧菜单栏目块 -->
    <s:include value="side_user.jsp"></s:include>
    <%--右侧菜单栏--%>
    <div id="rightContent">
        <div role="tabpanel" class="tab-pane" id="cla">
            <div class="check-div form-inline">
                <div class="col-xs-3">
                    <button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addUser">添加学生 </button>
                </div>
                <div class="col-xs-4">
                    <input type="text" class="form-control input-sm" placeholder="输入文字搜索">
                    <button class="btn btn-white btn-xs ">查 询 </button>
                </div>
                <div class="col-lg-3 col-lg-offset-2 col-xs-4" style=" padding-right: 40px;text-align: right;">
                    <label for="paixu">排序:&nbsp;</label>
                    <select class=" form-control">
                        <option>地区</option>
                        <option>班期</option>
                        <option>性别</option>
                        <option>年龄</option>
                        <option>份数</option>
                    </select>
                </div>
            </div>
            <div class="data-div">
                <table>
                    <thead class="row tableHeader">
                    <div class="row">
                        <div class="col-xs-2 "> 课程号</div>
                        <div class="col-xs-2 "> 课程名</div>
                        <div class="col-xs-3 "> 学期</div>
                        <div class="col-xs-1 "> 学分</div>
                        <div class="col-xs-1 "> 修改</div>
                        <div class="col-xs-1 "> 删除</div>
                    </div>
                    </thead>

                    <tbody class="tablebody">
                    <s:iterator value="cousByObj" var="cou">
                        <div class="row">
                            <div class="col-xs-2"><s:property value="#cou.Cno"/></div>
                            <div class="col-xs-2"><s:property value="#cou.Cname"/></div>
                            <div class="col-xs-3"><s:property value="#cou.Cterm"/></div>
                            <div class="col-xs-1"><s:property value="#cou.Credit"/></div>
                            <div class="col-xs-1"><s:url var="editUrl" action="cou_edit">
                                <s:param name="cou.cno" value="#cou.Cno"/>
                            </s:url>
                                <a href="${editUrl}">edit</a></div>
                            <div class="col-xs-1">
                                <s:url var="delUrl" action="cou_del">
                                    <s:param name="cou.cno" value="#cou.Cno"/>
                                </s:url>
                                <a href="${delUrl}" onClick="return readyDel(<s:property
                                        value='#cou.Cno'/>);">del</a></div>
                        </div>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
            <!--页码块-->

            <!--弹出添加用户窗口-->
            <div class="modal fade" id="addUser" role="dialog" aria-labelledby="gridSystemModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="gridSystemModalLabel">添加用户</h4>
                        </div>
                        <div class="modal-body">
                            <div class="container-fluid">
                                <form class="form-horizontal">
                                    <div class="form-group ">
                                        <label for="sName" class="col-xs-3 control-label">用户名：</label>
                                        <div class="col-xs-8 ">
                                            <input type="email" class="form-control input-sm duiqi" id="sName" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sLink" class="col-xs-3 control-label">真实姓名：</label>
                                        <div class="col-xs-8 ">
                                            <input type="" class="form-control input-sm duiqi" id="sLink" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sOrd" class="col-xs-3 control-label">电子邮箱：</label>
                                        <div class="col-xs-8">
                                            <input type="" class="form-control input-sm duiqi" id="sOrd" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sKnot" class="col-xs-3 control-label">电话：</label>
                                        <div class="col-xs-8">
                                            <input type="" class="form-control input-sm duiqi" id="sKnot" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sKnot" class="col-xs-3 control-label">地区：</label>
                                        <div class="col-xs-8">
                                            <select class=" form-control select-duiqi">
                                                <option value="">国际关系地区</option>
                                                <option value="">北京大学</option>
                                                <option value="">天津大学</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sKnot" class="col-xs-3 control-label">权限：</label>
                                        <div class="col-xs-8">
                                            <select class=" form-control select-duiqi">
                                                <option value="">管理员</option>
                                                <option value="">普通用户</option>
                                                <option value="">游客</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="situation" class="col-xs-3 control-label">状态：</label>
                                        <div class="col-xs-8">
                                            <label class="control-label" for="anniu">
                                                <input type="radio" name="situation" id="normal">正常</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <label class="control-label" for="meun">
                                                <input type="radio" name="situation" id="forbid"> 禁用</label>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                            <button type="button" class="btn btn-xs btn-green">保 存</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->

            <!--弹出修改用户窗口-->
            <div class="modal fade" id="reviseUser" role="dialog" aria-labelledby="gridSystemModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="gridSystemModalLabel">修改用户</h4>
                        </div>
                        <div class="modal-body">
                            <div class="container-fluid">
                                <form class="form-horizontal">
                                    <div class="form-group ">
                                        <label for="sName" class="col-xs-3 control-label">用户名：</label>
                                        <div class="col-xs-8 ">
                                            <input type="email" class="form-control input-sm duiqi" id="sName" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sLink" class="col-xs-3 control-label">真实姓名：</label>
                                        <div class="col-xs-8 ">
                                            <input type="" class="form-control input-sm duiqi" id="sLink" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sOrd" class="col-xs-3 control-label">电子邮箱：</label>
                                        <div class="col-xs-8">
                                            <input type="" class="form-control input-sm duiqi" id="sOrd" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sKnot" class="col-xs-3 control-label">电话：</label>
                                        <div class="col-xs-8">
                                            <input type="" class="form-control input-sm duiqi" id="sKnot" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sKnot" class="col-xs-3 control-label">地区：</label>
                                        <div class="col-xs-8">
                                            <input type="" class="form-control input-sm duiqi" id="sKnot" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sKnot" class="col-xs-3 control-label">权限：</label>
                                        <div class="col-xs-8">
                                            <input type="" class="form-control input-sm duiqi" id="sKnot" placeholder="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="situation" class="col-xs-3 control-label">状态：</label>
                                        <div class="col-xs-8">
                                            <label class="control-label" for="anniu">
                                                <input type="radio" name="situation" id="normal">正常</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <label class="control-label" for="meun">
                                                <input type="radio" name="situation" id="forbid"> 禁用</label>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                            <button type="button" class="btn btn-xs btn-green">保 存</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->

            <!--弹出删除用户警告窗口-->
            <div class="modal fade" id="deleteUser" role="dialog" aria-labelledby="gridSystemModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
                        </div>
                        <div class="modal-body">
                            <div class="container-fluid">
                                确定要删除该用户？删除后不可恢复！
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                            <button type="button" class="btn  btn-xs btn-danger">保 存</button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
            </div>
            <!-- /.modal -->
        </div>
    </div>
</div>
<script>
    function readyDel(id) {
        return confirm("是否真的删除学号为" + id + "的用户？");
    }
</script>


</body>
</html>
