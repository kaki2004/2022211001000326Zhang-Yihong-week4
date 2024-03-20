package Zhang.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.sql.*;
import java.util.*;

@WebServlet(name = "FindServlet", value = "/FindServlet")
public class FIndServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost;databaseName=userdb";
            String username="sa";
            String password="Douli998";
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement stmt=conn.createStatement();
            String sql="select * from dbo.Table_1";
            ResultSet rs=stmt.executeQuery(sql);
            List<UserData> list=new ArrayList<>();
            while(rs.next()){
                UserData user=new UserData();
                user.setId(rs.getInt("Id"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getString("birthday"));
                list.add(user);
            }
            request.setAttribute("list",list);
            rs.close();
            stmt.close();
            conn.close();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("userData.jsp").forward(request,response);
    }
}
