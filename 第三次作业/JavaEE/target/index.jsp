<%@ page import="java.util.List" %>
<%@ page import="model.Homework" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/8
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Homework Management System</title>
    <style>
      th{
        border: 1px solid;
      }
    </style>
  </head>
  <body>

    <%
      int sign = (int) request.getAttribute("sign");
      if(sign == 0){
    %>
    <form method="post">
      <table align="center" width="1000">
        <tr align="center" bgcolor="#7fffd4" height="50">
          <th>作业编号</th>
          <th>作业标题</th>
          <th>作业内容</th>
          <th>作业发布时间</th>
          <th>提交</th>
        </tr>
      <%
          List<Homework> list = (List<Homework>)request.getAttribute("list");
          for(Homework homework :list){
      %>
        <tr align="center" height="200" >
          <th><input style="width:200px; height:180px; border:none; font-size: 20px; text-align: center;" readonly="readonly"
                     type="text" align="center" value="<%=homework.getId()%>" name="homework_id"></th>
          <th><input style="width:200px; height:180px; border:none; font-size: 20px; text-align: center;" readonly="readonly"
                     type="text" align="center" value="<%=homework.getTitle()%>" name="homework_title+<%=homework.getId()%>"></th>
          <th><input type="text" name="content+<%=homework.getId()%>" placeholder="请输入作业内容" style="width:200px; height:180px;" ></th>
          <th><%=homework.getTime()%></th>
          <th><input type="submit" value="submit <%=homework.getId()%>" name="submit" style="width:150px; height:40px; font-size: 20px;"  ></th>
        </tr>
      <%
          }
      %>
      </table>
    </form>
    <%
      }
    %>
  </body>
</html>
