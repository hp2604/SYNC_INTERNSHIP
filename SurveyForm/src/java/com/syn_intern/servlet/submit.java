
package com.syn_intern.servlet;

import com.syn_intern.dao.formdao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class submit extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try  {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>response</title>");            
            out.println("</head>");
            out.println("<body>");
            String email=request.getParameter("email");
            String fed= request.getParameter("feedback");
            String check=request.getParameter("box");
            formdao fd=new formdao();
            RequestDispatcher rd;
            if(check!=null)
            {
                email="anonyomus";
            }
            if(fd.savefeedback(email,fed ))
            {
                
                rd=request.getRequestDispatcher("record.jsp");
                rd.forward(request, response);
            }
            else
            {
                out.println("<h5>Something went Wrong</h5>");
                rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
                
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
               
    }

    

}
