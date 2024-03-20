<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="/2022211001000326ZhangYihong_week4_war_exploded/jdbc">init parameters from web.xml</a><br/>
<a href="/2022211001000326ZhangYihong_week4_war_exploded/jdbcWebServlet">init parameters from WebServlet</a><br/>
<form action="/2022211001000326ZhangYihong_week4_war_exploded/addData.jsp" method="post" onsubmit=" return check(this)">
    <ul>
        <li>id:<input type="text" name="Id"/></li>
        <li>username:<input type="text" name="Username"/></li>
        <li>password:<input type="text" name="Password"/></li>
        <li>email:<input type="text" name="email"/></li>
        <li>gender:<input type="text" name="gender"/></li>
        <li>birthday:<input type="text" name="birthday"/></li>
        <li><input type="submit" value="add"></li>
    </ul>
</form>
<a href="/2022211001000326ZhangYihong_week4_war_exploded/userData.jsp">Check data from table</a><br/>
</body>
</html>