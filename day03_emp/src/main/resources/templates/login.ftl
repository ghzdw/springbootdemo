<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>用户管理登录</title>
    <script src="/webjars/jquery/3.3.1/jquery.js"></script>
</head>
<body>
<#import "common/spring.ftl" as s>
<h1><@s.message code="tip"/></h1>
<form action="login" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="pwd"></td>
        </tr>
        <tr>
            <td><a href="/index.htm?lang=zh_CN">中文</a>
                <a href="/index.htm?lang=en_US">英文</a>
            </td>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>