package main;

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
        JDesktopPane p1 = new JDesktopPane();
        JDesktopPane p2 = new JDesktopPane();
        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());


        JLabel l1 = new JLabel();
        JLabel logo = new JLabel();
        JLabel l2 = new JLabel();

        Image foo = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/asfaleia.jpg"))).getImage();

        Image tmp = new ImageIcon(Objects.requireNonNull(cldr.getResource("resources/images/logo.png"))).getImage();

        p.setLayout(new BorderLayout(20,20));

        l2.setIcon(new ImageIcon(tmp));
        logo.setIcon(new ImageIcon(tmp));
        l1.setIcon(new ImageIcon(foo));

        //logo.setBounds(new Rectangle(new Point(0, 0),logo.getPreferredSize()));

        p.add(logo, BorderLayout.PAGE_START);
        p1.add(l1, BorderLayout.PAGE_START);
        p2.add(l2, BorderLayout.CENTER);
        p.add(p1, BorderLayout.EAST);
        p.add(p2, BorderLayout.EAST);


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
