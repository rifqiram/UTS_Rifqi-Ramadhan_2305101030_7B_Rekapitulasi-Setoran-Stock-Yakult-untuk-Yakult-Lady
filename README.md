# UTS_Rifqi_Ramadhan_2305101030_7B_Rekapitulasi-Setoran-Stok-Yakult-untuk-Yakult-Lady

## Identitas Mahasiswa

- Nama: Rifqi Ramadhan
- NIM: 2305101030
- Kelas: 7B
- Program Studi: Teknik Informatika
- Mata Kuliah: Pemrograman Mobile
- Tahun Akademik: 2026/2027

## Deskripsi

Repository ini berisi source code, dokumentasi, dan hasil implementasi aplikasi mobile untuk pengerjaan Ujian Tengah Semester (UTS) mata kuliah Pemrograman Mobile. Aplikasi yang dibuat adalah sistem pencatatan dan rekapitulasi setoran stok Yakult untuk kebutuhan Yakult Lady agar proses pencatatan penerimaan stok menjadi lebih rapi, cepat, dan mudah dipantau.

## Deskripsi Pengerjaan UTS

Aplikasi mobile ini dibuat untuk membantu Yakult Lady mencatat data penerimaan barang berdasarkan varian Yakult, menghitung total stok yang masuk, serta menampilkan riwayat penerimaan secara terstruktur. Proyek ini dibuat dalam bentuk aplikasi Android berbasis Kotlin dengan UI modern menggunakan Jetpack Compose, yang menekankan kemudahan penggunaan dan tampilan yang sesuai kebutuhan pengguna.

## Teknologi yang Digunakan

- Bahasa Pemrograman: Kotlin
- Framework: Android Jetpack Compose
- Tools: Android Studio, Gradle, Kotlin DSL, Material 3
- Design: Figma
- Database: Belum tersedia

## Fitur yang Diimplementasikan

1. Dashboard ringkasan penerimaan stok bulanan.
2. Form tambah penerimaan dengan input per varian Yakult.
3. Validasi jumlah penerimaan minimal satu varian lebih dari 0.
4. Rekapitulasi total penerimaan secara real-time.
5. Riwayat penerimaan stok dengan tampilan daftar data.
6. Menu bantuan untuk panduan penggunaan aplikasi.

## Struktur Folder

```bash
UTS/
├── README.md
├── Screenshot/
│   ├── 01-Dashboard.png
│   ├── 02-Tambah Penerimaan 1.png
│   ├── 03-Bantuan.png
│   ├── 03-Tambah Penerimaan 2.png
│   ├── 04-Riwayat Penerimaan 1.png
│   ├── 05-Riwayat Penerimaan 2.png
│   └── 06-Detail Riwayat Penerimaan.png
├── Figma/
│   └── screenshots/
├── Perancangan Aplikasi Mobile Pencatatan dan Rekapitulasi Setoran Stok Yakult untuk Yakult Lady/
│   ├── app/
│   ├── build.gradle.kts
│   ├── gradle.properties
│   ├── gradlew
│   ├── gradlew.bat
│   ├── local.properties
│   ├── README.md
│   ├── settings.gradle.kts
│   └── .idea/
└── ...
```

## Persyaratan Menjalankan Aplikasi

- Android Studio terbaru (disarankan versi stabil terbaru)
- JDK 17
- Android SDK yang sudah terinstall
- Emulator Android atau perangkat fisik untuk menjalankan aplikasi
- Koneksi internet untuk proses download dependency saat sync Gradle pertama kali

## Cara Menjalankan Aplikasi

1. Buka folder `Perancangan Aplikasi Mobile Pencatatan dan Rekapitulasi Setoran Stok Yakult untuk Yakult Lady` di Android Studio.
2. Tunggu proses sync Gradle selesai.
3. Pastikan Android SDK dan emulator/handphone sudah tersedia.
4. Klik tombol `Run 'app'` atau pilih `Build > Run` untuk menjalankan aplikasi.
5. Jika ingin membuat file APK secara manual, jalankan perintah:

```bash
./gradlew assembleDebug
```

## Screenshot Hasil Implementasi

Lokasi screenshot hasil implementasi aplikasi tersedia pada folder `Screenshot/`:

- [Screenshot/01-Dashboard.png](Screenshot/01-Dashboard.png)
- [Screenshot/02-Tambah Penerimaan 1.png](Screenshot/02-Tambah%20Penerimaan%201.png)
- [Screenshot/03-Bantuan.png](Screenshot/03-Bantuan.png)
- [Screenshot/03-Tambah Penerimaan 2.png](Screenshot/03-Tambah%20Penerimaan%202.png)
- [Screenshot/04-Riwayat Penerimaan 1.png](Screenshot/04-Riwayat%20Penerimaan%201.png)
- [Screenshot/05-Riwayat Penerimaan 2.png](Screenshot/05-Riwayat%20Penerimaan%202.png)
- [Screenshot/06-Detail Riwayat Penerimaan.png](Screenshot/06-Detail%20Riwayat%20Penerimaan.png)

## File APK

File APK belum tersedia pada repository saat ini. APK dapat dibuat secara lokal melalui Android Studio atau perintah Gradle seperti:

```bash
./gradlew assembleDebug
```

Output APK biasanya berada di folder:

```bash
app/build/outputs/apk/debug/
```

## Referensi

- Dokumentasi Android Developers
- Jetpack Compose Documentation
- Material 3 Design Guidelines
- Desain UI dan prototyping dibuat menggunakan Figma

