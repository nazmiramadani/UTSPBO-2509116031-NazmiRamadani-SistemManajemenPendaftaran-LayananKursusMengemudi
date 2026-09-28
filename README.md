# Sistem Manajemen Pendaftaran & Layanan Kursus Mengemudi
# Nama : Nazmi Ramadani
# NIM  : 2509116031

Aplikasi berbasis console (CLI) yang dibuat dengan Java untuk mengelola pendaftaran siswa kursus mengemudi beserta data pegawai (instruktur dan staf administrasi). Proyek ini dibuat sebagai tugas UTS Pemrograman Berorientasi Objek (PBO) dan menerapkan konsep-konsep utama OOP.

## 1. Deskripsi Proyek
### Ringkasan
Program ini membantu sebuah lembaga kursus mengemudi mencatat dan mengelola data operasionalnya, yaitu:

- **Data siswa** yang mendaftar kursus mobil **Manual** atau **Matic**, lengkap dengan perhitungan otomatis total biaya kursus (tarif per pertemuan × jumlah pertemuan + biaya sertifikat SIM bila dipilih).
- **Data pegawai**, yang terdiri dari **Instruktur Mengemudi** dan **Staf Administrasi**.

### Fitur Utama

| Menu | Fitur |
|------|-------|
| Kelola Kursus (Siswa) | Tambah, Tampilkan, Hapus, dan Update data siswa |
| Kelola Pegawai | Tambah, Tampilkan, dan Update data pegawai |

### Tarif yang Digunakan

| Komponen | Biaya |
|----------|-------|
| Kursus Mobil Manual | Rp 230.000 / pertemuan |
| Kursus Mobil Matic | Rp 160.000 / pertemuan |
| Sertifikat SIM (opsional) | Rp 300.000 |

**Rumus total biaya:**
```
Total Biaya = (Jumlah Pertemuan × Tarif Per Pertemuan) + Biaya Sertifikat (jika dipilih)
```

### Konsep OOP yang Diterapkan

| Konsep | Penerapan pada Kode |
|--------|---------------------|
| **Encapsulation** | Atribut `private`/`protected` dengan getter & setter (contoh: `KursusMengemudi`, `KursusManual`) |
| **Inheritance** | `KursusManual` & `KursusMatic` mewarisi `KursusMengemudi`; `Instruktur` & `Administrasi` mewarisi `Pegawai` |
| **Polymorphism (Overriding)** | `tampilkanInfo()` dan `tampilkanProfil()` di-override pada setiap subclass; `ArrayList<KursusMengemudi>` dan `ArrayList<Pegawai>` menyimpan berbagai jenis objek turunan |
| **Overloading** | `updateDataInstruktur()` dan `updateDataAdmin()` masing-masing memiliki dua versi (hanya nama, atau nama + data spesifik) |
| **Final method** | `cetakStatusDaftar()` pada `KursusMengemudi` tidak dapat di-override |
| **Final attribute** | `idPendaftaran` bersifat `final` sehingga tidak dapat diubah setelah dibuat |
| **instanceof & Downcasting** | `Service.updatePegawai()` memeriksa tipe pegawai sebelum memanggil method spesifik |

---
