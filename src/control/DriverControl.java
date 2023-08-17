package control;

import dao.DriverDAO;
import java.util.List;
import model.Driver;
import table.TableDriver;

public class DriverControl {
    private DriverDAO dDao = new DriverDAO();
    
    public void insertDriver(Driver d){
        dDao.insertDriver(d);
    }
    
    public List<Driver> showListDriver(){
        List<Driver> dataDriver = dDao.showDriver();
        return dataDriver;
    }
    
    public void updateDriver(Driver d){
        dDao.updateDriver(d);
    }
    
    public TableDriver showDriverBySearch(String query){
        List<Driver> dataDriver = dDao.showDriverBySearch(query);
        TableDriver tableDriver = new TableDriver(dataDriver);
        
        return tableDriver;
    }
    
    public void deleteDriver(int id){
        dDao.deleteDriver(id);
    }
    
    public int generateId(){
        int d = 1;
        d = dDao.generateId();
        return d;
    }
    
    public String getRoleFromDatabase(String username){
        return username;
    }
}
