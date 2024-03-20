package Zhang.week4;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/jdbcWebServlet"},
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost;databaseNmae=userdb;"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="Douli998"),

        },loadOnStartup = 1
)
public class JDBCWebServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Failed to initialize the database connection", e);
        }
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet()--> "+con);
        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Submitted Data</title>");
        writer.println("</head>");
        writer.println("<body>");

        // 创建表格显示数据
        writer.println("<h2>Submitted Data:</h2>");
        writer.println("<table border='1'>");
        writer.println("<tr>");
        writer.println("<th>driver</th>");
        writer.println("<th>url</th>");
        writer.println("<th>username</th>"); // 密码通常不显示
        writer.println("<th>password</th>");
        writer.println("</tr>");

        writer.println("<tr>");
        writer.println("<td>" + driver + "</td>");
        writer.println("<td>" + url + "</td>");

        writer.println("<td>" + username + "</td>");
        writer.println("<td>" + password + "</td>");
        writer.println("</tr>");

        writer.println("</table>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
