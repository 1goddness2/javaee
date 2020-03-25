<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2020/3/8
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        .container{
            text-align: center;
        }
        #form{
            margin: 200px auto;
        }
        .account{
            width: 400px;
            height: 40px;
        }
        .password{
            width: 400px;
            height: 40px;
            margin-top: 20px;
        }
        .submit{
            height: 40px;
            width: 400px;
            margin-top: 20px;
            font-size: 15px;
            font-family: "宋体";
        }
    </style>
</head>
<body>
    <div class="container">
        <form method="post" id="form">
            <input type="text" name="account" class="account" placeholder="账号"><br>
            <input type="password" name="password" class="password" placeholder="密码"><br>
            <input type="submit" value="提交" class="submit">
        </form>
    </div>
</body>
</html>
