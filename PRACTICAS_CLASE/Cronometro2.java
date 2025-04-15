import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cronometro implements ActionListener {

    JLabel etiquetaContador;
    JButton btnIniciar, btnReiniciar;
    int contador = 0;
    boolean btnActivo = false;
    HiloContador hc;

    public Cronometro() {
        JFrame ventana = new JFrame();
        ventana.setTitle("Cronómetro");
        ventana.setSize(300, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(3, 1));

        etiquetaContador = new JLabel("0");
        btnIniciar = new JButton("Iniciar");
        btnReiniciar = new JButton("Reiniciar");

        btnIniciar.addActionListener(this);
        btnReiniciar.addActionListener(this);

        p.add(etiquetaContador);
        p.add(btnIniciar);
        p.add(btnReiniciar);
        ventana.add(p);

        ventana.setVisible(true);

        // Inicializa el hilo pero no lo inicia aún
        hc = new HiloContador();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIniciar) {
            if (!btnActivo) {
                btnActivo = true;
                if (!hc.isAlive()) { // Si el hilo no está corriendo, lo inicia
                    hc.start();
                }
            }
        } else if (e.getSource() == btnReiniciar) {
            btnActivo = false;
            contador = 0;
            etiquetaContador.setText("0");
        }
    }

    public static void main(String[] args) {
        new Cronometro();
    }

    private class HiloContador extends Thread {
        public void run() {
            while (true) {
                try {
                    if (btnActivo) {
                        contador++;
                        etiquetaContador.setText(String.valueOf(contador));
                    }
                    Thread.sleep(100);  //Esto sirve para cambair la velocidad de conteo 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}