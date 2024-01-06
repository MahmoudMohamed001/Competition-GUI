import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class GUI {

    public GUI() {
        JFrame frame1 = new JFrame("Window 1");
        JButton MButton = new JButton("Manager");
        MButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.dispose();
                createAndShowWindow2();
            }

        });

        JButton UButton = new JButton("User");
        JLabel FirstLable = new JLabel("Welcome to the Competition System GUI");
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(FirstLable);
        panel.add(MButton);
        panel.add(UButton);

        frame1.add(panel, BorderLayout.CENTER);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setTitle("Competetion GUI");
        frame1.pack();
        frame1.setVisible(true);
    }

    private static void createAndShowWindow2() {
        JFrame frame2 = new JFrame("Window 2");
        JPanel panel2 = new JPanel();

        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JButton Login = new JButton("Login");
        JTextField EmailField = new JTextField(20);
        EmailField.setToolTipText("Enter Email");

        JPasswordField PasswordField = new JPasswordField(20);
        PasswordField.setToolTipText("Enter Password");

        Login.setPreferredSize(new Dimension(150, 20));
        panel2.setLayout(new GridLayout(3, 2));

        panel2.add(usernameLabel);
        panel2.add(EmailField);
        panel2.add(passwordLabel);
        panel2.add(PasswordField);
        panel2.add(new JLabel()); // Empty label for spacing
        panel2.add(Login);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = EmailField.getText();
                char[] passwordChars = PasswordField.getPassword();
                String password = new String(passwordChars);

                // Perform login validation (you can replace this with your actual validation
                // logic)
                if ("Admin@admin.com".equals(username) && "Admin".equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    frame2.dispose();
                    createAndShowWindow3();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

                // Clear the password field after login attempt
                PasswordField.setText("");
            }
        });

        frame2.add(panel2, BorderLayout.CENTER);
        frame2.setSize(300, 150);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }

    private static void createAndShowWindow3() {

    }

    public static void main(String[] args) {
        new GUI();
    }
}
