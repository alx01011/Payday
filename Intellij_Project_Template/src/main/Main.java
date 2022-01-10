package main;

import jdk.nashorn.internal.scripts.JD;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Main {


    public static void main(String[] args) throws IOException {

        JFrame f = new JFrame("Test");

        ClassLoader cldr = ClassLoader.getSystemClassLoader();

        Image bg = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/bg_green.png"))).getImage();

        customPanel p = new customPanel(bg.getScaledInstance(1500, 850, Image.SCALE_SMOOTH));

        JLabel logo = new JLabel();

        Image tmp = new ImageIcon(cldr.getResource("resources/images/logo.png")).getImage();

        logo.setIcon(new ImageIcon(tmp));

        logo.setBounds(new Rectangle(new Point(0, 0),logo.getPreferredSize()));

        p.add(logo);


        f.setVisible(true);
        f.add(p);
        p.paintComponent(p.getGraphics());
        f.setPreferredSize(new Dimension(1500, 850));
        f.pack();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    static class customPanel extends JDesktopPane {

        private final Image image;

        customPanel(Image image)
        {
            this.image = image;
        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);

        }
    }

}
