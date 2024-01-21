package Swing;

import AppClasses.Career;
import AppClasses.Student;
import AppClasses.StudyProgram;
import AppClasses.Subject;

import javax.imageio.plugins.tiff.TIFFDirectory;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

public class InscriptionPanel extends VentanaPrincipal {
    private Student alumnoCliente;
    private JPanel inscriptionCareerPanel;
    private JPanel inscriptionSubjectPanel = new JPanel();

    InscriptionPanel(String variable) {
        super(variable);
        inscriptionCareerPanel = new JPanel();
        inscriptionCareerPanel.setLayout(new BorderLayout());
        inscriptionCareerPanel.setBackground(Color.decode("#292929"));

        JLabel message = new JLabel("Welcome!");
        inscriptionCareerPanel.add(message, BorderLayout.CENTER);
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
                    JLabel successMessage = new JLabel("Se ha inscripto correctamente");
                    VentanaPrincipal.getInscriptionPanel().createChooseCareerPanel();
                    successMessage.setForeground(Color.decode("#119A26"));
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

    public JPanel createInscriptionCareerPanel() {
        inscriptionCareerPanel.removeAll();
        inscriptionCareerPanel.setLayout(new BorderLayout());
        inscriptionCareerPanel.setBackground(Color.decode("#292929"));
        JPanel panelTop = customPanelTop("Carreras " + alumnoCliente.getNombre());
        inscriptionCareerPanel.add(panelTop, BorderLayout.NORTH);

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
        JPanel centerPanel = createCenterPanel();
        JPanel centerTopPanel = createCenterTopPanel();
        centerPanel.add(centerTopPanel, BorderLayout.NORTH);


        JPanel centerCenterPanel = createCenterCenterPanel();

        centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
        centerPanel.add(leftPanel, BorderLayout.WEST);
        centerPanel.setBackground(Color.decode("#474747"));


        inscriptionCareerPanel.add(centerPanel, BorderLayout.CENTER);

        return inscriptionCareerPanel;
    }

    public void setAlumnoCliente(Student alumno) {
        this.alumnoCliente = alumno;
    }

    private JPanel chooseCareerPanel = new JPanel();
    private Career selectedCareer;
    //Se devuelve la carrera de la cual se quiere anotar las materias
    public void createChooseCareerPanel() {
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
                    createInscriptionSubjectPanel();
                    cardLayout.show(cardPanel, "INSCRIPCION MATERIA");
                }
            });
            centerPanel.add(boton);
            centerPanel.add(Box.createVerticalStrut(10));
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        chooseCareerPanel.add(centerPanel, BorderLayout.CENTER);
    }

    public void createInscriptionSubjectPanel() {
        inscriptionSubjectPanel.setLayout(new BorderLayout());
        inscriptionSubjectPanel.setBackground(Color.decode("#292929"));

        JPanel topPanel = customPanelTop("Inscripcion materias " + selectedCareer.getName());
        inscriptionSubjectPanel.add(topPanel, BorderLayout.NORTH);

        // Crear un JScrollPane y agregar el centerPanel a él
        JScrollPane scrollPane = new JScrollPane();
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#292929"));
        scrollPane.setViewportView(centerPanel);

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

        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        StudyProgram plan = selectedCareer.getPlanDeEstudio();
        JLabel label = new JLabel();

        for (int i = 1; i <= plan.getPrograma().size(); i++) {
            JLabel titulo = new JLabel("Cuatrimestre " + i);
            titulo.setForeground(Color.white);
            titulo.setFont(new Font("Arial", 0, 12));
            centerPanel.add(Box.createVerticalStrut(20));
            centerPanel.add(titulo);
            centerPanel.add(Box.createVerticalStrut(3));
            titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
            for (Subject subject : plan.getCuatrimestreList(i)) {
                JButton botonMateria = new CustomButton(subject + "", "#474747", 340);
                if (alumnoCliente.getCursadasAprobadas().contains(subject)) {
                    botonMateria.setEnabled(false);
                }
                botonMateria.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!alumnoCliente.correlativasCheck(subject)) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "No comple con las correlativas correspondientes para la materia " + subject,
                                    "Alerta",
                                    JOptionPane.WARNING_MESSAGE);
                        } else if (alumnoCliente.getMateriasInscripto().contains(subject)) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Ya se encuentra inscripto a la materia " + subject,
                                    "Alerta",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                        else {
                            // Mostrar un cuadro de confirmación
                            int respuesta = JOptionPane.showConfirmDialog(
                                    null,
                                    "¿Desea inscribirse a la materia " + subject + "?",
                                    "Confirmación",
                                    JOptionPane.YES_NO_OPTION);

                            if (respuesta == JOptionPane.YES_OPTION) {
                                alumnoCliente.addMateriasInscripto(subject);
                            }
                        }
                    }
                });
                centerPanel.add(botonMateria);
                botonMateria.setAlignmentX(Component.CENTER_ALIGNMENT);
                centerPanel.add(Box.createVerticalStrut(5));
            }
        }

        // Agregar el JScrollPane al inscriptionSubjectPanel en lugar del centerPanel directamente
        inscriptionSubjectPanel.add(scrollPane, BorderLayout.CENTER);
        inscriptionSubjectPanel.add(leftPanel, BorderLayout.WEST);
    }

    public JPanel getInscriptionCareerPanel() {

        return  inscriptionCareerPanel;
    }

    public JPanel getInscriptionSubjectPanel() {
        return inscriptionSubjectPanel;
    }

    public JPanel getChooseCareerPanel() {
        return chooseCareerPanel;
    }
}