package model;

public class User {
    private int id;
    private String nama, role, username, password;

    public User(int id, String nama, String role, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public User(String nama, String role, String username, String password) {
        this.nama = nama;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
