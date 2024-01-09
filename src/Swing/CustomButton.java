package Swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton {

    private static class RoundBorder implements Border {
        private final int radius;

        RoundBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    CustomButton(String buttonText, String hexaColor, Integer maxSize) {
        super(buttonText);

        setPreferredSize(new Dimension(maxSize, 35));
        setMinimumSize(new Dimension(maxSize, 35));
        setMaximumSize(new Dimension(maxSize, 35));

        setBorderPainted(false);
        setBorder(new RoundBorder(15));
        Color colorFondo = Color.decode(hexaColor);

        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(true);

        setBackground(colorFondo);
        Font font = new Font("Arial", Font.PLAIN, 11);
        setFont(font);
        setForeground(Color.white);

        setMargin(new Insets(1, 0, 0, 1));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Cambiar el color al presionar el botón
                Font font = new Font("Arial", Font.PLAIN, 11); // Puedes ajustar el estilo y el tamaño
                setFont(font);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Font font = new Font("Arial", Font.PLAIN, 12); // Puedes ajustar el estilo y el tamaño
                setFont(font);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                // cambia la aparencia cuando el mouse realiza hover
                setBackground(Color.decode("#726C74"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // devuelve el boton al estado original
                setBackground(Color.decode(hexaColor));
            }
        });
    }
}
