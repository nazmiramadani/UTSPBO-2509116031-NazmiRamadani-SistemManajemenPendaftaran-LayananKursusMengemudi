package model;

public class Instruktur extends Pegawai {
    private String spesialisasi; 

    public Instruktur(String idPegawai, String nama, String spesialisasi) {
        super(idPegawai, nama); 
        this.spesialisasi = spesialisasi;
    }

    @Override
    public void tampilkanProfil() {
        super.tampilkanProfil();
        System.out.println("Jabatan      : Instruktur Mengemudi");
        System.out.println("Spesialisasi : " + spesialisasi);
        System.out.println("---------------------------------------------");
    }

    public void updateDataInstruktur(String namaBaru) {
        this.nama = namaBaru;
        System.out.println("Data disimpan: Hanya nama instruktur diperbarui.");
    }

    public void updateDataInstruktur(String namaBaru, String spesialisasiBaru) {
        this.nama = namaBaru;
        this.spesialisasi = spesialisasiBaru;
        System.out.println("Data disimpan: Nama dan spesialisasi instruktur diperbarui.");
    }
}