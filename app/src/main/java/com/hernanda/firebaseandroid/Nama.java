package com.hernanda.firebaseandroid;

public class Nama {
    String id, kelas, nama;

    public Nama(String id, String kelas, String nama) {
        this.id = id;
        this.kelas = kelas;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
