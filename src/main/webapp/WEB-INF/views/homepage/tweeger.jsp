<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aix
  Date: 2018-11-22
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweeger</title>
</head>
<body>
<c:if test="${loggedUser != null}">
    <p>Logged in as: ${loggedUser.username}</p>
</c:if>
<h1> Hello in Tweeger!</h1>
<div>
    <c:if test="${loggedUser == null}">
        <a href="tweeger/signup">Log in here!</a><br>
        <a href="tweeger/register">No account yet? register!</a><br>
    </c:if>

    <c:if test="${loggedUser != null}">
        <p> ALL TWEETS HERE INCOMING</p>
    </c:if>


</div>
</body>
</html>
