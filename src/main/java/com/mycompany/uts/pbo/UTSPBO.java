package com.mycompany.uts.pbo; 

import model.Service;
import java.util.Scanner;

public class UTSPBO {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Service service = new Service(scanner);

        boolean menuUtama = true;

        while (menuUtama) {
            System.out.println("\n=== Sistem Manajemen Kursus Mengemudi ===");
            System.out.println("1. Menu Kelola Kursus (Siswa)");
            System.out.println("2. Menu Kelola Pegawai");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu utama (1-3): ");
            
            int pilihanUtama = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihanUtama) {
                case 1 -> {
                    boolean menuKursus = true;
                    while (menuKursus) {
                        System.out.println("\n--- Menu Kelola Kursus (Siswa) ---");
                        System.out.println("1. Tambah Data Siswa");
                        System.out.println("2. Tampilkan Data Siswa");  
                        System.out.println("3. Hapus Data Siswa");
                        System.out.println("4. Update Data Siswa");
                        System.out.println("5. Kembali ke Menu Utama");
                        System.out.print("Pilih menu kursus (1-5): ");
                        
                        int pilKursus = scanner.nextInt();
                        scanner.nextLine();
                        
                        switch (pilKursus) {
                            case 1 -> service.tambahSiswa();
                            case 2 -> service.tampilkanSiswa();
                            case 3 -> service.hapusSiswa();
                            case 4 -> service.updateSiswa();
                            case 5 -> menuKursus = false;
                            default -> System.out.println("Pilihan tidak valid");
                        }
                    }
                }
                case 2 -> {
                    boolean menuPegawai = true;
                    while (menuPegawai) {
                        System.out.println("\n--- Menu Kelola Pegawai ---");
                        System.out.println("1. Tambah Data Pegawai");
                        System.out.println("2. Tampilkan Data Pegawai");
                        System.out.println("3. Update Data Pegawai");
                        System.out.println("4. Kembali ke Menu Utama");
                        System.out.print("Pilih menu pegawai (1-4): ");
                        
                        int pilPegawai = scanner.nextInt();
                        scanner.nextLine();
                        
                        switch (pilPegawai) {
                            case 1 -> service.tambahPegawai();
                            case 2 -> service.tampilkanPegawai();
                            case 3 -> service.updatePegawai();
                            case 4 -> menuPegawai = false;
                            default -> System.out.println("Pilihan tidak valid");
                        }
                    }
                }
                case 3 -> {
                    menuUtama = false;
                }
                default -> System.out.println("Pilihan tidak valid");
            }
        }
        
        System.out.println("Terima kasih telah menggunakan aplikasi ini.");
        scanner.close();
    }
}