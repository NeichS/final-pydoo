package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdmin extends VentanaPrincipal{

    private JPanel adminCarreraPanel = new JPanel();

    PanelAdmin(String s) {
        super(s);
    }

    public JPanel createAdminCarreraPanel() {
        adminCarreraPanel.setLayout(new BorderLayout());
        JPanel topPanel = customPanelTop("Administracion");
        adminCarreraPanel.add(topPanel, BorderLayout.WEST);
        CustomButton salir = new CustomButton("Salir", "#116A9A", 110);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MENU");
            }
        });
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#292929"));

        leftPanel.add(salir);
        adminCarreraPanel.add(leftPanel, BorderLayout.WEST);
        adminCarreraPanel.add(topPanel, BorderLayout.NORTH);
        adminCarreraPanel.add(centerPanel, BorderLayout.CENTER);
        return adminCarreraPanel;
    }

    public JPanel getAdminCarreraPanel() {
        return adminCarreraPanel;
    }
}
