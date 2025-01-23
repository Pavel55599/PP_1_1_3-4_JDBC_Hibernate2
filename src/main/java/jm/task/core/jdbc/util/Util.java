package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

   private static final String SQL_DRIVER =  "com.mysql.cj.jdbc.Driver";   //"com.mysql.jdbc.Driver";
   private static final String DB_URL = "jdbc:mysql://localhost:3306/schemaex2";
   private static final String USER = "root";
   private static final String PASS = "3937Tyvm";



   public  Connection getConnection() {
      Connection connection = null;

       try {
           Class.forName(SQL_DRIVER);
           connection = DriverManager.getConnection(DB_URL,USER,PASS);
          System.out.println("ПОДКЛЮЧЕНИЕ УСТАНОВЛЕНО");
       } catch (ClassNotFoundException | SQLException e) {
          // e.printStackTrace();
           System.out.println("ПОДКЛЮЧЕНИЕ HE УСТАНОВЛЕНО, ПРОВЕРЬ ВВОДИМЫЕ ДАННЫЕ");
          // throw new RuntimeException(e);
       }
       return connection;
   }
}




//package jm.task.core.jdbc.util;
//
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class Util {
//
////private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
////private static final String JDBC_URL = "jdbc:mysql://localhost:3306/schemaex2";
////private static final String JDBC_USER = "root";
////private static final String JDBC_PASSWORD = "3937Tyvm";
////
////   Connection connection;
////
////   public static Connection getConnection() {
////
////
////   }
////
////
////}
// private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//private static final String JDBC_URL = "jdbc:mysql://localhost:3306/schemaex1";
//private static final String JDBC_USER = "root";
//private static final String JDBC_PASSWORD = "3937Tyvm";
//
//public static void main(String[] args) {
//   Connection connection;
//
//   try {
//      Driver driver = new com.mysql.cj.jdbc.Driver();
//      DriverManager.registerDriver(driver);
//      connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//      if (!connection.isClosed()) {
//         System.out.println("соединение с бд установлено");
//      }
//      connection.close();
//
//      if (connection.isClosed()) {
//         System.out.println("соединение с бд закрыто");
//      }
//
//
//   } catch (SQLException e) {
//      throw new RuntimeException(e);
//   }
//}
//}
//
//
//
//
//


    // реализуйте настройку соеденения с БД
//    // private static final String SQL_DRIVER = "com.mysql.jdbc.Driver";
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
//    private static final String USER = "root";
//    private static final String PASS = "root";
//
//    public static Connection getConnection() throws SQLException {
////        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
////            return connection;
////        }
//
//        Connection connection = null;
//        connection = DriverManager.getConnection(DB_URL, USER, PASS);
//        return connection;
//
//    }
//}
