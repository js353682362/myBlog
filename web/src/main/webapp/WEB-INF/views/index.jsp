<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
scheme : <%=request.getScheme() %><br/>
serverName : <%=request.getServerName() %><br/>
serverPort : <%=request.getServerPort() %><br/>
contextPath :  <%=request.getContextPath()%>
</body>
</html>
