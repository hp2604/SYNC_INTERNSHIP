
package com.syn_intern.dao;
import java.sql.*;
import com.syn_intern.connection.*;

public class formdao {
    private Connection con;
    private PreparedStatement ps;
    private boolean status=false;
    
    public boolean savefeedback(String email,String feedback)
    {
        try {
            String query="insert into response(email,feed) values (?,?);";
            con=database_connection.getConnection();
            ps=con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, feedback);
            ps.executeUpdate();
            ps.close();
            status=true;
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return status;
    }
    
}
