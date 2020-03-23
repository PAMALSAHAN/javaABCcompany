/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc.university;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;

/**
 *
 * @author Chamath
 */

public class DbOperation {
    Connection con=null;
    PreparedStatement pst=null;
    
    
    public boolean addStudent(Student st) {
        
        try{
            DbConnection db=new DbConnection();
        
        // connection eka hadagannawa
            con=(Connection)DriverManager.getConnection(db.getUrl(), db.getUsername(), db.getPassword());
            
        //query eka hadaganna
            String query="INSERT INTO student VALUES(?,?,?,?,?,?,?,?,?)";
            pst=(PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, st.getRegId());
            pst.setString(2, st.getFirstName());
            pst.setString(3, st.getLastName());
            pst.setInt(4, st.getAge());
            pst.setString(5, st.getAddress());
            pst.setString(6, st.getGender());
            pst.setString(7, st.getFaculty());
            pst.setString(8, st.getDepartment());
            pst.setString(9, st.getYearOfRegistration());
            
            pst.executeUpdate();
            
            return true;
            
        
        }catch(Exception e){
            System.out.println(e);
            return false;
        }finally{
            try{
                if(pst !=null){
                    pst.close();
                }
                if(con !=null){
                    con.close();
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
            
        
        
        
        
    }
    
}
