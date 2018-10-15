<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>主页面</title>
    <link href="/webjars/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"/>
    <script src="/webjars/jquery/3.3.1/jquery.js"></script>
    <script src="/webjars/bootstrap/3.3.5/js/bootstrap.js"></script>
</head>
<body>
    <div>
        <#include "common/left.ftl">
        <#--<@s.message code="tip"/> 也是可以输出的-->
        <div id="right">
            <a href="emp">添加员工</a>
            <table border="1">
                <tr>
                    <th>编号</th>
                    <th>用户名</th>
                    <th>入职日期</th>
                    <th>薪水</th>
                    <th>操作</th>
                </tr>
                <!--??变量是否存在，存在了再进行后续操作，返回值boolean-->
                <#if emps??>
                    <#list emps as emp>
                     <tr>
                         <!--!确保emp.ID为null时freemarker不报错，是freemarker的空值处理方法,
                         ()表示考虑了两者都可能为空的情况-->
                         <td>${(emp.ID)!}</td>
                         <td>${emp.emp_name!}</td>
                         <td>${emp.join_date!}</td>
                         <td>${emp.salary!}</td>
                         <td>
                             <a data-href="/emp/${(emp.ID)!}" href="javascript:void(0)" class="delBtn">删除</a>
                             <a  data-id="/emp/${(emp.ID)!}" href="javascript:void(0)" class="updateBtn">修改</a>
                         </td>
                     </tr>
                    </#list>
                </#if>
            </table>
        </div>
        <!--支持restful风格的form,method必须为post,_method的值不区分大小写-->
        <form method="post" id="restfulForm">
            <input type="hidden" name="_method" value="delete">
        </form>
        <script>
            $("#right").on("click",".delBtn",function () {
               $("#restfulForm").prop("action",$(this).attr("data-href")).submit();
            });
            $("#right").on("click",".updateBtn",function () {
                $.ajax({
                    type:"get",
                    url:$(this).attr("data-id"),
                    success:function(data){
                        $("#editModal").find("input[name=id]").val(data.ID);
                        $("#editModal").find("input[name=emp_name]").val(data.emp_name);
                        $("#editModal").find("input[name=join_date]").val(data.join_date);
                        $("#editModal").find("input[name=salary]").val(data.salary);
                        $("#editModal").modal("show");
                    }
                });
            });
        </script>
<!--编辑模态框-->
        <div class="modal fade" data-backdrop="static" data-keyboard="false" tabindex="-1" id="editModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" ><span>&times;</span></button>
                        <h4 class="modal-title">编辑员工</h4>
                    </div>
                    <div class="modal-body">
                        <form action="/emp" class="form-horizontal" id="editForm" method="post">
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-3 control-label">编号</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control input-sm" name="id" >
                                    <input type="hidden" name="_method" value="PUT">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-3 control-label">姓名</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control input-sm" name="emp_name" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-3 control-label">入职日期</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control input-sm" name="join_date" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword3" class="col-sm-3 control-label">薪水</label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control input-sm" name="salary" >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-3 col-sm-6">
                                    <input type="button" class="btn btn-default" style="margin-left:40px" data-dismiss="modal"  value="取消">
                                    <input type="submit" id="btnEdit" class="btn btn-primary" style="margin-left:40px" value="确认">
                                </div>
                            </div>
                        </form>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</body>
</html>