package com.example.haihm.shelf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trần_Tân on 08/01/2018.
 */

public class SanPhamRaoVat {
    public String idSP;
    public String tenSP;
    public List<String> anhSP ;
    public double giaSP;
    public String motaSP;
    public String loaiSP;

    public SanPhamRaoVat(String idSP, String tenSP, List<String> anhSP, double giaSP, String motaSP, String loaiSP) {
        this.idSP = idSP;
        this.tenSP = tenSP;
        this.anhSP = anhSP;
        this.giaSP = giaSP;
        this.motaSP = motaSP;
        this.loaiSP = loaiSP;
    }

    public SanPhamRaoVat() {
    }
}
