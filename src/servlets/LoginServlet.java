package servlets;

import com.google.gson.Gson;
import data_access_object.UserDAO;
import entity.User;

import javax.servlet.annotation.WebServlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Gson gson=new Gson();
        System.out.println("login:");
        User user = new User();

        // 设置响应内容类型
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        try (PrintWriter out = response.getWriter()) {

            //获得请求中传来的用户名和密码
            BufferedReader reader = request.getReader();
            String userStr = reader.readLine();
            System.out.println(userStr);
            reader.close();

            user=gson.fromJson(userStr,User.class);
            User user0 = UserDAO.queryUser(user.getUserId());
            Boolean verifyResult = (user0 != null) && user.getPassword().equals(user0.getPassword());

            String s;
            if (verifyResult) {
                s = "{'status':0,'User':"+gson.toJson(user0)+"}";
            }else {
                s = "{'status':1,'User':'error'}";
            }
            out.write(s);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
