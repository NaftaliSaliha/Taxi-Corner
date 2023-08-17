package control;

import dao.UserDAO;
import model.User;
import java.util.List;
import table.TableUser;

public class UserControl {
    private UserDAO dDao = new UserDAO();
    
    public void insertDataUser(User user) {
        dDao.insertUser(user);
    }
    
    public List<User> showListUser(){
        List<User> dataUser = dDao.showUser();
        return dataUser;
    }
    
    public void updateDataUser(User user){
        dDao.updateUser(user);
    }
    
    public TableUser showUserBySearch(String query){
        List<User> dataDriver = dDao.showUserBySearch(query);
        TableUser tableDriver = new TableUser(dataDriver);
        
        return tableDriver;
    }
    
    public void deleteDataUser(int id){
        dDao.deleteUser(id);
    }
    
    public User searchUser(String username, String password){
        User user = null;
        user = dDao.searchUser(username, password);
        return user;
    }
    
    public int generateId(){
        int d = 1;
        d = dDao.generateId();
        return d;
    }
}
