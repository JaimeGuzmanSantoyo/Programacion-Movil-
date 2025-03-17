/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author josej
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class paneldeimagen extends JPanel {
    Image imageDada;
    Image icono;
    String ruta;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        icono = new ImageIcon(ruta).getImage(); // Corregir creación de ImageIcon
        imageDada = icono;

        g.drawImage(imageDada, 1, 1, 400, 400, this); // Corregir parámetros de drawImage
    }
    public void  setRuta(String ruta){
        this.ruta = ruta; 
    }
}
