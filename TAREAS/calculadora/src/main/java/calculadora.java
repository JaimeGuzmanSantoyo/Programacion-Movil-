import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class calculadora extends JFrame implements ActionListener{
    JTextField pantalla;
    JButton botones[];
    JButton suma, resta, multiplicacion, division, igual, limpiar;
    String operacion;
    double num1, num2;
    
    public Calculadora(){
        setSize(400,600);
        setTitle("Casio");
        setDefaultCloseOperation(3);
        setLayout(null);
       
        Font f = new Font("Arial", Font.BOLD, 40);
       
        pantalla = new JTextField();
        pantalla.setBounds(10, 20, 360, 80);
        pantalla.setFont(f);
        pantalla.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        add(pantalla);
       
        int x=10, y=420;
        botones = new JButton[10];
        botones[0] = new JButton("0");
        botones[0].setBounds(x, y, 80, 80);
        botones[0].setFont(f);
        botones[0].addActionListener(this);
        add(botones[0]);
        y=320;  
        int contColumnas=1;
        for(int i=1;i<10;i++){
            botones[i] = new JButton(i+"");
            botones[i].setBounds(x, y, 80, 80);
            botones[i].addActionListener(this);
            botones[i].setFont(f);
            add(botones[i]);
            x=x+90;
            if(contColumnas==3){
                y=y-100;
                x=10;
                contColumnas=0;
            }            
            contColumnas = contColumnas+1;
        }
        
        suma = new JButton("+");
        suma.setBounds(280, 120, 80, 80);
        suma.setFont(f);
        suma.addActionListener(this);
        add(suma);
        
        resta = new JButton("-");
        resta.setBounds(280, 220, 80, 80);
        resta.setFont(f);
        resta.addActionListener(this);
        add(resta);
        
        multiplicacion = new JButton("*");
        multiplicacion.setBounds(280, 320, 80, 80);
        multiplicacion.setFont(f);
        multiplicacion.addActionListener(this);
        add(multiplicacion);
        
        division = new JButton("/");
        division.setBounds(280, 420, 80, 80);
        division.setFont(f);
        division.addActionListener(this);
        add(division);
        
        igual = new JButton("=");
        igual.setBounds(180, 420, 80, 80);
        igual.setFont(f);
        igual.addActionListener(this);
        add(igual);
        
        limpiar = new JButton("C");
        limpiar.setBounds(90, 420, 80, 80);
        limpiar.setFont(f);
        limpiar.addActionListener(this);
        add(limpiar);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botonPresionado = (JButton)e.getSource();
        
        if(botonPresionado == limpiar) {
            pantalla.setText("");
            operacion = "";
            num1 = num2 = 0;
        } else if(botonPresionado == igual) {
            num2 = Double.parseDouble(pantalla.getText());
            switch(operacion) {
                case "+": pantalla.setText(String.valueOf(num1 + num2)); break;
                case "-": pantalla.setText(String.valueOf(num1 - num2)); break;
                case "*": pantalla.setText(String.valueOf(num1 * num2)); break;
                case "/": pantalla.setText(String.valueOf(num1 / num2)); break;
            }
        } else if(botonPresionado == suma || botonPresionado == resta || botonPresionado == multiplicacion || botonPresionado == division) {
            num1 = Double.parseDouble(pantalla.getText());
            operacion = botonPresionado.getText();
            pantalla.setText("");
        } else {
            pantalla.setText(pantalla.getText() + botonPresionado.getText());
        }
    }
   
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        c.setVisible(true);
    }
}
