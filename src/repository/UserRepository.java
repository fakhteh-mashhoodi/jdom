package repository;

import domainModel.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    Connection connection;
    public UserRepository(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2se","root","1234abcd");
            } catch (SQLException e) {
                System.out.println("connection bargharar nashod");
            }

        }catch (ClassNotFoundException e) {
            System.out.println("driver peida nahod");
        }
        }


    }
    public void deleteById (int id) {
        try {
            PreparedStatement statement=connection.prepareStatement("delete from users where id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    public int insert (Users user){
        try{
            PreparedStatement statement=connection.prepareStatement("insert into users (username,password) values (?,?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            int affectedRows=statement.executeUpdate();
            statement.close();
            connection.close();
            return affectedRows;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return 0;
        }

    }
}
