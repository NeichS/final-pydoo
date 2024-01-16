package Swing;

import AppClasses.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Swing.VentanaPrincipal.customPanelTop;

public class PanelAlumno extends VentanaPrincipal{
    private Student alumnoCliente;
    public JPanel adminAlumnoPanel;
    public CardLayout cardLayout;
    public JPanel cardPanel;
    PanelAlumno(CardLayout cardLayout, JPanel cardPanel) {
        super(VentanaPrincipal.cardLayout, VentanaPrincipal.cardPanel);
        adminAlumnoPanel = new JPanel();
        adminAlumnoPanel.setLayout(new BorderLayout()); // Set layout
        adminAlumnoPanel.setBackground(Color.decode("#292929")); // Set background color

        JLabel message = new JLabel("Welcome!"); // Add a welcome message or any default content
        adminAlumnoPanel.add(message, BorderLayout.CENTER);
    }
    public JPanel createMenuAlumnoPanel() {
        adminAlumnoPanel.removeAll();
        adminAlumnoPanel.setLayout(new BorderLayout());
        adminAlumnoPanel.setBackground(Color.decode("#292929"));
        System.out.println(alumnoCliente.getNombre());
        JPanel panelTop = customPanelTop("Bienvenido " + alumnoCliente.getNombre());
        adminAlumnoPanel.add(panelTop, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.add(Box.createVerticalStrut(100));

        //center panel buttons
        CustomButton signCareer = new CustomButton("Inscripcion carrera", "#494949", 180);

        signCareer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        centerPanel.add(signCareer);
        centerPanel.add(Box.createVerticalStrut(10));
        signCareer.setAlignmentX(Component.CENTER_ALIGNMENT);
        CustomButton signSubject = new CustomButton("Inscripcion materia", "#494949", 180);
        signSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "INSCRIPCION MATERIA");
            }
        });
        centerPanel.add(signSubject);
        centerPanel.add(Box.createVerticalStrut(10));
        signSubject.setAlignmentX(Component.CENTER_ALIGNMENT);
        CustomButton viewCareerProgress = new CustomButton("Progreso carrera", "#494949", 180);
        viewCareerProgress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "PROGRESO CARRERA");
            }
        });
        centerPanel.add(viewCareerProgress);
        centerPanel.add(Box.createVerticalStrut(10));
        viewCareerProgress.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminAlumnoPanel.add(centerPanel, BorderLayout.CENTER);

        adminAlumnoPanel.setVisible(true);

        return adminAlumnoPanel;
    }

    public void setAlumnoCliente(Student alumno) {
        this.alumnoCliente = alumno;
    }

    public void update() {
        this.adminAlumnoPanel.revalidate();
        this.adminAlumnoPanel.repaint();
    }


}
