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
| Siswa | 102 – Anantha Hanif (Matic, 4 pertemuan, tanpa sertifikat) |
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

<img width="466" height="142" alt="Screenshot 2026-09-28 113610" src="https://github.com/user-attachments/assets/114004d8-9cf3-4c9d-ab97-5efe7b8a4189" />

Submenu untuk mengelola data siswa: tambah, tampilkan, hapus, update, dan kembali ke menu utama.

### 4.3 Tampilkan Data Siswa

Menampilkan seluruh siswa. Contoh keluaran data dummy:

<img width="612" height="508" alt="image" src="https://github.com/user-attachments/assets/e8847920-e1f3-4e62-87c9-0711778318a5" />

### 4.4 Tambah Data Siswa

<img width="481" height="286" alt="image" src="https://github.com/user-attachments/assets/8d16acf1-82b6-42c3-8081-17458244a0b1" />

Proses input data siswa baru, mulai dari ID, nama, telepon, jumlah pertemuan, tipe kursus, hingga pilihan sertifikat. Program menampilkan pesan konfirmasi setelah data berhasil ditambahkan.

### 4.5 Hapus dan Update Data Siswa

<img width="475" height="193" alt="image" src="https://github.com/user-attachments/assets/f1b102b9-d81e-40ac-98b1-755ae618eab8" />

Menunjukkan penghapusan siswa berdasarkan ID (`Data berhasil dihapus`).

### 4.6 Update Data Siswa

<img width="487" height="234" alt="image" src="https://github.com/user-attachments/assets/0b2a7165-b3d8-4708-992f-5a5ad9073815" />

Menunjukkan pembaruan nama serta jumlah pertemuan (`Data berhasil diperbarui`). Jika ID tidak ada, muncul pesan `Data tidak ditemukan`.

### 4.7 Menu Kelola Pegawai

<img width="387" height="120" alt="image" src="https://github.com/user-attachments/assets/d6863ac5-1c7c-4579-89dc-791f39b765c3" />

Submenu untuk menambah, menampilkan, dan memperbarui data pegawai.

### 4.8 Tampilkan Data Pegawai

<img width="486" height="352" alt="image" src="https://github.com/user-attachments/assets/0530a0dc-8b04-493e-90ab-0a9630b7413c" />

Menampilkan profil pegawai dengan format berbeda sesuai jabatannya (contoh **polymorphism**):

### 4.9 Tambah Data

<img width="440" height="246" alt="image" src="https://github.com/user-attachments/assets/e6513c75-7da5-4529-b9e1-df4894a8f61d" />

Menunjukkan penambahan pegawai baru. Pesan yang muncul berbeda tergantung pilihan, misalnya seperti pada digambar.

### 4.10 Update Data Pegawai

<img width="592" height="228" alt="image" src="https://github.com/user-attachments/assets/baa36b98-2675-4cfb-847d-9a985a4703e1" />

Menunjukkan Update data pegawai. Pesan yang muncul berbeda tergantung pilihan, misalnya seperti pada digambar.

### 4.11 Keluar dari Program

<img width="626" height="227" alt="image" src="https://github.com/user-attachments/assets/de783faa-6e8b-4d97-85fe-b9f4842427c9" />

Setelah memilih menu `3`, program menampilkan pesan `Terima kasih telah menggunakan aplikasi ini.` dan berhenti.

---


