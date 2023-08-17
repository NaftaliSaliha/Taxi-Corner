package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Driver;

public class DriverDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertDriver(Driver d){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO driver(id, nama, umur, gender, no_telpon, alamat) "
                + "VALUES ('" + d.getId()+ "', '" + d.getNama()+ "', '" + d.getUmur()+ "', '" + 
                d.getGender()+ "', '" + d.getNoTelp()+ "', '" + d.getAlamat()+  "')";
        
        System.out.println("Adding Driver....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Driver");
            statement.close();
        } catch (Exception e){
            System.out.println("Error adding Driver...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Driver> showDriver(){
        con = dbCon.makeConnection();
            
        String sql = "SELECT * FROM driver";
        System.out.println("Mengambil data Driver....");
            
        List<Driver> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
                
            if(rs != null){
                while(rs.next()){
                    Driver d = new Driver(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("nama"),
                            Integer.parseInt(rs.getString("umur")),
                            rs.getString("gender"),
                            rs.getString("no_telpon"),
                            rs.getString("alamat")
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
        dbCon.closeConnection();
        
        return list;
    }
    
    public List<Driver> showDriverBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM driver "
                    + "WHERE (id LIKE '%" + query + "%' "
                    + "OR nama LIKE '%" + query + "%' "
                    + "OR umur LIKE '%" + query + "%' "
                    + "OR gender LIKE '%" + query + "%' "
                    + "OR no_telpon LIKE '%" + query + "%' "
                    + "OR alamat LIKE '%" + query + "%')";
        System.out.println("Searching Driver...");
        List<Driver> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()) {
                     Driver d = new Driver(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("nama"),
                            Integer.parseInt(rs.getString("umur")),
                            rs.getString("gender"),
                            rs.getString("no_telpon"),
                            rs.getString("alamat")
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
        dbCon.closeConnection();
        
        return list;       
    }
    
    public void updateDriver(Driver d){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE driver SET id = " + d.getId() + ","
                    + "nama = '" + d.getNama() + "', "
                    + "umur = '" + d.getUmur() + "', "
                    + "gender = '"+ d.getGender() + "', "
                    + "no_telpon = '"+ d.getNoTelp()+ "', "
                    + "alamat = '"+ d.getAlamat()+ "' "
                    + "WHERE id = " + d.getId() +"";
        
        System.out.println("Editing Driver....");  
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " +result+ " Driver " + d.getId());
            statement.close();
        }catch(Exception e){
            System.out.println("Eror editing Driver...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteDriver(int id){
        con = dbCon.makeConnection();
            
        String sql = "DELETE FROM driver WHERE id = " + id + "";
        System.out.println("Deleting Driver.....");
            
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Driver" );
            statement.close();
            
        }catch(Exception e){
            System.out.println("Error close Driver...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public int generateId() {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM driver ORDER BY id DESC LIMIT 1";

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
            System.out.println("Error generate ID Driver...");
            System.out.println(e);
        }
        return 1;
    }
    
    public String getRoleFromDatabase(String username) {
        String role = null;
        con = dbCon.makeConnection();

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

        dbCon.closeConnection();

        return role;
    }
}
