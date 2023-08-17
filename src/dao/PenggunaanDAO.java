package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Penggunaan;
import model.Driver;
import model.Taksi;

public class PenggunaanDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertPenggunaan(Penggunaan p) {
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO penggunaan(id, id_driver, id_taksi, penumpang, tanggal, layanan, tarif) "
                + "VALUES ('" + p.getId()+ "', '" + p.getDriver().getId()+ "', '" + p.getTaxi().getId() + "','"
                + p.getPenumpang() + "', '" + p.getTanggal() + "', '" + p.getLayanan() + "', '" + p.getTarif() + "')";
        
        System.out.println("Adding Penggunaan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Penggunaan");
            statement.close();
        } catch(Exception e){
            System.out.println("Error adding Penggunaan...");
            System.out.println(e);
        }
       
        dbCon.closeConnection();
    }
    
    public List<Penggunaan> showPenggunaan(String query) {
        con = dbCon.makeConnection();
        String sql = "SELECT d.*, p.*, t.* FROM driver as d JOIN penggunaan as p ON d.id = p.id_driver JOIN "
                + "taksi t ON p.id_taksi = t.id WHERE (d.nama LIKE '%" + query+ "%'"
                + "OR t.plat LIKE '%" + query + "%'"
                + "OR p.penumpang LIKE '%" + query + "%'"
                + "OR p.tarif LIKE '%" + query + "%'"
                + "OR p.tanggal LIKE '%" + query + "%'"
                + "OR p.layanan LIKE '%" + query + "&')";
        
        System.out.println("Mengambil data Penggunaan...");
        List<Penggunaan> list = new ArrayList();
        
        try{
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs != null){
                while(rs.next()){
                    Taksi t = new Taksi(Integer.parseInt(rs.getString("t.id")),
                            rs.getString("t.plat"), rs.getString("t.merek"),
                            rs.getString("t.jenis"), Integer.parseInt(rs.getString("t.kapasitas")));
                    
                    Driver d = new Driver(
                            Integer.parseInt(rs.getString("id")),
                            rs.getString("nama"),
                            Integer.parseInt(rs.getString("umur")),
                            rs.getString("gender"),
                            rs.getString("no_telpon"),
                            rs.getString("alamat")              
                    );
                    
                    Penggunaan p = new Penggunaan(Integer.parseInt(rs.getString("p.id")), rs.getString("p.tanggal"),
                            rs.getString("p.layanan"), rs.getString("p.penumpang"), Integer.parseInt(rs.getString("p.tarif")), d, t);
                    
                    list.add(p);
                }
            }
            rs.close();
            statement.close();
        } catch(Exception e){
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
        return list;
    }
    
    public void updatePenggunaan(Penggunaan p){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE penggunaan SET id_driver = '" + p.getDriver().getId()
                + "', id_taksi = '" + p.getTaxi().getId()
                + "', penumpang = '" + p.getPenumpang()
                + "', tanggal = '" + p.getTanggal()
                + "', layanan = '" + p.getLayanan()
                + "', tarif = '" + p.getTarif()
                + "' WHERE id = '" + p.getId() + "'";
        System.out.println("Editing Penggunaan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited " + result + " Penggunaan " + p.getId());
            statement.close();
        } catch(Exception e){
            System.out.println("Error editing Penggunaan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
    
    public void deletePenggunaan(int id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM penggunaan WHERE id = " + id + "";
        System.out.println("Deleting Penggunaan...");
        
        try{
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Penggunaan " + id);
            statement.close();
        } catch(Exception e){
            System.out.println("Error deleting Penggunaan...");
            System.out.println(e);
        }
        
        dbCon.closeConnection();
    }
}
