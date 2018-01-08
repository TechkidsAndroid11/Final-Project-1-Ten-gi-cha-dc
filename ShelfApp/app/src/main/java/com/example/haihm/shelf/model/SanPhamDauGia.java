package com.example.haihm.shelf.model;

/**
 * Created by Trần_Tân on 08/01/2018.
 */

public class SanPhamDauGia extends SanPhamRaoVat {
    public double buocGia;
    public double giaCaoNhat;
    public int thoiGian;
    public NguoiMua nguoiMua;

    private class NguoiMua {
        public String ten;
        public String avatar;
    }
}
