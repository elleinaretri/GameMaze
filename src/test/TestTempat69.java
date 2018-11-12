/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import model.Tempat2;

/**
 *
 * @author ASUS
 */
public class TestTempat69 {
    public static void main(String[] args) {
        Tempat2 test = new Tempat2();
        test.bacaKonfigurasi(new File("tempat2.txt"));
        System.out.println(test.getIsi());
}
}
