package model;

public class Taksi {
    private int id;
    private String plat;
    private String merek;
    private String jenis;
    private int kapasitas;
    
    public Taksi(int id, String plat, String merek, String jenis, int kapasitas){
        this.id = id;
        this.plat = plat;
        this.merek = merek;
        this.jenis = jenis;
        this.kapasitas = kapasitas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }
    
    public String showData(){
            return "ID : " + id + 
                    "\nPlat : " + plat +
                    "\nMerek : " + merek +
                    "\nJenis : " + jenis +
                    "\nKapasitas : " + kapasitas + "\n";
    }    
    
    @Override
    public String toString(){
        return plat;
    }
}
