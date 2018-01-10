package com.example.haihm.shelf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trần_Tân on 08/01/2018.
 */

public class SanPhamDauGia extends SanPhamRaoVat {
    public double buocGia;
    public double giaCaoNhat;
    public int thoiGian;
    public NguoiMua nguoiMua;

    public SanPhamDauGia() {
    }

    public SanPhamDauGia(String idSP, String tenSP, List<String> anhSP, double giaSP, String motaSP, String loaiSP, double buocGia, double giaCaoNhat, int thoiGian, NguoiMua nguoiMua) {
        super(idSP, tenSP, anhSP, giaSP, motaSP, loaiSP);
        this.buocGia = buocGia;
        this.giaCaoNhat = giaCaoNhat;
        this.thoiGian = thoiGian;
        this.nguoiMua = nguoiMua;
    }

    public static class NguoiMua {
        public String ten;
        public String avatar;

        public NguoiMua() {
        }
    }
}
