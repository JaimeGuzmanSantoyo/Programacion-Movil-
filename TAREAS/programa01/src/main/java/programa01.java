import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class programa01 extends JFrame implements ActionListener {

    private JButton btnSaludar;

    public programa01() {
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnSaludar = new JButton("Saludar");
        btnSaludar.addActionListener(this); // Agregar ActionListener al botón
        
        setTitle("programa01");
        add(btnSaludar, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Crear instancia de programa01 y hacerla visible
        programa01 frame = new programa01();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JOptionPane.showMessageDialog(null, "¡Hola panaaaaas!"+text01.getext());
        
    }
    
}
