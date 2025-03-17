import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class programa03 extends JFrame {
    PanelBolita panelbolita;
    JLabel labelCoordenadas;
    JLabel labelMensaje; // Label para el mensaje de "Ganador" o "Falta, falta"

    public programa03() {
        setTitle("bolita 01 ");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelCoordenadas = new JLabel("Coordenadas: (100, 100)");
        labelMensaje = new JLabel("Falta, falta"); // Inicializar el label con el mensaje predeterminado
        
        add(labelCoordenadas, BorderLayout.SOUTH); // Asegúrate de usar BorderLayout.SOUTH
        add(labelMensaje, BorderLayout.NORTH); // Agregar el label del mensaje en la parte superior

        panelbolita = new PanelBolita(labelCoordenadas, labelMensaje);
        add(panelbolita);
    }

    public static void main(String[] args) {
        programa03 p = new programa03();
        p.setVisible(true);
    }
}
