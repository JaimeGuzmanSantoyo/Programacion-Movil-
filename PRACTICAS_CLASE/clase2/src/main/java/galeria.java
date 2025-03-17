import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JPanel;
public class galeria extends JFrame {
     paneldeimagen  pimg;
    public galeria() {
        JPanel  pimg;
        setSize(250, 300);
        setTitle("galeria imagenes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        pimg = new paneldeimagen();
        ((paneldeimagen)pimg).setRuta("");
        add(pimg);
    }

    public static void main(String[] args) {
        galeria ventana = new galeria();
        ventana.setVisible(true);
    }}