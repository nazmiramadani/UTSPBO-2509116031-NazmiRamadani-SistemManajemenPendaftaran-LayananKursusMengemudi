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

## 2. Struktur Proyek

```
UTSPBO/
└── src/
    ├── com/mycompany/uts/pbo/
    │   └── UTSPBO.java          # Kelas utama (main) & tampilan menu
    └── model/
        ├── KursusMengemudi.java # Superclass siswa/kursus
        ├── KursusManual.java    # Subclass kursus mobil manual
        ├── KursusMatic.java     # Subclass kursus mobil matic
        ├── Pegawai.java         # Superclass pegawai
        ├── Instruktur.java      # Subclass instruktur
        ├── Administrasi.java    # Subclass staf administrasi
        └── Service.java         # Logika CRUD siswa & pegawai
```

### Penjelasan Kelas

| Kelas | Peran |
|-------|-------|
| `UTSPBO` | Titik masuk program; menampilkan menu utama, menu siswa, dan menu pegawai |
| `Service` | Menyimpan data dalam `ArrayList` dan berisi seluruh operasi tambah, tampil, hapus, dan update |
| `KursusMengemudi` | Kelas induk berisi ID pendaftaran, nama siswa, no. telepon, dan jumlah pertemuan |
| `KursusManual` / `KursusMatic` | Menambahkan tarif, opsi sertifikat, dan perhitungan total biaya |
| `Pegawai` | Kelas induk berisi ID dan nama pegawai |
| `Instruktur` | Menambahkan atribut **spesialisasi** (Manual/Matic/Semua) |
| `Administrasi` | Menambahkan atribut **area tugas** (Front Office, Keuangan, dll.) |

---

## 3. Alur Program

### 3.1 Persyaratan
- **JDK 14 atau lebih baru** (program memakai sintaks `switch` dengan panah `->`).
- IDE seperti **NetBeans** (package `com.mycompany.uts.pbo` adalah bawaan NetBeans), IntelliJ IDEA, atau VS Code; atau cukup terminal.

### 3.2 Cara Menjalankan

**Melalui IDE (NetBeans):**
1. Buka NetBeans → *File* → *Open Project*, lalu pilih folder proyek.
2. Pastikan semua file di package `model` dan file `UTSPBO.java` berada di dalam proyek.
3. Klik kanan `UTSPBO.java` → **Run File** (atau tekan `Shift + F6`).

**Melalui Terminal:**
```bash
# dari folder src
javac model/*.java com/mycompany/uts/pbo/UTSPBO.java
java com.mycompany.uts.pbo.UTSPBO
```

### 3.3 Cara Kerja Sistem

Saat program dijalankan, `Service` otomatis memuat **data dummy**:

| Jenis | Data |
|-------|------|
| Siswa | 101 – Nazmi Ramadani (Manual, 5 pertemuan, dengan sertifikat) |
| Siswa | 102 – Diandra Riskita (Matic, 4 pertemuan, tanpa sertifikat) |
| Pegawai | P01 – Pak Joko (Instruktur, Manual) |
| Pegawai | P02 – Ani Lestari (Administrasi, Front Office & Keuangan) |

**Diagram alur menu:**

```
                 ┌──────────────────────────────┐
                 │  Sistem Manajemen Kursus     │
                 │        Mengemudi             │
                 └──────────────┬───────────────┘
        ┌───────────────────────┼───────────────────────┐
        ▼                       ▼                       ▼
 1. Kelola Kursus        2. Kelola Pegawai          3. Keluar
    (Siswa)
   ├ 1. Tambah Siswa      ├ 1. Tambah Pegawai
   ├ 2. Tampilkan Siswa   ├ 2. Tampilkan Pegawai
   ├ 3. Hapus Siswa       ├ 3. Update Pegawai
   ├ 4. Update Siswa      └ 4. Kembali
   └ 5. Kembali
```

**Langkah penggunaan:**

1. **Menu Utama** – pilih `1` (Siswa), `2` (Pegawai), atau `3` (Keluar).
2. **Tambah Siswa** – masukkan ID pendaftaran, nama, no. telepon, jumlah pertemuan, tipe kursus (`1` Manual / `2` Matic), lalu pilih apakah butuh sertifikat SIM (`y`/`n`).
3. **Tampilkan Siswa** – menampilkan seluruh siswa beserta rincian tarif dan **total biaya**.
4. **Hapus Siswa** – masukkan ID pendaftaran yang ingin dihapus.
5. **Update Siswa** – masukkan ID pendaftaran, lalu isi nama baru dan jumlah pertemuan baru.
6. **Tambah Pegawai** – masukkan ID, nama, dan jabatan (`1` Instruktur / `2` Administrasi), lalu isi spesialisasi atau area tugas.
7. **Tampilkan Pegawai** – menampilkan profil semua pegawai.
8. **Update Pegawai** – masukkan ID pegawai, isi nama baru, lalu pilih apakah ingin memperbarui data spesifik jabatan (spesialisasi/area tugas). Sistem memilih method *overloading* yang sesuai secara otomatis.
9. **Keluar** – program berhenti dan `Scanner` ditutup.

## 4. Penjelasan Gambar (Screenshot Output)

### 4.1 Menu Utama

<img width="437" height="119" alt="Screenshot 2026-09-28 113011" src="https://github.com/user-attachments/assets/0d450f10-ae6d-426e-9eef-7c4511e601ef" />

Tampilan awal program. Pengguna memilih antara kelola siswa (1), kelola pegawai (2), atau keluar (3).

### 4.2 Menu Kelola Kursus (Siswa)




