package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdmin extends VentanaPrincipal{

    private JPanel adminCarreraPanel = new JPanel();
    private JPanel careerCreatorPanel = new JPanel();
    private JPanel studyProgramCreatorPanel = new JPanel();

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
        CustomButton createStudyProgramBtn = new CustomButton("Alta de plan de estudio", "#474747", 220);
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

        CustomButton createCareerBtn = new CustomButton("Alta de carrera" , "#474747", 220 );
        createCareerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCareerCreator();
                cardLayout.show(cardPanel, "CREATE CAREER");
            }
        });
        centerPanel.add(createCareerBtn);
        createCareerBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        leftPanel.add(salir);
        adminCarreraPanel.add(leftPanel, BorderLayout.WEST);
        adminCarreraPanel.add(topPanel, BorderLayout.NORTH);
        adminCarreraPanel.add(centerPanel, BorderLayout.CENTER);
        return adminCarreraPanel;
    }

    public void createStudyProgramCreator() {
        studyProgramCreatorPanel.setBackground(Color.decode("#292929"));
    }

    public void createCareerCreator() {

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
}
