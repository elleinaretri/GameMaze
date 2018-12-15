/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Sel;
import model.Tempat;

/**
 *
 * @author user only
 */
public class GameFrame extends JFrame {
   

    Tempat tempat = new Tempat();

    private TempatPanel tempatPanel;

    private JLabel perintahlabel;
    private JTextField perintahText;
    private JButton pindahKananButton, pindahKiriButton, pindahAtasButton, pindahBawahButton;
     private JButton okButton;
    private JButton tambahButton;
    private JButton hapusButton;

    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem bacaKonfigurasiMenuItem, SimpanKonfigurasiMenuItem;

public GameFrame(String title) {
        this.setTitle(title);
        this.init();
    }

    public GameFrame(String title, TempatPanel tempatPanel) {
        setTitle(title);
        this.tempatPanel = tempatPanel;
        this.init();
    }

    public void init() {
        // set ukuran dan layout
        this.setSize(500, 300);
        this.setLayout(new BorderLayout());

        // set menu Bar
        menuBar = new JMenuBar();
        gameMenu = new JMenu("GAME");
        exitMenuItem = new JMenuItem("KELUAR");
        bacaKonfigurasiMenuItem = new JMenuItem("BACA");
        SimpanKonfigurasiMenuItem = new JMenuItem("SIMPAN");
        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(SimpanKonfigurasiMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        //action perfom for bacaKonfigurasiMenuItem
        bacaKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jf = new JFileChooser();
                int returnVal = jf.showOpenDialog(null);
                Tempat tempat = new Tempat();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    tempat.bacaKonfigurasi(jf.getSelectedFile());
                }
                Tempat.batasKanan = 500;
                Tempat.batasBawah = 300;
                // buat tempatPanel dan tambahkan tempat ke tempatPanel
                tempatPanel = new TempatPanel();
                tempatPanel.setTempat(tempat);
                init();
            }
        }
        );

        SimpanKonfigurasiMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        }
        );

        //action perform for exitMenuItem
        exitMenuItem.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                System.exit(0);
            }
        }
        );

        JPanel southPanel = new JPanel();

        southPanel.setLayout(
                new FlowLayout());

        this.perintahlabel = new JLabel("PERINTAH");

        southPanel.add(perintahlabel);

        this.perintahText = new JTextField(20);

        southPanel.add(perintahText);

        this.okButton = new JButton("OK");

        southPanel.add(okButton);

        okButton.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                if ("L".equalsIgnoreCase(perintahText.getText())) {
                    pindahKiri();
                } else if ("R".equalsIgnoreCase(perintahText.getText())) {
                    pindahKanan();
                } else if ("U".equalsIgnoreCase(perintahText.getText())) {
                    pindahAtas();
                } else if ("D".equalsIgnoreCase(perintahText.getText())) {
                    pindahBawah();
                }
            }
        }
        );

 
        Container cp = this.getContentPane();
        if (tempatPanel
                != null) {
            cp.add(getTempatPanel(), BorderLayout.CENTER);
        }

        cp.add(southPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
    public void pindahKanan() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan();
            }
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahKiri() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri();
            }
        }
        getTempatPanel().repaint();
    }

    public void pindahAtas() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas();
            }
        }
        getTempatPanel().repaint();
    }

    public void pindahBawah() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            if (getTempatPanel().getTempat().getDaftarSel().get(i).getNilai() == '@') {
                getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah();
            }
        }
        getTempatPanel().repaint();
    }

    public TempatPanel getTempatPanel() {
        return tempatPanel;
    } 
    public void setTempatPanel(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
    }

}
