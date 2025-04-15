public static void main(String[] args) {
    Cronometro2 c = new Cronometro2();
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(btnIniciar)) {
        btnActivo = true;
        hc = new HiloContador();
        hc.start();
    }

    if (e.getSource().equals(btnReiniciar)) {
        btnActivo = false;
        contador = 0;
        etiquetaContador.setText(contador + "");
    }
}

private class HiloContador extends Thread {
    public void run() {
        while (true) {
            try {
                if (btnActivo) {
                    contador++;
                    System.out.println(contador);
                    etiquetaContador.setText(contador + "");
                    Thread.sleep(100);
                }
            } catch (Exception e) {}
        }
    }
}
