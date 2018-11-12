/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Tempat2;

/**
 *
 * @author ASUS
 */
public class TestTempat99 {
   public static void main(String[] args) {
        Tempat2 test = new Tempat2();
        test.setIsi("ini isi dokumen");
        System.out.println(test.getIsi());
        int jumlahKata = test.hitungJumlahKress();
        System.out.println("Jumlah kata = "+jumlahKata);
    }
 
}
