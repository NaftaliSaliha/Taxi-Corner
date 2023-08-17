package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Penggunaan;

public class TablePenggunaan extends AbstractTableModel{
    private List<Penggunaan> list;
    
    public TablePenggunaan(List<Penggunaan> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 6;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getDriver().getNama();
            case 1:
                return list.get(rowIndex).getTaxi().getPlat();
            case 2:
                return list.get(rowIndex).getPenumpang();
            case 3:
                return list.get(rowIndex).getTarif();
            case 4:
                return list.get(rowIndex).getTanggal();
            case 5:
                return list.get(rowIndex).getLayanan();            
            case 6:
                return list.get(rowIndex).getId();
            case 7:
                return list.get(rowIndex).getDriver().getId();
            case 8:
                return list.get(rowIndex).getTaxi().getId();
            default:
                return null;
        }
        
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama Driver";
            case 1:
                return "Plat Nomor";
            case 2:
                return "Penumpang";
            case 3:
                return "Tarif";
            case 4:
                return "Tanggal";
            case 5:
                return "Layanan";
            default:
                return null;
        }
    }
}
