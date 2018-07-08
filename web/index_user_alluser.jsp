<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="ch">

<head>
    <meta charset="utf-8">
    <base href="<%=basePath%>">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="左右结构项目，属于大人员的社交工具">
    <meta name="keywords" content="左右结构项目 社交  ">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <sj:head compressed="true" jquerytheme="redmond" ajaxcache="false"/>
    <title>Bootstrap后台管理-管理员</title>

<s:head/>
<sj:head/>
<body>
<div id="wrap">
    <!-- 左侧菜单栏目块 -->
    <s:include value="side_user.jsp"></s:include>
    <%--右侧菜单栏--%>
    <div id="rightContent">
        <div role="tabpanel" class="tab-pane" id="user">
            <div class="check-div form-inline">
                <div class="col-xs-3">
                    <button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addUser">添加管理员</button>
                    <a href="regedit.jsp">注册</a>
                </div>
                <div class="col-xs-4">
                    <input type="text" class="form-control input-sm" placeholder="输入文字搜索">
                    <button class="btn btn-white btn-xs ">查 询</button>
                </div>
                <div class="col-lg-3 col-lg-offset-2 col-xs-4" style=" padding-right: 40px;text-align: right;">
                    <label>排序:&nbsp;</label>
                    <select class=" form-control">
                        <option>地区</option>
                        <option>班期</option>
                        <option>性别</option>
                        <option>年龄</option>
                    </select>
                </div>
            </div>
            <div class="data-div">
                <table>
                    <thead class="row tableHeader">
                    <div class="row">
                        <div class="col-xs-1 "> ID</div>
                        <div class="col-xs-2 "> 用户名</div>
                        <div class="col-xs-2 "> 密码</div>
                        <div class="col-xs-1 ">性别</div>
                        <div class="col-xs-2 ">手机号</div>
                        <div class="col-xs-2 ">出生年月</div>
                        <div class="col-xs-1 "> 修改</div>
                        <div class="col-xs-1 "> 删除</div>
                    </div>
                    </thead>

                    <tbody class="tablebody">
                    <s:iterator value="usersByObj" var="user">
                        <div class="row">
                            <div class="col-xs-1"><s:property value="#user.id"/></div>
                            <div class="col-xs-2"><s:property value="#user.username"/></div>
                            <div class="col-xs-2"><s:property value="#user.pass"/></div>
                            <div class="col-xs-1"><s:property value="#user.sex"/></div>
                            <div class="col-xs-2"><s:property value="#user.phone"/></div>
                            <div class="col-xs-2"><s:property value="#user.birth"/></div>
                            <div class="col-xs-1">
                                <s:url var="editUrl" action="user_edit">
                                    <s:param name="user.id" value="#user.id"/>
                                </s:url>
                                <a href="${editUrl}"><button class="btn btn-success btn-xs">
                                    修改
                                    </button></a>
                            </div>
                            <div class="col-xs-1">
                                <s:url var="delUrl" action="user_del">
                                    <s:param name="user.id" value="#user.id"/>
                                </s:url>
                                <a href="${delUrl}" onClick="return readyDel(<s:property
                                        value='#tea.tno'/>);">
                                <button class="btn btn-danger btn-xs">
                                        删除
                                    </button></a>
                            </div>

                            <%--<div class="col-xs-1"><s:url var="editUrl" action="user_edit">
                                <s:param name="user.id" value="#user.id"/>
                            </s:url>
                                <a href="${editUrl}">edit</a>
                                <s:url var="delUrl" action="user_del">
                                    <s:param name="user.id" value="#user.id"/>
                                </s:url>
                                <a href="${delUrl}" onClick="return readyDel(<s:property
                                        value='#user.id'/>);">del</a></div>--%>
                        </div>
                    </s:iterator>
                    </tbody>
                </table>
            </div>


            <!--弹出添加用户窗口-->
            <div class="modal fade" id="addUser" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                    aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="gridSystemModalLabel">添加管理员</h4>
                        </div>
                        <div class="modal-body">
                            <div class="container-fluid">
                                <s:form cssClass="form-horizontal" action="regedit" method="post" theme="simple">
                                    <div class="form-group ">
                                        <label class="col-xs-3 control-label">用户名：</label>
                                        <div class="col-xs-8 ">
                                            <s:textfield name="user.username" label=""
                                                         cssClass="form-control input-sm duiqi" requiredLabel="true"
                                                         requiredPosition="right" placeholder="请输入用户名"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">密码：</label>
                                        <div class="col-xs-8 ">
                                            <s:password name="user.pass" label="" cssClass="form-control input-sm duiqi"
                                                        requiredLabel="true"
                                                        errorPosition="bottom" placeholder="请输入密码"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">确认密码：</label>
                                        <div class="col-xs-8">
                                            <s:password name="repass" cssClass="form-control input-sm duiqi"
                                                        placeholder="请再次输入密码"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">性别：</label>
                                        <div class="col-xs-8">
                                            <s:select name="user.sex" list="#{'男':'男', '女':'女'}"
                                                      cssClass="form-control input-sm duiqi"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">电话：</label>
                                        <div class="col-xs-8">
                                            <s:textfield name="user.phone" cssClass="form-control input-sm duiqi"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-xs-3 control-label">出生日期：</label>
                                        <div class="col-xs-8">
                                            <sj:datepicker name="user.birth" readonly="true"
                                                           displayFormat="%{getText('format.date.input')}"
                                                           showButtonPanel="true"  showOn="both"
                                                           changeMonth="true" changeYear="true" cssClass="form-control input-sm duiqi"
                                                           minDate= "-1200M"  maxDate="+0D"/><%--只读框，不用填写--%>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                    <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                                    <s:submit type="button" cssClass="btn btn-xs btn-green">保 存</s:submit>
                                    </div>
                                </s:form>
                            </div>
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
        return confirm("是否真的删除编号为" + id + "的用户？");
    }
</script>
</body>
</html>
