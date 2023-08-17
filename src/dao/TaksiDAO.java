package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Taksi;

public class TaksiDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertTaksi(Taksi t){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO taksi(id, merek, jenis, plat, kapasitas) "
                + "VALUES ('" + t.getId() + "', '" + t.getMerek() + "', '" + t.getJenis() + "', '" + 
                t.getPlat() + "', '" + t.getKapasitas() +  "')";
        
        System.out.println("Adding Taksi....");
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Taksi");
            statement.close();
        } catch (Exception e){
            System.out.println("Error adding Taksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Taksi> showTaksi(){
        con = dbCon.makeConnection();
            
        String sql = "SELECT * FROM taksi";
        System.out.println("Mengambil data Taksi....");
            
        List<Taksi> list = new ArrayList();
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
                
            if(rs != null){
                while(rs.next()){
                    Taksi t = new Taksi(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("plat"),
                            rs.getString("merek"),
                            rs.getString("jenis"),
                            Integer.parseInt(rs.getString("kapasitas"))
                    );
                    list.add(t);
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
    
    public List<Taksi> showTaksiBySearch(String query){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM taksi "
                    + "WHERE (id LIKE '%" + query + "%' "
                    + "OR merek LIKE '%" + query + "%' "
                    + "OR jenis LIKE '%" + query + "%' "
                    + "OR plat LIKE '%" + query + "%' "
                    + "OR kapasitas LIKE '%" + query + "%')";
        
        System.out.println("Searching Taksi...");
        List<Taksi> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if(rs != null){
                while(rs.next()) {
                     Taksi t = new Taksi(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("plat"),
                            rs.getString("merek"),
                            rs.getString("jenis"),
                            Integer.parseInt(rs.getString("kapasitas"))
                    );
                    list.add(t);
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
    
    
    public void updateTaksi(Taksi t){
        con = dbCon.makeConnection();
            
        String sql = "UPDATE taksi SET merek = '" + t.getMerek()+ "', " + "jenis = '" + t.getJenis()+ "', "
                + "plat = '" + t.getPlat()+ "', " + "kapasitas = '" + t.getKapasitas()+"' "
                + "WHERE id = '" + t.getId() + "'";
        
        System.out.println("Editing Taksi....");  
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Taksi " + t.getId() );
            statement.close();
        }catch(Exception e){
            System.out.println("Eror editing Taksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteTaksi(int id){
        con = dbCon.makeConnection();
            
        String sql = "DELETE FROM taksi WHERE id = " + id + "";
        System.out.println("Deleting Taksi.....");
            
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Taksi" );
            statement.close();
        }catch(Exception e){
            System.out.println("Error close Taksi...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public int generateId() {
        con = dbCon.makeConnection();

        String sql = "SELECT * FROM taksi ORDER BY id DESC LIMIT 1";

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
        return 0;
    }
}
