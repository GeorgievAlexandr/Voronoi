import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class Display {
    public static int WIDTH = 800;
    public static int HEIGHT = 800;
    JFrame window = new JFrame();


    public Display(int Width, int Height) {
        Display.WIDTH = Width;
        Display.HEIGHT = Height;
        openWindow();
    }

    public Display() {
        openWindow();
    }

    private void openWindow(){
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(Display.WIDTH, Display.HEIGHT);
        window.setResizable(false);
        window.setVisible(true);
    }

    public void renderP(){
        Graphics g = window.getGraphics();
        Image image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g2 = image.getGraphics();
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, WIDTH, HEIGHT);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                g2.setColor(new Color(PerlinNoise.getNoise(x, y), PerlinNoise.getNoise(x, y), PerlinNoise.getNoise(x, y)));
                g2.fillRect(x, y, 1, 1);
            }
        }
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
    }

    public void render(float[][][] pixels) {
        Graphics g = window.getGraphics();
        Image image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g2 = image.getGraphics();
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, WIDTH, HEIGHT);
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                Color color = new Color(pixels[x][y][0],pixels[x][y][1],pixels[x][y][2]);
                g2.setColor(color);
                g2.fillRect(x, y, 1, 1);
            }
        }
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
    }
}
