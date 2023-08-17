package model;

public class Penggunaan {
    private int id;
    private String tanggal;
    private String layanan;
    private String penumpang;
    private int tarif;
    private Driver driver;
    private Taksi taxi;

    public Penggunaan(int id, String tanggal, String layanan, String penumpang, int tarif, Driver driver, Taksi taxi) {
        this.id = id;
        this.tanggal = tanggal;
        this.layanan = layanan;
        this.penumpang = penumpang;
        this.tarif = tarif;
        this.driver = driver;
        this.taxi = taxi;
    }

    public Penggunaan(String tanggal, String layanan, String penumpang, int tarif, Driver driver, Taksi taxi) {
        this.tanggal = tanggal;
        this.layanan = layanan;
        this.penumpang = penumpang;
        this.tarif = tarif;
        this.driver = driver;
        this.taxi = taxi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLayanan() {
        return layanan;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }
    
    public String getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(String penumpang) {
        this.penumpang = penumpang;
    }
    
    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Taksi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taksi taxi) {
        this.taxi = taxi;
    }
}
