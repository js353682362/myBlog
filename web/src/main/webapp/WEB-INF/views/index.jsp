<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/include/include_head.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="form-group">
                <label for="login_name">登录名：</label>
                <input class="form-control" id="login_name" type="email"/>
                <label for="login_password">密码：</label>
                <input class="form-control" id="login_password" type="password"/>
            </div>

            <button type="submit" id="loginButton" class="btn btn-default">登陆</button>
            <div class="page-header">
                <h1>
                    Example page header
                    <small>Subtext for header</small>
                </h1>
            </div>
            <div class="media">
                <a href="#" class="pull-left"><img src="v3/default7.jpg" class="media-object" alt=''/></a>
                <div class="media-body">
                    <h4 class="media-heading">
                        Nested media heading
                    </h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin
                    commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                    <div class="media">
                        <a href="#" class="pull-left"><img src="v3/default8.jpg" class="media-object" alt=''/></a>
                        <div class="media-body">
                            <h4 class="media-heading">
                                Nested media heading
                            </h4> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
                            sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                        </div>
                    </div>
                </div>
            </div>
            <div class="jumbotron">
                <h1>
                    Hello, world!
                </h1>
                <p>
                    This is a template for a simple marketing or informational website. It includes a large callout
                    called the hero unit and three supporting pieces of content. Use it as a starting point to create
                    something more unique.
                </p>
                <p>
                    <a class="btn btn-primary btn-large" href="#">Learn more</a>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="/WEB-INF/views/include/include_js.jsp" %>
<script>

    var LoginUtils = {

        init: function () {
            LoginUtils.bindEvent();
        },

        bindEvent: function () {
            $("#loginButton").click(LoginUtils.login);
        },

        login: function () {

            var loginName = $.trim($("login_name").val());

            var loginPassword = $.trim($("login_password").val());

            $.ajax({
                url: "${basePath}/webAuth/auth/login/get",
                type: "post",
                contentType: "application/json",
                dataType: "json",
                data : {
                    loginName : loginName,
                    loginPassword : loginPassword
                },
                success : function(response,textStatus){

                }
            })
        }
    };

    $(document).ready(function () {
        LoginUtils.init();
    })
</script>
</html>
