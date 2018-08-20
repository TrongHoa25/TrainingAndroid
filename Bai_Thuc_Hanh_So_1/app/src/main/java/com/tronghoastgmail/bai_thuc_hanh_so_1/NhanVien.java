package com.tronghoastgmail.bai_thuc_hanh_so_1;


public class NhanVien {
    private String hoten;
    private int tuoi;
    private double hesoluong;

    public NhanVien(String hoten, int tuoi, double hesoluong) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.hesoluong = hesoluong;
    }

    public NhanVien() {
    }

    public String getHoTen() {
        return hoten;
    }

    public void setHoTen(String hoten) {
        this.hoten = hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public double getHeSoLuong() {
        return hesoluong;
    }

    public void setHeSoLuong(double hesoluong) {
        this.hesoluong = hesoluong;
    }
    public double TinhLuong(){
        double luong;
        luong = 1250000 * hesoluong;
        return luong;
    }

    @Override
    public String toString() {
        return "Tên : " + hoten + "\n"
                +"Tuổi : "+ tuoi + "\n"+
                "Lương : "+ TinhLuong();
    }
}
