<%--
  Created by IntelliJ IDEA.
  User: j
  Date: 2024/3/20
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="Zhang.week4.UserData"></jsp:useBean>
<jsp:setProperty name="user" property="*"/>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
    <title>add user data(*^▽^*)</title>
</head>
<body>
<%
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost;databaseName=userdb";
        String username="sa";
        String password="Douli998";
        Connection conn=DriverManager.getConnection(url,username,password);
        String sql="insert into dbo.Table_1(Id,Username,Password,email,gender,birthday) values(?,?,?,?,?,?)";
        PreparedStatement ps=conn.prepareStatement(sql);
        ps.setInt(1,user.getId());
        ps.setString(2,user.getUsername());
        ps.setString(3,user.getPassword());
        ps.setString(4,user.getEmail());
        ps.setString(5,user.getGender());
        ps.setString(6,user.getBirthday());
        int row=ps.executeUpdate();
        if(row>0){
            out.print("成功添加了"+row+"条数据!");
        }
        ps.close();
        conn.close();
    }catch (Exception e){
        out.print("数据添加失败!");
        e.printStackTrace();
    }
%>
<br>
<a href="index.jsp">返回</a>
</body>
</html>
