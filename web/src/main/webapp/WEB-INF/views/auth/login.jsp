<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/include/include_head.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登陆</title>
    <link rel="stylesheet" href="${basePath}/static/css/login/style.css"/>
    <link href='http://fonts.googleapis.com/css?family=Oleo+Script' rel='stylesheet' type='text/css'>
    <style>
        body{
            background-image:url("${basePath}/static/images/login/bg.png");
            font-family: 'Oleo Script', cursive;
        }
    </style>
</head>
<body>
<div class="lg-container">
    <h1>登陆</h1>
    <form id="lg-form" name="lg-form" method="post">

        <div>
            <label for="username">账号:</label>
            <input type="text" name="username" id="username" placeholder="请输入账号"/>
        </div>

        <div>
            <label for="password">密码:</label>
            <input type="password" name="password" id="password" placeholder="请输入密码"/>
        </div>

        <div>
            <button type="submit" id="login">Login</button>
        </div>
    </form>
    <div id="message"></div>
</div>
</body>
<%@include file="/WEB-INF/views/include/include_js.jsp" %>
<script type="text/javascript">

    var loginUtils = {
        init : function(){

        },

        bindEvent : function(){
            $("#login").click(loginUtils.login());
        },

        login : function(){
            var action = $("#lg-form").attr('action');
            var form_data = {
                username: $("#username").val(),
                password: $("#password").val(),
            };

            $.ajax({
                url : "${basePath}/",
                type: "POST",
                url: action,
                data: form_data,
                success: function (response) {
                    if (response == "success")
                        $("#lg-form").slideUp('slow', function () {
                            $("#message").html('<p class="success">You have logged in successfully!</p><p>Redirecting....</p>');
                        });
                    else
                        $("#message").html('<p class="error">ERROR: Invalid username and/or password.</p>');
                }
            });

        }
    };
    $(document).ready(function () {
    });
</script>
</html>
