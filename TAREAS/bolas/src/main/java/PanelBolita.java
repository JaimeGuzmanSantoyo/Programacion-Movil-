import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;    // se hacen imports para usar ciertas librerías 
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBolita extends JPanel implements MouseMotionListener {
    int x = 100;
    int y = 100;  /// se establece el origen donde aparecerá la bolita 
    JLabel labelCoordenadas;
    JLabel labelMensaje;  // Label para mostrar el mensaje

    public PanelBolita(JLabel labelCoordenadas, JLabel labelMensaje) {
        this.labelCoordenadas = labelCoordenadas;    
        this.labelMensaje = labelMensaje;  // Inicializar el label del mensaje
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);    // se establecen las dimensiones de la bolita 
        g.fillOval(x, y, 40, 40);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();   // esto nos va a servir para poder mover la bolita con respecto al cursor 
        labelCoordenadas.setText("Coordenadas: (" + x + ", " + y + ")"); // lo que se hace es pintar las coordenadas con lo que se mueva en x y

        if (x == 150 && y == 150) {
            labelMensaje.setText("Ganador"); // Mostrar "Ganador" cuando x es 150 y y es 150
        } else {
            labelMensaje.setText("Falta, falta"); // Mostrar "Falta, falta" si no es 150
        }
        
        repaint(); // para poder pintar 
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        labelCoordenadas.setText("Coordenadas: (" + x + ", " + y + ")");

        if (x == 150 && y == 150) {
            labelMensaje.setText("Ganador"); // Mostrar "Ganador" cuando x es 150 y y es 150
        } else {
            labelMensaje.setText("Falta, falta"); // Mostrar "Falta, falta" si no es 150
        }
        
        repaint();
    }
}
