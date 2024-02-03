package Swing;

import AppClasses.CantidadCuatrimestreException;
import AppClasses.Career;
import AppClasses.Student;
import AppClasses.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectsAvailable extends VentanaPrincipal{

    private JPanel subjectsAvailablePanel = new JPanel();
    private JPanel chooseCareerPanel = new JPanel();
    private Student alumnoCliente;
    private Career selectedCareer;


    public void createChooseCareerPanel(Student alumno) {
        alumnoCliente = alumno;
        chooseCareerPanel.setLayout(new BorderLayout());
        JPanel topPanel = customPanelTop("Elegir carrera");
        chooseCareerPanel.setBackground(Color.decode("#292929"));
        chooseCareerPanel.add(topPanel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton atras = new CustomButton("Volver", "#116A94", 110);
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MENU ALUMNO");
            }
        });
        leftPanel.add(atras);
        chooseCareerPanel.add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.add(Box.createVerticalStrut(10));
        for (Career career : alumnoCliente.getCursaCarrera()) {
            String textBoton = career.getName();
            CustomButton boton = new CustomButton(textBoton, "#474747", 220);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedCareer = career; // Almacena la carrera seleccionada en la variable
                    try {
                        createSubjectsAvailablePanel();
                    } catch (CantidadCuatrimestreException ex) {
                        throw new RuntimeException(ex);
                    }
                    cardLayout.show(cardPanel, "SUBJECTS AVAILABLE");
                }
            });
            centerPanel.add(boton);
            centerPanel.add(Box.createVerticalStrut(10));
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        chooseCareerPanel.add(centerPanel, BorderLayout.CENTER);
    }

    SubjectsAvailable(String var) {
        super(var);
    }

    public void createSubjectsAvailablePanel() throws CantidadCuatrimestreException {
        subjectsAvailablePanel.setBackground(Color.decode("#292929"));
        subjectsAvailablePanel.setLayout(new BorderLayout());
        JPanel topPanel = customPanelTop("Materias a las que se puede inscribir");
        subjectsAvailablePanel.add(topPanel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton atras = new CustomButton("Volver", "#116A94", 110);
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "CHOOSE CAREER 2");
            }
        });
        leftPanel.add(atras);
        subjectsAvailablePanel.add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalStrut(30));

        for (Subject subject : selectedCareer.getPlanDeEstudio().getAllSubjects()) {
            if (selectedCareer.checkCorrelativas(alumnoCliente, subject)) {
                JLabel materiaInscribible = new JLabel(subject.getNombre());
                materiaInscribible.setForeground(Color.white);
                materiaInscribible.setFont(new Font("Arial", 0, 16));
                centerPanel.add(materiaInscribible);
                materiaInscribible.setAlignmentX(Component.CENTER_ALIGNMENT);
                centerPanel.add(Box.createVerticalStrut(20));
            }
        }
        subjectsAvailablePanel.add(centerPanel, BorderLayout.CENTER);
    }

    public JPanel getSubjectsAvailablePanel() {
        return subjectsAvailablePanel;
    }

    public JPanel getChooseCareerPanel() {
        return chooseCareerPanel;
    }

}
