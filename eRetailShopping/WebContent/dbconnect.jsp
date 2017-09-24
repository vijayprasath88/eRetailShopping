<html>
<head><title>Enter to database</title></head>
<body>

<%@ page import="java.util.*" %>
<%@ page import="javax.sql.*" %>
<% 

java.sql.Connection con;
java.sql.Statement s;
java.sql.ResultSet rs;
java.sql.PreparedStatement pst;

con=null;
s=null;
pst=null;
rs=null;

// Remember to change the next line with your own environment 
String url= "jdbc:sqlserver://localhost:1433"+";databaseName=RetailDB";
String id= "sa";
String pass = "password-1";
try{

Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
con = java.sql.DriverManager.getConnection(url, id, pass);

}catch(ClassNotFoundException cnfex){
cnfex.printStackTrace();

}
String sql = "select top 10 * from users";
try{
s = con.createStatement();
rs = s.executeQuery(sql);
%>
<table>
<%
while( rs.next() ){
%><tr>
<td><%= rs.getString("user_id") %></td>
<td><%= rs.getString("user_name") %></td>
<td><%= rs.getString("user_role") %></td>
<td><%= rs.getString("user_password") %></td>
</tr>
<%
}
%>

<%

}
catch(Exception e){e.printStackTrace();}
finally{
if(rs!=null) rs.close();
if(s!=null) s.close();
if(con!=null) con.close();
}

%>
</table>
</body>
</html>