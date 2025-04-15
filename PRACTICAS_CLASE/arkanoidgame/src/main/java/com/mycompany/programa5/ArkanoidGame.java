import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArkanoidGame extends JPanel implements MouseMotionListener, ActionListener {
    Timer timer;
    int ballX = 250, ballY = 250;
    int ballVelX = 2, ballVelY = 2;
    int paddleX = 200, paddleY = 550;
    int paddleWidth = 100, paddleHeight = 20;
    boolean isGameOver = false;

    Rectangle[][] blocks;
    int blockWidth = 60, blockHeight = 20;
    int rows = 3, cols = 5;

    public ArkanoidGame() {
        setBackground(Color.BLACK);
        addMouseMotionListener(this);

        blocks = new Rectangle[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                blocks[i][j] = new Rectangle(j * (blockWidth + 10) + 30, i * (blockHeight + 5) + 30, blockWidth, blockHeight);
            }
        }

        timer = new Timer(5, this);
        timer.start();
    }

    @Override
    public void mouseDragged(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {
        paddleX = e.getX() - paddleWidth / 2;
        if (paddleX < 0) paddleX = 0;
        if (paddleX > getWidth() - paddleWidth) paddleX = getWidth() - paddleWidth;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isGameOver) return;

        ballX += ballVelX;
        ballY += ballVelY;

        if (ballX <= 0 || ballX >= getWidth() - 10) ballVelX = -ballVelX;
        if (ballY <= 0) ballVelY = -ballVelY;

        Rectangle ballRect = new Rectangle(ballX, ballY, 10, 10);
        Rectangle paddleRect = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
        
        if (ballRect.intersects(paddleRect)) {
            ballVelY = -ballVelY;
            ballY = paddleY - 10;
        }

        if (ballY >= getHeight()) isGameOver = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (blocks[i][j] != null && blocks[i][j].intersects(ballRect)) {
                    ballVelY = -ballVelY;
                    blocks[i][j] = null; // Eliminar el bloque correctamente
                }
            }
        }

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(ballX, ballY, 10, 10);
        g.setColor(Color.blue);
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);

        g.setColor(Color.green);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (blocks[i][j] != null) {
                    g.fillRect(blocks[i][j].x, blocks[i][j].y, blockWidth, blockHeight);
                }
            }
        }

        if (isGameOver) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", getWidth() / 2 - 100, getHeight() / 2);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Arkanoid Game");
        ArkanoidGame ag = new ArkanoidGame();
        frame.add(ag);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}