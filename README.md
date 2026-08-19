# Galeri Pintar

**Galeri Pintar** adalah aplikasi desktop berbasis **Java Swing** untuk mengelola koleksi gambar secara terstruktur. Aplikasi ini memungkinkan pengguna untuk mengelola data gambar, mengelompokkan gambar berdasarkan kategori, serta melakukan pencarian dan penyaringan data.

Aplikasi ini dibuat sebagai **Tugas Besar** dengan menerapkan konsep **CRUD**, database **MySQL**, **JDBC**, dan **GUI Builder** pada NetBeans.

## Fitur

- Manajemen data gambar (tambah, ubah, hapus, lihat)
- Pengelompokan gambar berdasarkan kategori
- Pencarian dan penyaringan data gambar
- Manajemen pengguna (User)
- Antarmuka grafis yang mudah digunakan

## Teknologi yang Digunakan

| Teknologi | Kegunaan |
|-----------|----------|
| Java | Bahasa pemrograman utama |
| Java Swing | Antarmuka pengguna (GUI) |
| NetBeans IDE | Pengembangan dan GUI Builder |
| MySQL | Basis data penyimpanan data |
| JDBC | Koneksi aplikasi ke database |
| Apache Ant | Build tool project |

## Struktur Project

```
GaleriPintar/
├── src/
│   ├── config/
│   │   └── DatabaseConnection.java
│   ├── dao/
│   │   ├── CategoryDAO.java
│   │   ├── ImageDAO.java
│   │   └── UserDAO.java
│   ├── model/
│   │   ├── Category.java
│   │   ├── Image.java
│   │   └── User.java
│   └── view/
│       ├── HomeFrame.java
│       ├── CategoryFrame.java
│       ├── ImageFrame.java
│       └── UserFrame.java
├── nbproject/
├── uploads/
├── build.xml
└── manifest.mf
```

## Instalasi

### 1. Clone Repository

```bash
git clone https://github.com/DaffaSyauqi/GaleriPintar.git
```

### 2. Buka Project

Buka project menggunakan **NetBeans IDE**.

### 3. Tambahkan MySQL JDBC Driver

Tambahkan **MySQL Connector/J** melalui:

```
Project Properties → Libraries → Add JAR/Folder
```

Kemudian pilih file `.jar` dari MySQL Connector/J.

### 4. Buat Database

Buat database `galeripintar` beserta tabel-tabel yang diperlukan menggunakan MySQL.

### 5. Konfigurasi Database

Sesuaikan konfigurasi koneksi pada file `DatabaseConnection.java` dengan username, password, host, dan port MySQL yang digunakan.

### 6. Jalankan Aplikasi

Jalankan project melalui NetBeans.

Class utama aplikasi:

```java
galeripintar.GaleriPintar
```

## Arsitektur

Aplikasi menggunakan pemisahan sederhana antara **Model**, **DAO**, **Configuration**, dan **View**.

```
View
 │
 ▼
 DAO
 │
 ▼
Model
 │
 ▼
MySQL Database
```

### Model

Merepresentasikan data yang digunakan aplikasi, seperti:

- `Category`
- `Image`
- `User`

### DAO (Data Access Object)

Menangani komunikasi dan operasi **CRUD** terhadap database, seperti:

- `CategoryDAO`
- `ImageDAO`
- `UserDAO`

### View

Sebagai antarmuka pengguna menggunakan **Java Swing**:

- `HomeFrame`
- `CategoryFrame`
- `ImageFrame`
- `UserFrame`

### Database Connection

`DatabaseConnection` digunakan untuk membuat koneksi antara aplikasi Java dengan database MySQL menggunakan **JDBC**.

## Lisensi

Tidak ada lisensi yang ditentukan untuk project ini.

---

Dibuat oleh **Daffa Syauqi** sebagai Tugas Besar.