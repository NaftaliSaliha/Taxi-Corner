package control;

import dao.PenggunaanDAO;
import java.util.List;
import model.Penggunaan;
import table.TablePenggunaan;

public class PenggunaanControl {
    private PenggunaanDAO pDao = new PenggunaanDAO();
    
    public void insertPenggunaan(Penggunaan p){
        pDao.insertPenggunaan(p);
    }
    
    public TablePenggunaan showPenggunaan(String query){
        List<Penggunaan> dataPenggunaan = pDao.showPenggunaan(query);
        TablePenggunaan tablePenggunaan = new TablePenggunaan(dataPenggunaan);
        
        return tablePenggunaan;
    }
    
    public void updatePenggunaan(Penggunaan p){
        pDao.updatePenggunaan(p);
    }
    
    public void deletePenggunaan(int id){
        pDao.deletePenggunaan(id);
    }
}
