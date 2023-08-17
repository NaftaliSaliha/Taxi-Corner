package model;

public class Driver {
    private int id;
    private String nama;
    private int umur;
    private String gender;
    private String noTelp;
    private String alamat;
    
    public Driver(int id, String nama, int umur, String gender, String noTelp, String alamat){
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.gender = gender;
        this.noTelp = noTelp;
        this.alamat = alamat;
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

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String showData(){
            return "ID : " + id + 
                    "\nNama  : " + nama +
                    "\nUmur : " + umur +
                    "\nGender : " + gender +
                    "\nNo Telepon : " + noTelp +
                    "\nAlamat : " + alamat + "\n";
    }    
    
    @Override
    public String toString(){
        return nama;
    }
}
