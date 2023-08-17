package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.User;

public class TableUser extends AbstractTableModel{
    private List<User> list;
    
    public TableUser(List<User> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount(){
        return list.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getRole();
            case 3:
                return list.get(rowIndex).getUsername();
            case 4:
                return list.get(rowIndex).getPassword();
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
                return "Role";
            case 3:
                return "Username";
            case 4:
                return "Password";
            default:
                return null;
        }
    }
}
