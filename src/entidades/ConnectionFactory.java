package entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
   static{
      try{
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e){
         throw new RuntimeException(e);
      }
   }
   
   public static Connection getConnection(){
      try{
         return DriverManager.getConnection(
            "jdbc:mysql://localhost/ponto?user=root&password=123789123&useTimezone=true&serverTimezone=UTC");
      } catch (SQLException e){
         e.printStackTrace();
      }
      return null;
  }

}