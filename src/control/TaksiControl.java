package control;

import dao.TaksiDAO;
import java.util.List;
import model.Taksi;
import table.TableTaksi;

public class TaksiControl {
    private TaksiDAO dDao = new TaksiDAO();
    
    public void insertTaksi(Taksi t){
        dDao.insertTaksi(t);
    }
    
    public List<Taksi> showListTaksi(){
        List<Taksi> dataTaksi = dDao.showTaksi();
        return dataTaksi;
    }
    
    public void updateTaksi(Taksi t){
        dDao.updateTaksi(t);
    }
    
    public TableTaksi showTaksiBySearch(String query){
        List<Taksi> dataTaksi = dDao.showTaksiBySearch(query);
        TableTaksi tableTaksi = new TableTaksi(dataTaksi);
        
        return tableTaksi;
    }
    
    public void deleteTaksi(int id){
        dDao.deleteTaksi(id);
    }
    
    public int generateId(){
        int t = 0;
        t = dDao.generateId();
        return t;
    }
    
    public String getRoleFromDatabase(String username){
        return username;
    }
}
