package model;

public class Administrasi extends Pegawai {
    private String areaTugas; 

    public Administrasi(String idPegawai, String nama, String areaTugas) {
        super(idPegawai, nama);
        this.areaTugas = areaTugas;
    }

    @Override
    public void tampilkanProfil() {
        super.tampilkanProfil();
        System.out.println("Jabatan      : Staf Administrasi");
        System.out.println("Area Tugas   : " + areaTugas);
        System.out.println("---------------------------------------------");
    }

    public void updateDataAdmin(String namaBaru) {
        this.nama = namaBaru;
        System.out.println("Data disimpan: Hanya nama staf diperbarui.");
    }

    public void updateDataAdmin(String namaBaru, String areaTugasBaru) {
        this.nama = namaBaru;
        this.areaTugas = areaTugasBaru;
        System.out.println("Data disimpan: Nama dan area tugas staf diperbarui.");
    }
}