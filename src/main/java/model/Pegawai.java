package model;

public class Pegawai {
    protected String idPegawai;
    protected String nama;

    public Pegawai(String idPegawai, String nama) {
        this.idPegawai = idPegawai;
        this.nama = nama;
    }

    public void tampilkanProfil() {
        System.out.println("ID Pegawai   : " + idPegawai);
        System.out.println("Nama Pegawai : " + nama);
    }
    
    public String getIdPegawai() {
        return idPegawai;
    }
}