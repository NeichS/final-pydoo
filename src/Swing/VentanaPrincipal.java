package Swing;

import AppClasses.Student;
import AppClasses.Subject;
import Swing.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class VentanaPrincipal {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    static JPanel customPanelTop(String tittle) {
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTop.setBackground(Color.decode("#474747"));
        JLabel titulo = new JLabel(tittle);
        titulo.setForeground(Color.white);
        titulo.setOpaque(false);
        titulo.setHorizontalAlignment(SwingConstants.LEFT);
        Font font = new Font("Arial", Font.BOLD, 16);
        titulo.setFont(font);
        panelTop.add(titulo);
        return panelTop;
    }

    static JLabel escalarImagen(ImageIcon originalIcon) {
        int originalWidth = originalIcon.getIconWidth();
        int originalHeight = originalIcon.getIconHeight();

        // Establecer un tamaño máximo permitido (ajústalo según tus necesidades)
        int maxWidth = 300;
        int maxHeight = 250;

        // Calcular nuevas dimensiones manteniendo la proporción original
        int newWidth = originalWidth;
        int newHeight = originalHeight;

        if (originalWidth > maxWidth || originalHeight > maxHeight) {
            double widthRatio = (double) maxWidth / originalWidth;
            double heightRatio = (double) maxHeight / originalHeight;

            double scaleFactor = Math.min(widthRatio, heightRatio);

            newWidth = (int) (originalWidth * scaleFactor);
            newHeight = (int) (originalHeight * scaleFactor);
        }

        Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        return new JLabel(scaledIcon);
    }

    private JPanel createMenuPanel(){
        JPanel menuPanel = new JPanel(new BorderLayout());

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(Color.decode("#292929"));
        JPanel panelCentroBajo = new JPanel();

        CustomButton botonAdmin = new CustomButton("Admin", "#474747");
        botonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //logica de administrador
            }
        });
        CustomButton botonAlumno = new CustomButton("Soy Alumno", "#474747");
        botonAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "REGISTRO");
            }
        });

        panelCentroBajo.add(botonAdmin);
        panelCentroBajo.add(botonAlumno);

        panelCentroBajo.setBackground(Color.decode("#292929"));
        panelCentro.add(panelCentroBajo, BorderLayout.SOUTH);
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            java.net.URL imageURL = classLoader.getResource("Swing/logo.png");

            if (imageURL != null) {
                ImageIcon originalIcon = new ImageIcon(imageURL);
                JLabel imagenLabel = escalarImagen(originalIcon);
                panelCentro.add(imagenLabel, BorderLayout.CENTER);
            } else {
                System.err.println("No se pudo cargar la imagen.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel panelTop = customPanelTop("Home");

        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(Color.decode("#292929"));

        JPanel panelRight = new JPanel();
        panelRight.setBackground(Color.decode("#292929"));

        menuPanel.add(panelRight, BorderLayout.EAST);
        menuPanel.add(panelLeft, BorderLayout.WEST);
        menuPanel.add(panelTop, BorderLayout.NORTH);
        menuPanel.add(panelCentro, BorderLayout.CENTER);

        return menuPanel;
    }

    private JPanel createRegisterPanel(){
        JPanel registroPanel = new JPanel(new BorderLayout());

        JPanel topPanel = customPanelTop("Bienvenido Alumno");
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.decode("#292929"));
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton atras = new CustomButton("Volver", "#116A9A");
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MENU");
            }
        });
        leftPanel.add(atras);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS)); // Utilizando BoxLayout en Y
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 70));

        registroPanel.add(rightPanel, BorderLayout.EAST);
        registroPanel.add(leftPanel, BorderLayout.WEST);
        registroPanel.add(topPanel, BorderLayout.NORTH);

        JLabel iniciarSesion = new JLabel("Iniciar Sesion");
        iniciarSesion.setForeground(Color.white);
        iniciarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(iniciarSesion);
        centerPanel.add(Box.createVerticalStrut(10));

        // Campo de texto para el correo electrónico
        JTextField emailField = new JTextField();
        emailField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "email"));
        emailField.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        emailField.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        emailField.setForeground(Color.WHITE); // Establecer el color del texto
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(emailField);
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);



        JPasswordField passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "password"));
        passwordField.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        passwordField.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        passwordField.setForeground(Color.WHITE); // Establecer el color del texto
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(passwordField);

        CustomButton register = new CustomButton("Registrarse", "#474747");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "NEW USER");
            }
        });
        centerPanel.add(Box.createVerticalStrut(10));
        register.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(register);

        CustomButton confirmButton = new CustomButton("Confirmar", "#119A26");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                char[] password = passwordField.getPassword();

                if (Student.confirmarIngreso(email, password)) {
                    cardLayout.show(cardPanel, "ADMIN ALUMNO");
                } else {
                    JLabel deniedMessage = new JLabel("Mail o contraseña incorrectos");

                    deniedMessage.setForeground(Color.red);
                    centerPanel.add(Box.createVerticalStrut(10));
                    deniedMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
                    centerPanel.add(deniedMessage);
                }
            }
        });

        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(confirmButton);
        registroPanel.add(centerPanel, BorderLayout.CENTER);
        return registroPanel;
    }

    private JPanel createNewUserPanel() {
        JPanel newUserPanel = new JPanel(new BorderLayout());

        JPanel topPanel = customPanelTop("Registro de cuenta");
        newUserPanel.add(topPanel, BorderLayout.NORTH);
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton atras = new CustomButton("Volver","#116A94");
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "REGISTRO");
            }
        });
        leftPanel.add(atras);
        newUserPanel.add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 70));
        JLabel tittle = new JLabel("Ingrese sus datos");
        tittle.setForeground(Color.white);
        tittle.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(tittle);

        //DATOS DE REGISTRO
        //MAIL
        JTextField emailField = new JTextField();
        emailField.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "email"));
        emailField.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        emailField.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        emailField.setForeground(Color.WHITE); // Establecer el color del texto
        centerPanel.add(Box.createVerticalStrut(10));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(emailField);
        newUserPanel.add(centerPanel, BorderLayout.CENTER);

        //CONFIRMAR MAIL
        JTextField emailFieldConfirm = new JTextField();
        emailFieldConfirm.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "confirmar email"));
        emailFieldConfirm.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        emailFieldConfirm.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        emailFieldConfirm.setForeground(Color.WHITE); // Establecer el color del texto
        emailFieldConfirm.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(emailFieldConfirm);
        newUserPanel.add(centerPanel, BorderLayout.CENTER);

        //CONTRASEÑA
        JPasswordField contrasenha = new JPasswordField();
        contrasenha.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "contrasenha"));
        contrasenha.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        contrasenha.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        contrasenha.setForeground(Color.WHITE); // Establecer el color del texto
        contrasenha.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(contrasenha);
        newUserPanel.add(centerPanel, BorderLayout.CENTER);

        //CONTRASEÑA CONFIRMAR
        JPasswordField contrasenhaConfirmar = new JPasswordField();
        contrasenhaConfirmar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "confirmar contrasenha"));
        contrasenhaConfirmar.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        contrasenhaConfirmar.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        contrasenhaConfirmar.setForeground(Color.WHITE); // Establecer el color del texto
        contrasenhaConfirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(contrasenhaConfirmar);
        newUserPanel.add(centerPanel, BorderLayout.CENTER);

        //NOMBRE
        JTextField nombre = new JTextField();
        nombre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "nombre"));
        nombre.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        nombre.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        nombre.setForeground(Color.WHITE); // Establecer el color del texto
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(nombre);
        newUserPanel.add(centerPanel, BorderLayout.CENTER);

        //APELLIDO
        JTextField apellido = new JTextField();
        apellido.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "apellido"));
        apellido.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        apellido.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        apellido.setForeground(Color.WHITE); // Establecer el color del texto
        apellido.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(apellido);
        newUserPanel.add(centerPanel, BorderLayout.CENTER);

        JTextField carrera = new JTextField();
        carrera.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "carrera"));
        carrera.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        carrera.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        carrera.setForeground(Color.WHITE); // Establecer el color del texto
        carrera.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(carrera);
        newUserPanel.add(centerPanel, BorderLayout.CENTER);

        //BOTON CAPTURA TODA LA INFO
        CustomButton confirmButton = new CustomButton("Registrarse", "#119A26");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String emailConfirm = emailFieldConfirm.getText();
                char[] password = contrasenha.getPassword();
                char[] passwordConfirm = contrasenhaConfirmar.getPassword();
                String name = nombre.getText();
                String surname = apellido.getText();
                String career = carrera.getText();

                if (!Student.mailInUse(email) && Arrays.equals(password, passwordConfirm) && Objects.equals(email, emailConfirm)) {
                    Student.agregarEstudiante(new Student(name,surname,email,password,career));
                    cardLayout.show(cardPanel, "REGISTRO CONFIRMADO");

                } else {
                    JLabel errorMessage = new JLabel("Hay datos erroneos");
                    errorMessage.setForeground(Color.red);
                    errorMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
                    centerPanel.add(Box.createVerticalStrut(10));
                    centerPanel.add(errorMessage);
                }
            }
        });
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(confirmButton);
        return newUserPanel;
    }

    private JPanel createConfirmRegisterPanel() {
        JPanel confirmacionRegistro = new JPanel(new BorderLayout());
        confirmacionRegistro.setBackground(Color.decode("#292929"));
        JLabel registerSuccessfull = new JLabel("Se ha registrado correctamente");
        registerSuccessfull.setForeground(Color.white);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.decode("#292929"));
        registerSuccessfull.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(registerSuccessfull);
        confirmacionRegistro.add(centerPanel);
        CustomButton volverMenu = new CustomButton("Menu", "#119A26");
        volverMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "REGISTRO");
            }
        });
        volverMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(volverMenu);
        confirmacionRegistro.add(centerPanel);

        return  confirmacionRegistro;
    }

    private  JPanel createAdminAlumnoPanel() {
        JPanel adminALumnoPanel = new JPanel();
        adminALumnoPanel.setBackground(Color.decode("#292929"));
        return adminALumnoPanel;
    }
    private JPanel createAdminCarreraPanel() {
        JPanel adminCarreraPanel = new JPanel();
        adminCarreraPanel.setLayout(new BorderLayout());


        return adminCarreraPanel;
    }
    VentanaPrincipal() {
        JFrame ventana = new JFrame("Administracion");
        ventana.setSize(700, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar el CardLayout y el panel que lo utiliza
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Agregar las vistas al panel que utiliza el CardLayout
        cardPanel.add("MENU", createMenuPanel());
        cardPanel.add("REGISTRO", createRegisterPanel());
        cardPanel.add("NEW USER", createNewUserPanel());
        cardPanel.add("ADMIN ALUMNO", createAdminAlumnoPanel());
        cardPanel.add("REGISTRO CONFIRMADO", createConfirmRegisterPanel());
        cardPanel.add("ADMIN CARRERAS", createAdminCarreraPanel());

        ventana.setLayout(new BorderLayout());
        ventana.add(cardPanel, BorderLayout.CENTER);

        ventana.setVisible(true);

        //creacion de alumno estatica

        char[] passAlumnoUno = {'a', 'l', 'p', 'e', 'd', 'o', '.', '1', '0'};
        Student alumnoUno = new Student("Ignacio", "Sanchez", "nachoagusss1@gmail.com",passAlumnoUno, "Lic En sistemas");

        //materias de lic en sistemas hasta el 6to cuatrimestre
        Subject algebra = new Subject("Algebra", new LinkedList<>());
        Subject analisisMatematico = new Subject("Análisis Matemático", new LinkedList<>());
        Subject elementosLogicaMatematicaDiscreta = new Subject("Elementos de Lógica y Matemática Discreta", new LinkedList<>());
        Subject algoritmicaProgramacionI = new Subject("Algorítmica y Programación I", new LinkedList<>());

        LinkedList<Integer> correlativasArqui= new LinkedList<>();
        correlativasArqui.add(3);
        correlativasArqui.add(4);
        Subject arquitecturaComputadoras = new Subject("Arquitectura de Computadoras", correlativasArqui);

        LinkedList<Integer> correlativasEstadistica = new LinkedList<>();
        correlativasEstadistica.add(1);
        correlativasEstadistica.add(2);
        Subject estadistica = new Subject("Estadística", correlativasEstadistica);

        Subject sistemasOrganizaciones = new Subject("Sistemas y Organizaciones", new LinkedList<>());

        LinkedList<Integer> correlativasBD = new LinkedList<>();
        correlativasBD.add(1);
        correlativasBD.add(4);
        Subject basesDatosI = new Subject("Bases de Datos I", correlativasBD);

        Subject ingenieriaSoftwareI = new Subject("Ingeniería de Software I", new LinkedList<>());

        LinkedList<Integer> correlativasPydoo = new LinkedList<>();
        correlativasPydoo.add(4);
        Subject programacionDisenoOrientadoObjetos = new Subject("Programación y Diseño Orientado a Objetos", correlativasPydoo);

        LinkedList<Integer> correlativasFTI = new LinkedList<>();
        correlativasFTI.add(9);
        Subject fundamentosTeoricosInformatica = new Subject("Fundamentos Teóricos de Informática", correlativasFTI);

        LinkedList<Integer> correlativasIngII = new LinkedList<>();
        correlativasIngII.add(9);
        Subject ingenieriaSoftwareII = new Subject("Ingeniería de Software II", correlativasIngII);

        LinkedList<Integer> correlativasIntrConc = new LinkedList<>();
        correlativasIntrConc.add(4);
        correlativasIntrConc.add(10);
        Subject introduccionConcurrencia = new Subject("Introducción a la Concurrencia", correlativasIntrConc);

        LinkedList<Integer> correlativasLabProg = new LinkedList<>();
        correlativasLabProg.add(4);
        correlativasLabProg.add(10);
        Subject laboratorioProgramacionLenguajes = new Subject("Laboratorio de Programación y Lenguajes", correlativasLabProg);

        LinkedList<Integer> correlativasDBII = new LinkedList<>();
        correlativasDBII.add(8);
        Subject basesDatosII = new Subject("Bases de Datos II", correlativasDBII);

        Subject laboratorioSoftware = new Subject("Laboratorio de Software", new LinkedList<>());
        Subject seminarioAspectosLegalesProfesionalesI = new Subject("Seminario de Aspectos Legales y Profesionales I", new LinkedList<>());
        Subject sistemasOperativos = new Subject("Sistemas Operativos", new LinkedList<>());

    }
}
