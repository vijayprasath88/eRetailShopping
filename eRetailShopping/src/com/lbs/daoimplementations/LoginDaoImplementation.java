package com.lbs.daoimplementations;
import com.lbs.beans.Login;
import com.lbs.daointerfaces.LoginDao;
import com.lbs.utilities.DatabaseConnectivityUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class LoginDaoImplementation implements LoginDao {
	 Connection con=null;
     public int matchDetails(Login Login){

      int status=0;
      String userName = Login.getemail();
      String password = Login.getPassword();
      int customerId = 0;
      

     

     try{

          con=DatabaseConnectivityUtility.getConnection();
          PreparedStatement ps=con.prepareStatement("Select * from Customer_Login where Customer_Email =? and Password=?");
          ps.setString(1,Login.getemail());
          ps.setString(2, Login.getPassword());
        //  ps.setString(5, Login.getRole());
          ResultSet rs= ps.executeQuery();
              
          
          if(rs.next()){
              customerId=rs.getInt(1);
             System.out.println(customerId);
          }
     
      }
     
          
       
      catch(Exception e){
      e.printStackTrace();

      }
     return customerId;
}
}
