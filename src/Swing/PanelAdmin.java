package Swing;

import AppClasses.Career;
import AppClasses.StudyProgram;
import AppClasses.Subject;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.CertificateEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;

public class PanelAdmin extends VentanaPrincipal{

    private JPanel adminCarreraPanel = new JPanel();
    private JPanel careerCreatorPanel = new JPanel();
    private JPanel studyProgramCreatorPanel = new JPanel();
    private JPanel chooseCareerNamePanel = new JPanel();

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
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.add(Box.createVerticalStrut(150));
        CustomButton createStudyProgramBtn = new CustomButton("Alta de Carrera", "#474747", 220);
        createStudyProgramBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createStudyProgramCreator();
                cardLayout.show(cardPanel, "CREATE STUDY PROGRAM");
            }
        });
        centerPanel.add(createStudyProgramBtn);
        createStudyProgramBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20));

        /*CustomButton createCareerBtn = new CustomButton("Alta de carrera" , "#474747", 220 );
        createCareerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCareerCreator();
                cardLayout.show(cardPanel, "CREATE CAREER");
            }
        });
        centerPanel.add(createCareerBtn);
        createCareerBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        */
        leftPanel.add(salir);
        adminCarreraPanel.add(leftPanel, BorderLayout.WEST);
        adminCarreraPanel.add(topPanel, BorderLayout.NORTH);
        adminCarreraPanel.add(centerPanel, BorderLayout.CENTER);
        return adminCarreraPanel;
    }

    public void createStudyProgramCreator() {
        studyProgramCreatorPanel.setBackground(Color.decode("#292929"));
        studyProgramCreatorPanel.setLayout(new BorderLayout());

        JPanel panelTop = customPanelTop("Paso 1: Crear plan de estudio");
        studyProgramCreatorPanel.add(panelTop, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton atras = new CustomButton("Volver", "#116A9A", 110);
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal.cardLayout.show(VentanaPrincipal.cardPanel, "ADMIN CARRERAS");
            }
        });
        leftPanel.add(atras);
        studyProgramCreatorPanel.add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalStrut(20));


        JLabel tittle = new JLabel("Agregar materias");
        tittle.setForeground(Color.white);
        tittle.setFont(new Font("Arial", Font.BOLD, 12));
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(tittle);
        tittle.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(25));

        HashMap<Integer, LinkedList<Subject>> programa = new HashMap<>();

        final int[] counter  = {0};
        CustomButton agregarCuatrimestreBtn = new CustomButton("+ Cuatrimestre", "#fc2c03", 150);
        agregarCuatrimestreBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.add(Box.createVerticalStrut(10));
                counter[0]++;
                int numero = counter[0];
                JLabel tittleCuatrimestre = new JLabel("Cuatrimestre " + numero);
                tittleCuatrimestre.setForeground(Color.white);
                tittleCuatrimestre.setFont(new Font("Arial", 1, 12));
                centerPanel.add(tittleCuatrimestre);
                tittleCuatrimestre.setAlignmentX(Component.CENTER_ALIGNMENT);

                JTextField escribirMateria = new JTextField();
                escribirMateria.setMaximumSize(new Dimension(200, 40));
                escribirMateria.setBackground(Color.decode("#474747"));
                escribirMateria.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "Materia nombre"));
                escribirMateria.setForeground(Color.white);
                centerPanel.add(Box.createVerticalStrut(5));
                centerPanel.add(escribirMateria);

                JCheckBox checkBox = new JCheckBox("Promocionable");
                checkBox.setBackground(Color.decode("#292929"));
                checkBox.setForeground(Color.white);
                checkBox.setBorderPainted(false);
                centerPanel.add(Box.createVerticalStrut(5));
                centerPanel.add(checkBox);
                checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);

                JLabel elegirPlanText = new JLabel("Elegir tipo de plan");
                elegirPlanText.setForeground(Color.white);
                elegirPlanText.setFont(new Font("Arial", 0 , 12));
                centerPanel.add(elegirPlanText);
                elegirPlanText.setAlignmentX(Component.CENTER_ALIGNMENT);

                char[] tipoPlanMateria = new char[1];
                Character[] opciones = {'A', 'B', 'C', 'D', 'E'};
                JComboBox<Character> tipoPlanOpciones = new JComboBox<>(opciones);
                tipoPlanOpciones.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tipoPlanMateria[0] = (char) tipoPlanOpciones.getSelectedItem();
                    }
                });
                centerPanel.add(Box.createVerticalStrut(10));
                tipoPlanOpciones.setMaximumRowCount(4);
                tipoPlanOpciones.setMaximumSize(new Dimension(80,35));
                centerPanel.add(tipoPlanOpciones);
                tipoPlanOpciones.setAlignmentX(Component.CENTER_ALIGNMENT);

                LinkedList<Subject> cuatrimestre = new LinkedList<>();
                programa.put(numero, cuatrimestre);

                CustomButton agregarMateria = new CustomButton("Agregar", "#474747", 120);
                agregarMateria.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String materiaNombre = escribirMateria.getText();
                        Boolean promocionable = checkBox.isSelected();
                        if (materiaNombre.isBlank()) {
                            JOptionPane.showMessageDialog(null, "Debe especificar un nombre para la materia", "Alerta", JOptionPane.ERROR_MESSAGE);
                        } else {
                            Subject nuevaMateria = new Subject(materiaNombre, promocionable, tipoPlanMateria[0]);
                            programa.get(numero).add(nuevaMateria);

                            JOptionPane.showMessageDialog(null,"Se ha agregado la materia " + materiaNombre +  " al cuatrimestre " + numero, "Exito" , JOptionPane.INFORMATION_MESSAGE);
                            escribirMateria.setText("");
                            checkBox.setSelected(false);
                        }
                    }
                });
                centerPanel.add(Box.createVerticalStrut(10));
                centerPanel.add(agregarMateria);
                centerPanel.add(Box.createVerticalStrut(50));
                agregarMateria.setAlignmentX(Component.CENTER_ALIGNMENT);
                centerPanel.revalidate();
                centerPanel.repaint();
            }
        });
        centerPanel.add(agregarCuatrimestreBtn);
        agregarCuatrimestreBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.decode("#292929"));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        CustomButton empezarDeNuevo = new CustomButton("Cancelar", "#FF0000", 120);
        empezarDeNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de que quieres cancelar la creacion del plan de estudio?", "Si", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    createStudyProgramCreator();
                }
            }
        });
        bottomPanel.add(empezarDeNuevo);
        CustomButton confirmar = new CustomButton("Confirmar", "#119A26",120);
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Confirmar plan de estudio?", "Si", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null,"Se ha creado el nuevo plan de estudio" , "Exito" , JOptionPane.INFORMATION_MESSAGE);
                    StudyProgram program = new StudyProgram(programa);
                    createCareerCreator(program);
                    cardLayout.show(cardPanel, "CREATE CAREER");
                }
            }
        });
        bottomPanel.add(confirmar);

        studyProgramCreatorPanel.add(bottomPanel, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        studyProgramCreatorPanel.add(scrollPane, BorderLayout.CENTER);

    }

    public void createCareerCreator(StudyProgram programa) {
        careerCreatorPanel.setBackground(Color.decode("#292929"));
        careerCreatorPanel.setLayout(new BorderLayout());
        JPanel panelTop = customPanelTop("Paso 2: Asignar correlativas");
        careerCreatorPanel.add(panelTop, BorderLayout.NORTH);
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton atras = new CustomButton("Volver", "#116A9A", 110);
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal.cardLayout.show(VentanaPrincipal.cardPanel, "ADMIN CARRERAS");
            }
        });
        leftPanel.add(atras);
        careerCreatorPanel.add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(Box.createVerticalStrut(20));

        boolean alreadyShown = false;
        for (int i = 1; i <= programa.getPrograma().size(); i++) {
            centerPanel.add(Box.createVerticalStrut(20));
            JLabel tittleCuatrimestre = new JLabel("Cuatrimestre " + i );
            tittleCuatrimestre.setForeground(Color.white);
            tittleCuatrimestre.setBackground(Color.decode("#292929"));
            centerPanel.add(tittleCuatrimestre);
            tittleCuatrimestre.setAlignmentX(Component.CENTER_ALIGNMENT);
            centerPanel.add(Box.createVerticalStrut(20));
            for (Subject subject : programa.getPrograma().get(i)) {
                JPanel subjectRowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                subjectRowPanel.setBackground(Color.decode("#292929"));
                JLabel materiaNombre = new JLabel(subject.getNombre());
                materiaNombre.setForeground(Color.white);
                materiaNombre.setFont(new Font("Arial", 0, 12));
                subjectRowPanel.add(materiaNombre);

                //se tiene en cuenta que las materias del primer cuatrimestre no pueden tener correlativas
                if (i != 1) {
                    LinkedList<Subject> subjectsList = programa.getAllSubjects();
                    String[] subjectNames = new String[subjectsList.size()];
                    for (int j = 0; j < subjectsList.size(); j++) {
                        subjectNames[j] = subjectsList.get(j).toString();
                    }
                    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(subjectNames);
                    JComboBox<String> materiasOpciones = new JComboBox<>(comboBoxModel);
                    materiasOpciones.setMaximumRowCount(6);
                    materiasOpciones.setMaximumSize(new Dimension(200,35));
                    materiasOpciones.setSelectedItem("----");
                    subjectRowPanel.add(materiasOpciones);
                    CustomButton agregarCorrelativa = new CustomButton("agregar", "#116A94", 80);
                    agregarCorrelativa.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Subject materiaElegida = Subject.getSubjectByStringName((String) materiasOpciones.getSelectedItem());
                            if (materiaElegida != null) {
                                subject.setCorrelativas(materiaElegida);
                            } else {
                                System.out.println("Ocurrio un error, la materia es nula");
                            }
                            materiasOpciones.setSelectedItem("----");
                        }
                    });
                    subjectRowPanel.add(agregarCorrelativa);
                    centerPanel.add(subjectRowPanel);
                    subjectRowPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
                } else if (!alreadyShown){
                    alreadyShown = true;
                    JLabel message = new JLabel("No puede asignar correlativas al primer cuatrimestre");
                    message.setForeground(Color.white);
                    message.setFont(new Font("Arial", Font.BOLD, 12));
                    centerPanel.add(message);
                    message.setAlignmentX(Component.CENTER_ALIGNMENT);
                }
            }
        }
        careerCreatorPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.decode("#292929"));
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        CustomButton confirmar = new CustomButton("Confirmar", "#119A26",120);
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(null, "Confirmar correlativas?", "Si", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    createChooseCareerName(programa);
                    cardLayout.show(cardPanel, "CHOOSE CAREER NAME");
                }
            }
        });
        bottomPanel.add(confirmar);
        careerCreatorPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void createChooseCareerName(StudyProgram program) {
        chooseCareerNamePanel.setBackground(Color.decode("#292929"));
        chooseCareerNamePanel.setLayout(new BorderLayout());

        JPanel topPanel = customPanelTop("Paso 3: elegir nombre de la carrera");
        chooseCareerNamePanel.add(topPanel, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton atras = new CustomButton("Volver", "#116A9A", 110);
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal.cardLayout.show(VentanaPrincipal.cardPanel, "ADMIN CARRERAS");
            }
        });
        leftPanel.add(atras);
        chooseCareerNamePanel.add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalStrut(50));

        JTextField elegirNombre = new JTextField();
        elegirNombre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "nombre carrera"));
        elegirNombre.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        elegirNombre.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        elegirNombre.setForeground(Color.WHITE);
        centerPanel.add(elegirNombre);
        elegirNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20));

        CustomButton confirmar = new CustomButton("Confirmar", "#119A26", 120);
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int respuesta = JOptionPane.showConfirmDialog(null, "Estas seguro de el nombre ingresado?", "Si", JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    String nombreCarrera = elegirNombre.getText();
                    Career nuevaCarrera = new Career(nombreCarrera, program);

                    JLabel successMessage = new JLabel("Se ha creado la nueva carrera con exito");
                    successMessage.setForeground(Color.decode("#119A26"));
                    successMessage.setFont(new Font("Arial", 0, 12));
                    centerPanel.add(successMessage);
                    successMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
                }
            }
        });
        centerPanel.add(confirmar);
        confirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
        chooseCareerNamePanel.add(centerPanel, BorderLayout.CENTER);
    }

    public JPanel getAdminCarreraPanel() {
        return adminCarreraPanel;
    }
    public JPanel getCrateCareerPanel() {
        return careerCreatorPanel;
    }
    public JPanel getStudyProgramCreatorPanel() {
        return studyProgramCreatorPanel;
    }
    public JPanel getChooseCareerNamePanel() {
        return chooseCareerNamePanel;
    }
}
