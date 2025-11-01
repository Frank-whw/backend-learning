package ui;

import javax.swing.*;
import java.awt.*;


public class LoginUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    public LoginUI() {
        super("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭方式
        this.setSize(300, 300);
        this.setLocationRelativeTo(null); // 设置窗体居中显示
        this.createAndShowGUI();
    }
    private  void createAndShowGUI(){
        JPanel panel = new JPanel(); // 创建面板
        panel.setLayout(null); // 设置布局为null
        panel.setBackground(new Color(240, 240, 240));
        // 设置字体和颜色
        Font font = new Font("Arial", Font.PLAIN, 16);
        Color primaryColor = new Color(51, 51, 51);
        Color secondaryColor = new Color(204, 204, 204);
        // 标题
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setBounds(50, 30, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titleLabel);

        // 用户名标签
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 70, 100, 30);
        usernameLabel.setFont(font);
        panel.add(usernameLabel);

        // the input field for username
        usernameField = new JTextField();
        usernameField.setBounds(120, 70, 150, 30);
        usernameField.setFont(font);
        panel.add(usernameField);

        // 密码标签
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 110, 100, 30);
        passwordLabel.setFont(font);
        panel.add(passwordLabel);

        // the input field for password
        passwordField = new JPasswordField();
        passwordField.setBounds(120, 110, 150, 30);
        passwordField.setFont(font);
        panel.add(passwordField);

        // the login button
        loginButton = new JButton("Login");
        loginButton.setBounds(50, 150, 100, 30);
        loginButton.setFont(font);
        loginButton.setBackground(primaryColor);
        loginButton.setForeground(Color.WHITE);
        panel.add(loginButton);

        // the register button
        registerButton = new JButton("Register");
        registerButton.setBounds(150, 150, 100, 30);
        registerButton.setFont(font);
        registerButton.setBackground(secondaryColor);
        registerButton.setForeground(Color.BLACK);
        panel.add(registerButton);

        // add the panel to the frame
        this.add(panel);
        this.setVisible(true);
    }
}