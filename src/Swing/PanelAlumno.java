package Swing;

import AppClasses.Career;
import AppClasses.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.CertificateEncodingException;
import java.util.LinkedList;

import static Swing.VentanaPrincipal.customPanelTop;

public class PanelAlumno extends VentanaPrincipal {
    private Student alumnoCliente;
    public JPanel adminAlumnoPanel;

    PanelAlumno(String variable) {
        super(variable);
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
        JPanel panelTop = customPanelTop("Bienvenido " + alumnoCliente.getNombre());
        adminAlumnoPanel.add(panelTop, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.add(Box.createVerticalStrut(100));

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton atras = new CustomButton("Volver", "#116A9A", 110);
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal.cardLayout.show(VentanaPrincipal.cardPanel, "MENU");
            }
        });
        leftPanel.add(atras);

        // Center panel buttons
        CustomButton signCareer = new CustomButton("Inscripcion carrera", "#494949", 180);

        signCareer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal.getInscriptionPanel().createInscriptionCareerPanel();
                VentanaPrincipal.cardLayout.show(VentanaPrincipal.cardPanel, "INSCRIPCION CARRERA");
            }
        });

        centerPanel.add(signCareer);
        centerPanel.add(Box.createVerticalStrut(10));
        signCareer.setAlignmentX(Component.CENTER_ALIGNMENT);

        CustomButton signSubject = new CustomButton("Inscripcion materia", "#494949", 180);
        signSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (alumnoCliente.getCursaCarrera().isEmpty()) {
                    // Menú para elegir la carrera en caso de estar anotado a más de una carrera
                    JLabel errorMessage = new JLabel("No estás inscripto a ninguna carrera");
                    errorMessage.setForeground(Color.red);
                    centerPanel.add(errorMessage);
                    errorMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
                } else {
                    VentanaPrincipal.getInscriptionPanel().createChooseCareerPanel();
                    cardLayout.show(cardPanel, "CHOOSE CAREER");
                }
            }
        });
        centerPanel.add(signSubject);
        centerPanel.add(Box.createVerticalStrut(10));
        signSubject.setAlignmentX(Component.CENTER_ALIGNMENT);

        CustomButton viewCareerProgress = new CustomButton("Progreso carrera", "#494949", 180);
        viewCareerProgress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal.getInscriptionPanel().createProgressCareerPanel();
                cardLayout.show(cardPanel, "CAREER PROGRESS");
            }
        });
        centerPanel.add(viewCareerProgress);
        centerPanel.add(Box.createVerticalStrut(10));
        viewCareerProgress.setAlignmentX(Component.CENTER_ALIGNMENT);

        adminAlumnoPanel.add(leftPanel, BorderLayout.WEST);
        adminAlumnoPanel.add(centerPanel, BorderLayout.CENTER);

        return adminAlumnoPanel;
    }

    public void setAlumnoCliente(Student alumno) {
        this.alumnoCliente = alumno;
    }
}

