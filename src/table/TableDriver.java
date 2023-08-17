package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Driver;

public class TableDriver extends AbstractTableModel{
    private List<Driver> list;
    
    public TableDriver(List<Driver> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 6;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getGender();
            case 3:
                return list.get(rowIndex).getUmur();
            case 4:
                return list.get(rowIndex).getNoTelp();
            case 5:
                return list.get(rowIndex).getAlamat();
            default:
                return null;
        }
        
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Jenis Kelamin";
            case 3:
                return "Umur";
            case 4:
                return "No Telepon";
            case 5:
                return "Alamat";
            default:
                return null;
        }
    }
}
