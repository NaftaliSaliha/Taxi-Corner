package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO {
    private DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertUser(User user) {
        con = dbcon.makeConnection();
                
        String sql = "INSERT INTO login(id, nama, role, username, password) VALUES ('" 
                + user.getId()+  "', '"
                + user.getNama()+ "', '" 
                + user.getRole()+  "', '"
                + user.getUsername()+  "', '"
                + user.getPassword()+ "')";
        
        System.out.println("Adding User...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " User");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding User...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public void deleteUser(int id) {
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM login WHERE id = " + id + "";
        System.out.println("Deleting User...");
        
        try {
            
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " User " + id);
            statement.close();
            
        } catch (Exception e) {
            System.out.println("Error deleting User...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public void updateUser(User user) {
        con = dbcon.makeConnection();
        
        String sql = "UPDATE login SET nama = '" +user.getNama()
                + "', role = '" + user.getRole()
                + "', username = '" + user.getUsername()
                + "', password = '" + user.getPassword()
                + "' WHERE id = '" + user.getId() + "'";
        System.out.println("Editing User...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " User " + user.getId());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Uer...");
            System.out.println(e);
        }
        dbcon.closeConnection();
    }
    
    public User searchUser(String user, String password){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM login WHERE username = '" + user + "' AND password = '" + password + "'";
        System.out.println("Searching Data...");
        User foundUser = null;
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    foundUser = new User(
                        Integer.parseInt(rs.getString("id")),
                            rs.getString("nama"),
                            rs.getString("role"),
                            rs.getString("username"),
                            rs.getString("password"));
                }
            }
            
            rs.close();
            statement.close();
        }catch (Exception e){
            System.out.println("Error Reading Database . . .");
            System.out.println(e);
        }
        
        dbcon.closeConnection();
        
        return foundUser;
    }
    
    public List<User> showUser(){
        con = dbcon.makeConnection();
            
        String sql = "SELECT * FROM login";
        System.out.println("Mengambil data User....");
            
        List<User> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
                
            if(rs != null){
                while(rs.next()){
                    User d = new User(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("nama"),
                            rs.getString("role"),
                            rs.getString("username"),
                            rs.getString("password")
                    );
                    list.add(d);
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e){
            System.out.println("Eror reading database.....");
            System.out.println(e);
        }
        dbcon.closeConnection();
        
        return list;
    }
    
    public List<User> showUserBySearch(String query){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM login "
                    + "WHERE (id LIKE '%" + query + "%' "
                    + "OR nama LIKE '%" + query + "%' "
                    + "OR role LIKE '%" + query + "%' "
                    + "OR username LIKE '%" + query + "%' "
                    + "OR password LIKE '%" + query + "%')";
        System.out.println("Searching User...");
        List<User> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()) {
                     User d = new User(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("nama"),
                            rs.getString("role"),
                            rs.getString("username"),
                            rs.getString("password")
                    );
                    list.add(d);
                }
            }
            rs.close();
            statement.close();
            
        }catch(Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        
        return list;       
    }
    
    public int generateId() {
        con = dbcon.makeConnection();

        String sql = "SELECT * FROM login ORDER BY id DESC LIMIT 1";

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next()){
                int genId = rs.getInt("id");
                int gen = genId + 1;
                return gen;
            } else {
                return 1;
            }
            
        } catch(Exception e){
            System.out.println("Error generate ID User...");
            System.out.println(e);
        }
        return 1;
    }
    
    public String getRoleFromDatabase(String username) {
        String role = null;
        con = dbcon.makeConnection();

        String sql = "SELECT role FROM login WHERE username = '" + username + "'";

        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                role = rs.getString("role");
            }

            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }

        dbcon.closeConnection();

        return role;
    }
}
