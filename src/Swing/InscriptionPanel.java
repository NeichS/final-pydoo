package Swing;

import AppClasses.Career;
import AppClasses.Student;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class InscriptionPanel extends VentanaPrincipal {
    private Student alumnoCliente;
    public JPanel inscriptionPanel;

    InscriptionPanel(String variable) {
        super(variable);
        inscriptionPanel = new JPanel();
        inscriptionPanel.setLayout(new BorderLayout());
        inscriptionPanel.setBackground(Color.decode("#292929"));

        JLabel message = new JLabel("Welcome!");
        inscriptionPanel.add(message, BorderLayout.CENTER);
    }

    public JPanel createCenterTopPanel() {
        JPanel centerTopPanel = new JPanel(new BorderLayout());
        centerTopPanel.setBackground(Color.decode("#116A9A"));
        centerTopPanel.setLayout(new BoxLayout(centerTopPanel, BoxLayout.Y_AXIS));
        JPanel centerTopLeftPanel = new JPanel();
        JLabel misCarreras = new JLabel("Mis carreras: ");
        misCarreras.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerTopLeftPanel.setBackground(Color.decode("#116A9A"));
        misCarreras.setForeground(Color.white);
        misCarreras.setFont(new Font("Arial", Font.BOLD, 12));
        centerTopLeftPanel.add(misCarreras);
        centerTopLeftPanel.add(Box.createVerticalStrut(5));
        JPanel centerTopCenterPanel = new JPanel();
        centerTopCenterPanel.setBackground(Color.decode("#292929"));

        centerTopPanel.add(centerTopCenterPanel, BorderLayout.CENTER);
        LinkedList<Career> carreras = alumnoCliente.getCursaCarrera();
        StringBuilder result = new StringBuilder();

        for (Career career : carreras) {
            result.append(career.toString() + " - ");
        }

        JLabel labelCarrerasInscriptas = new JLabel(result.toString());
        labelCarrerasInscriptas.setFont(new Font("Arial", Font.BOLD, 12));
        labelCarrerasInscriptas.setForeground(Color.white);
        labelCarrerasInscriptas.setAlignmentX(Component.LEFT_ALIGNMENT);
        centerTopLeftPanel.add(labelCarrerasInscriptas);
        centerTopPanel.add(centerTopLeftPanel, BorderLayout.EAST);

        return  centerTopPanel;
    }

    public JButton buttonCareerInscription(Career career, JPanel panel) {
        JButton boton = new  CustomButton(career.getName(), "#474747", 220);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (alumnoCliente.getCursaCarrera().contains(career)) {
                    JLabel errorMessage = new JLabel("Ya se encuentra inscripto a esta carrera");
                    errorMessage.setForeground(Color.red);
                    errorMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(errorMessage);

                } else {
                    alumnoCliente.setCursaCarrera(career);
                    JLabel successMessage = new JLabel("Se a inscripto correctamente");
                    successMessage.setForeground(Color.decode("##119A26"));
                    successMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel.add(successMessage);
                }

            }
        });
        return boton;
    }

    public JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.decode("#292929"));

        return centerPanel;
    }

    public JPanel createCenterCenterPanel() {
        JPanel centerCenterPanel = new JPanel();
        centerCenterPanel.setBackground(Color.decode("#292929"));
        centerCenterPanel.setLayout(new BoxLayout(centerCenterPanel, BoxLayout.Y_AXIS));

        centerCenterPanel.add(Box.createVerticalStrut(20));
        JLabel tittle = new JLabel("Carreras disponibles");
        tittle.setForeground(Color.white);
        tittle.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerCenterPanel.add(tittle);
        centerCenterPanel.add(Box.createVerticalStrut(10));

        LinkedList<Career> careers = Career.getCareers();

        for (Career career : careers) {
            JButton boton = buttonCareerInscription(career, centerCenterPanel);
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerCenterPanel.add(boton);
            centerCenterPanel.add(Box.createVerticalStrut(10));
        }

        return centerCenterPanel;
    }

    public JPanel createInscriptionPanel() {
        inscriptionPanel.removeAll();
        inscriptionPanel.setLayout(new BorderLayout());
        inscriptionPanel.setBackground(Color.decode("#292929"));
        JPanel panelTop = customPanelTop("Carreras " + alumnoCliente.getNombre());
        inscriptionPanel.add(panelTop, BorderLayout.NORTH);

        JPanel centerPanel = createCenterPanel();
        JPanel centerTopPanel = createCenterTopPanel();
        centerPanel.add(centerTopPanel, BorderLayout.NORTH);

        JPanel centerCenterPanel = createCenterCenterPanel();

        centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
        centerPanel.setBackground(Color.decode("#474747"));


        inscriptionPanel.add(centerPanel, BorderLayout.CENTER);

        return inscriptionPanel;
    }

    public void setAlumnoCliente(Student alumno) {
        this.alumnoCliente = alumno;
    }
}
