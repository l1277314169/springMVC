<html>
<head>
    <title>登录</title>
<#--    <style>.error{color:red;}</style>-->
</head>
<body>
<#--<div class="error">${error}</div>-->
<form action="/login/show" method="post">
    用户名：<input type="text" name="userName"><br/>
    密码：<input type="password" name="password"><br/>
    记住我：<input type="checkbox" name="rememberMe" />
    <input type="submit" value="登录12">
</form>
</body>
</html>