package Swing;
import AppClasses.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class VentanaPrincipal {
    protected static CardLayout cardLayout;
    protected static JPanel cardPanel;
    protected static String variable;
    private Student alumnoCliente;

    VentanaPrincipal(String caca) {
        this.variable = caca;
    }
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

    private JPanel createMenuPanel() {
        JPanel menuPanel = new JPanel(new BorderLayout());

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(Color.decode("#292929"));
        JPanel panelCentroBajo = new JPanel();

        CustomButton botonAdmin = new CustomButton("Admin", "#474747", 110);
        botonAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "ADMIN SECURITY VERIFICATION");
            }
        });
        CustomButton botonAlumno = new CustomButton("Soy Alumno", "#474747", 110);
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

    private JPanel createRegisterPanel(PanelAlumno panelAlumno, InscriptionPanel inscriptionPanel) {
        JPanel registroPanel = new JPanel(new BorderLayout());

        JPanel topPanel = customPanelTop("Bienvenido Alumno");
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.decode("#292929"));
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton atras = new CustomButton("Volver", "#116A9A", 110);
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

        CustomButton register = new CustomButton("Registrarse", "#474747", 110);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "NEW USER");
            }
        });
        centerPanel.add(Box.createVerticalStrut(10));
        register.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(register);

        CustomButton confirmButton = new CustomButton("Confirmar", "#119A26", 110);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                char[] password = passwordField.getPassword();

                if (Student.confirmarIngreso(email, password)) {
                    alumnoCliente = Student.getAlumnoByMail(email);
                    panelAlumno.setAlumnoCliente(alumnoCliente);
                    inscriptionPanel.setAlumnoCliente(alumnoCliente);
                    registroPanel.setVisible(false);
                    panelAlumno.createMenuAlumnoPanel();
                    inscriptionPanel.createInscriptionPanel();
                    emailField.setText("");
                    passwordField.setText("");
                    cardLayout.show(cardPanel, "MENU ALUMNO");
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
        CustomButton atras = new CustomButton("Volver", "#116A94", 110);
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

        /*JTextField carrera = new JTextField();
        carrera.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "carrera"));
        carrera.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        carrera.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        carrera.setForeground(Color.WHITE); // Establecer el color del texto
        carrera.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(carrera);
        newUserPanel.add(centerPanel, BorderLayout.CENTER);*/

        //BOTON CAPTURA TODA LA INFO
        CustomButton confirmButton = new CustomButton("Registrarse", "#119A26", 110);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String emailConfirm = emailFieldConfirm.getText();
                char[] password = contrasenha.getPassword();
                char[] passwordConfirm = contrasenhaConfirmar.getPassword();
                String name = nombre.getText();
                String surname = apellido.getText();

                if (!Student.mailInUse(email) && Arrays.equals(password, passwordConfirm) && Objects.equals(email, emailConfirm)) {
                    Student.agregarEstudiante(new Student(name, surname, email, password));
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
        CustomButton volverMenu = new CustomButton("Menu", "#119A26", 110);
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

        return confirmacionRegistro;
    }


    private JPanel createAdminSecurityVerif() {
        JPanel adminSecurity = new JPanel(new BorderLayout());
        JPanel centerPanel = new JPanel();
        JPanel topPanel = customPanelTop("Ingresar Admin");
        adminSecurity.add(topPanel, BorderLayout.NORTH);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.decode("#292929"));
        centerPanel.add(Box.createVerticalStrut(150));
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.decode("#292929"));
        CustomButton volver = new CustomButton("Volver", "#116A9A", 110);
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "MENU");
            }
        });
        leftPanel.add(volver);
        JPasswordField securityPin = new JPasswordField();
        securityPin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#474747")), "Security pin"));
        securityPin.setMaximumSize(new Dimension(200, 40)); // Limitar la altura del campo
        securityPin.setBackground(Color.decode("#474747")); // Establecer el color de fondo
        securityPin.setForeground(Color.WHITE); // Establecer el color del texto
        securityPin.setAlignmentX(Component.CENTER_ALIGNMENT);
        securityPin.setAlignmentY(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(securityPin);

        CustomButton confirmButton = new CustomButton("Ingresar", "#119A26", 110);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pin = securityPin.getPassword();
                char[] key = {'1', '2', '3', '4'};

                if (Arrays.equals(pin, key)) {
                    cardLayout.show(cardPanel, "ADMIN CARRERAS");
                } else {
                    JLabel errorMessage = new JLabel("Contraseña incorrecta");
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
        adminSecurity.add(leftPanel, BorderLayout.WEST);
        adminSecurity.add(centerPanel, BorderLayout.CENTER);
        return adminSecurity;
    }

    private JPanel createAdminCarreraPanel() {
        JPanel adminCarreraPanel = new JPanel(new BorderLayout());
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


    public VentanaPrincipal() {
        JFrame ventana = new JFrame("Administracion");
        ventana.setSize(700, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar el CardLayout y el panel que lo utiliza
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        PanelAlumno alumnoPanel = new PanelAlumno(variable);
        InscriptionPanel inscriptionPanel = new InscriptionPanel(variable);
        // Agregar las vistas al panel que utiliza el CardLayout
        cardPanel.add("MENU", createMenuPanel());
        cardPanel.add("REGISTRO", createRegisterPanel(alumnoPanel, inscriptionPanel));
        cardPanel.add("NEW USER", createNewUserPanel());
        cardPanel.add("MENU ALUMNO", alumnoPanel.adminAlumnoPanel);
        cardPanel.add("REGISTRO CONFIRMADO", createConfirmRegisterPanel());
        cardPanel.add("ADMIN CARRERAS", createAdminCarreraPanel());
        cardPanel.add("ADMIN SECURITY VERIFICATION", createAdminSecurityVerif());
        cardPanel.add("INSCRIPCION CARRERA", inscriptionPanel.inscriptionPanel);
        cardPanel.add("INSCRIPCION MATERIA", inscriptionPanel.createInscriptionMateriaPanel());

        ventana.setLayout(new BorderLayout());
        ventana.add(cardPanel, BorderLayout.CENTER);

        ventana.setVisible(true);
    }
}

