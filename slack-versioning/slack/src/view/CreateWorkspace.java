package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import database.SQLWorkspaceDAO;
import model.SlackSystem;
import model.communication.Workspace;


public class CreateWorkspace extends JFrame{
    private JTextField wkName;
    private JPanel createWSPage;
    private JButton CREATEButton;
    private SQLWorkspaceDAO ws= new SQLWorkspaceDAO();
    private Workspace wp = null;
    private SlackSystem system = new SlackSystem();

    public CreateWorkspace() throws SQLException {
        add(createWSPage);
        setSize(300,400);
        setTitle("Create your Workspace");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        //creation du workspace TODO
        CREATEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameOfWorkspace=wkName.getText();
                wp = new Workspace(nameOfWorkspace, system.getCurrentConnectedProfile());
                ws.insert(wp);
                JOptionPane.showMessageDialog(createWSPage,"Your workspace was successfully created");
                dispose();
                new WelcomePage();
            }
        });
        setVisible(true);
    }

    //TODO: VERIFIER L'ENSEMBLE SI TOUT EST CORDA
    //TODO: FAIRE UNE GROSSE VERIFICATION
}
