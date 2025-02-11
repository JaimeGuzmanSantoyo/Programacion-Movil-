import java.awt.Dialog;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author josej
 */
public class holamundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        JOptionPane.showConfirmDialog(null, "HOLAuwuwuwuwu") ; // se imprimme el mensaje en pantalla mediante un mensaje de confirmacion     
        String nombre = JOptionPane.showInputDialog("Dame tu nombre");    //se ingresa el nombre mediante el imputn que parte del Jopane con show input dialog muestra el dialogo en donde se mete el nonbre
        JOptionPane.showMessageDialog(null, "tu nombre; "+nombre );  //nos muestra el nombre escrito 
        
        
    }
    
   
}
