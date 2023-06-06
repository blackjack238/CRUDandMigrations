package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 class Database {
private static Database INSTANCE;
   private Connection connection;
   private static String url;
   private static String login;
   private  static String password;
   public Database(String url1,String login2,String password3){

       try {
       url=url1;
       login=login2;
       password=password3;
           connection = DriverManager.getConnection(url,login,password);
   }catch (SQLException e){
e.printStackTrace();
       }
}
public static Database getINSTANCE(){
       if(INSTANCE==null){
           synchronized (Database.class){
               if (INSTANCE==null){
               INSTANCE= new Database(url,login,password);
               }
           }
       }
       return INSTANCE;
}
public Connection getConnection(){
       return connection;
}
}



