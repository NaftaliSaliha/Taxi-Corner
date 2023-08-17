package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Taksi;

public class TableTaksi extends AbstractTableModel{
    private List<Taksi> list;
    
    public TableTaksi(List<Taksi> list){
        this.list = list;
    }
    
    public int getRowCount(){
        return list.size();
    }
    
    public int getColumnCount(){
        return 5;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getPlat();
            case 2:
                return list.get(rowIndex).getMerek();
            case 3:
                return list.get(rowIndex).getJenis();
            case 4:
                return list.get(rowIndex).getKapasitas();
            default:
                return null;
        }
        
    }
    
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Plat Nomor";
            case 2:
                return "Merek";
            case 3:
                return "Jenis";
            case 4:
                return "Kapasitas";
            default:
                return null;
        }
    }
}
