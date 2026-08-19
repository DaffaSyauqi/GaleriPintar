# Galeri Pintar

Galeri Pintar adalah aplikasi desktop berbasis Java Swing yang digunakan untuk mengelola koleksi gambar secara terstruktur. Aplikasi ini memungkinkan pengguna untuk mengelola data gambar, mengelompokkan gambar berdasarkan kategori, serta melakukan pencarian dan penyaringan data.

Aplikasi ini dibuat sebagai Tugas Besar dengan menerapkan konsep CRUD, database MySQL, JDBC, dan GUI Builder pada NetBeans.

## Teknologi yang Digunakan

- Java
- Java Swing
- NetBeans IDE
- Java GUI Builder
- MySQL
- JDBC
- Apache Ant

## Struktur Project

GaleriPintar/
├── src/
│   ├── config/
│   │   └── DatabaseConnection.java
│   │
│   ├── dao/
│   │   ├── CategoryDAO.java
│   │   ├── ImageDAO.java
│   │   └── UserDAO.java
│   │
│   ├── model/
│   │   ├── Category.java
│   │   ├── Image.java
│   │   └── User.java
│   │
│   └── view/
│       ├── HomeFrame.java
│       ├── CategoryFrame.java
│       ├── ImageFrame.java
│       └── UserFrame.java
│
├── nbproject/
├── uploads/
├── build.xml
└── manifest.mf

## Instalasi

### 1. Clone Repository

git clone https://github.com/DaffaSyauqi/GaleriPintar.git

### 2. Buka Project

Buka project menggunakan NetBeans IDE.

### 3. Tambahkan MySQL JDBC Driver

Tambahkan MySQL Connector/J melalui:

Project Properties
→ Libraries
→ Add JAR/Folder

Kemudian pilih file .jar dari MySQL Connector/J.

### 4. Buat Database

Buat database galeripintar dan tabel-tabel yang diperlukan menggunakan MySQL.

### 5. Konfigurasi Database

Sesuaikan konfigurasi pada:

DatabaseConnection.java

dengan username, password, host, dan port MySQL yang digunakan.

### 6. Jalankan Aplikasi

Jalankan project melalui NetBeans.

Class utama aplikasi:

galeripintar.GaleriPintar

## Arsitektur

Aplikasi menggunakan pemisahan sederhana antara Model, DAO, Configuration, dan View.

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

### Model

Berfungsi merepresentasikan data yang digunakan aplikasi, seperti:

- Category
- Image
- User

### DAO

Berfungsi menangani komunikasi dan operasi CRUD terhadap database, seperti:

- CategoryDAO
- ImageDAO
- UserDAO

### View

Berfungsi sebagai antarmuka pengguna menggunakan Java Swing:

- HomeFrame
- CategoryFrame
- ImageFrame
- UserFrame

### Database Connection

DatabaseConnection digunakan untuk membuat koneksi antara aplikasi Java dengan database MySQL menggunakan JDBC.
