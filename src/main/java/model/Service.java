package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    private ArrayList<KursusMengemudi> daftarSiswa;
    private ArrayList<Pegawai> daftarPegawai; 
    private Scanner scanner;
    
    public Service(Scanner scanner){
        this.daftarSiswa = new ArrayList<>();
        this.daftarPegawai = new ArrayList<>();
        this.scanner = scanner;
        
        muatDataDummy();
    }
    
    private void muatDataDummy() {
        daftarSiswa.add(new KursusManual(101, "Nazmi Ramadani", "081234567890", 5, 230000, true, 300000));
        daftarSiswa.add(new KursusMatic(102, "Diandra Riskita", "081987654321", 4, 160000, false, 300000));
        daftarPegawai.add(new Instruktur("P01", "Pak Joko", "Mobil Manual"));
        daftarPegawai.add(new Administrasi("P02", "Ani Lestari", "Front Office & Keuangan"));
    }
    
//SISWA
    public void tambahSiswa(){
        System.out.print("ID Pendaftaran: "); 
        int id = scanner.nextInt(); 
        scanner.nextLine(); 

        System.out.print("Nama Siswa: "); 
        String nama = scanner.nextLine();

        System.out.print("No Telepon: "); 
        String telp = scanner.nextLine();

        System.out.print("Jumlah Pertemuan: "); 
        int pertemuan = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Pilih Tipe Kursus (1. Manual, 2. Matic): ");
        int tipe = scanner.nextInt();
        scanner.nextLine();

        if (tipe == 1) {
            System.out.print("Butuh Sertifikat SIM? (y/n): ");
            boolean butuhSertifikat = scanner.nextLine().equalsIgnoreCase("y");
            KursusManual siswaBaru = new KursusManual(id, nama, telp, pertemuan, 230000, butuhSertifikat, 300000);
            daftarSiswa.add(siswaBaru);
            System.out.println("Data Kursus Manual berhasil ditambahkan");
            
        } else if (tipe == 2) {
            System.out.print("Butuh Sertifikat SIM? (y/n): ");
            boolean butuhSertifikat = scanner.nextLine().equalsIgnoreCase("y");
            KursusMatic siswaBaru = new KursusMatic(id, nama, telp, pertemuan, 160000, butuhSertifikat, 300000);
            daftarSiswa.add(siswaBaru);
            System.out.println("Data Kursus Matic berhasil ditambahkan");
            
        } else {
            System.out.println("Tipe kursus tidak valid");
        }
    }
    
    public void tampilkanSiswa(){
        if(daftarSiswa.isEmpty()){
            System.out.println("Belum ada data siswa.");
            return;
        }
        for (int i = 0; i < daftarSiswa.size(); i++) {
            daftarSiswa.get(i).tampilkanInfo(); 
        }
    }
    
    public void hapusSiswa(){
        System.out.print("Masukkan ID Pendaftaran: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < daftarSiswa.size(); i++){
            if(daftarSiswa.get(i).getIdPendaftaran() == idTarget){    
                daftarSiswa.remove(i);
                System.out.println("Data berhasil dihapus");
                return;
            }
        }
        System.out.println("Data tidak ditemukan.");
    }
    
    public void updateSiswa(){
        System.out.print("Masukkan ID Pendaftaran: ");
        int idTarget = scanner.nextInt();
        scanner.nextLine();

        for (KursusMengemudi siswa : daftarSiswa){
            if(siswa.getIdPendaftaran() == idTarget){
                System.out.print("Nama Baru: ");
                siswa.setNamaSiswa(scanner.nextLine());
                
                System.out.print("Jumlah Pertemuan Baru: ");
                siswa.setJumlahPertemuan(scanner.nextInt());
                scanner.nextLine();
                
                System.out.println("Data berhasil diperbarui");
                return;
            }
        }
        System.out.println("Data tidak ditemukan");
    }

//PEGAWAI
    public void tambahPegawai() {
        System.out.print("ID Pegawai: ");
        String id = scanner.nextLine();
        
        System.out.print("Nama Pegawai: ");
        String nama = scanner.nextLine();
        
        System.out.println("Pilih Jabatan (1. Instruktur, 2. Administrasi): ");
        int jabatan = scanner.nextInt();
        scanner.nextLine();

        if (jabatan == 1) {
            System.out.print("Spesialisasi (Manual/Matic/Semua): ");
            String spesialisasi = scanner.nextLine();
            Instruktur instrukturBaru = new Instruktur(id, nama, spesialisasi);
            daftarPegawai.add(instrukturBaru);
            System.out.println("Data Instruktur berhasil ditambahkan.");
        } else if (jabatan == 2) {
            System.out.print("Tugas (Front Office/Keuangan/Dll): ");
            String area = scanner.nextLine();
            Administrasi adminBaru = new Administrasi(id, nama, area);
            daftarPegawai.add(adminBaru);
            System.out.println("Data Administrasi berhasil ditambahkan.");
        } else {
            System.out.println("Pilihan jabatan tidak valid.");
        }
    }

    public void tampilkanPegawai() {
        if (daftarPegawai.isEmpty()) {
            System.out.println("Belum ada data pegawai.");
            return;
        }
        System.out.println("\n--- Daftar Pegawai ---");
        for (Pegawai p : daftarPegawai) {
            p.tampilkanProfil(); 
        }
    }

    public void updatePegawai() {
        System.out.print("Masukkan ID Pegawai: ");
        String idTarget = scanner.nextLine();

        for (Pegawai p : daftarPegawai) {
            if (p.getIdPegawai().equals(idTarget)) {
                System.out.print("Nama Baru: ");
                String namaBaru = scanner.nextLine();
                
                System.out.print("Ingin update data spesifik jabatan? (y/n): ");
                boolean updateSpesifik = scanner.nextLine().equalsIgnoreCase("y");
                
                if (p instanceof Instruktur) {
                    Instruktur inst = (Instruktur) p; 
                    if (updateSpesifik) {
                        System.out.print("Spesialisasi Baru: ");
                        String spesialisasiBaru = scanner.nextLine();
                        inst.updateDataInstruktur(namaBaru, spesialisasiBaru); 
                    } else {
                        inst.updateDataInstruktur(namaBaru); 
                    }
                } else if (p instanceof Administrasi) {
                    Administrasi admin = (Administrasi) p; 
                    if (updateSpesifik) {
                        System.out.print("Tugas Baru: ");
                        String areaBaru = scanner.nextLine();
                        admin.updateDataAdmin(namaBaru, areaBaru); 
                    } else {
                        admin.updateDataAdmin(namaBaru); 
                    }
                }
                return;
            }
        }
        System.out.println("Data Pegawai tidak ditemukan.");
    }
}