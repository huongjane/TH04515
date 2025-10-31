package org.example.Service;

import org.example.Entity.Sach;

public class SachService {

    public void suaSach(Sach sach, String maSach, String tenSach, String tacGia, Integer namXuatBan, Float gia) {
        if (maSach == null || maSach.isBlank()
                || tenSach == null || tenSach.isBlank()
                || tacGia == null || tacGia.isBlank()
                || namXuatBan == null
                || gia == null) {
            throw new IllegalArgumentException("Các trường không được để trống.");
        }

        if (namXuatBan < 1990 || namXuatBan > 2025) {
            throw new IllegalArgumentException("Năm xuất bản phải nằm trong khoảng 1990–2025.");
        }

        sach.setMaSach(maSach);
        sach.setTenSach(tenSach);
        sach.setTacGia(tacGia);
        sach.setNamXuatBan(namXuatBan);
        sach.setGia(gia);
    }
}
