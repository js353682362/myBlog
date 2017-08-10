<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    request.setAttribute("basePath", basePath);
%>

<link href="${basePath}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${basePath}/static/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
