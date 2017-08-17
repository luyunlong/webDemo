<%--
  Created by IntelliJ IDEA.
  User: luyunlong
  Date: 2017/8/16
  Time: 下午1:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>员工列表</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>

    <!--引入jquery-->
    <script src="${APP_PATH}/static/js/jquery-3.2.1.min.js"></script>
    <!--引入样式-->
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
    <div class="container">

        <!--  标题  -->
        <div class="row">
            <h1>WebDemo</h1>
        </div>
        <!--   操作按钮 -->
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button class="btn btn-primary">新增</button>
                <button class="btn btn-danger">删除</button>
            </div>
        </div>
        
        <!--  表格  -->
        <div class="row">
            <table class="table table-hover">

                <tr>
                    <th>#</th>
                    <th>lastName</th>
                    <th>email</th>
                    <th>gender</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>

                <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>

                        <th>${emp.empId}</th>
                        <th>${emp.empName}</th>
                        <th>${emp.email}</th>
                        <th>${emp.gender == "F" ? "男" : "女"}</th>
                        <th>${emp.department.deptName}</th>
                        <th>
                            <button class="btn btn-primary btn-sm">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                编辑
                            </button>
                            <button class="btn btn-danger btn-sm">
                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                删除
                            </button>
                        </th>

                     </tr>
                </c:forEach>

            </table>

        </div>
        <!--  分页显示  -->
        <div class="row">
            <!--  分页信息  -->
            <div class="col-md-6">
                当前页数：${pageInfo.pageNum} 总页数：${pageInfo.pages} 总条数：${pageInfo.total}
            </div>
            <!--  分页跳转  -->
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="${APP_PATH}/emps?pn=1">首页</a>
                        </li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_numb">
                            <c:if test="${pageInfo.pageNum == page_numb}" >
                                <li class="active"><a href="${APP_PATH}/emps?pn=${pageInfo.pageNum}">${page_numb}</a></li>
                            </c:if>
                            <c:if test="${pageInfo.pageNum != page_numb}">
                                <li><a href="${APP_PATH}/emps?pn=${page_numb}">${page_numb}</a></li>
                            </c:if>
                        </c:forEach>


                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="${APP_PATH}/emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <li>
                            <a href="${APP_PATH}/emps?pn=${pageInfo.pages}">尾页</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>

    </div>


</body>
</html>
