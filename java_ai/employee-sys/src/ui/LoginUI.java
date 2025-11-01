package ui;

import bean.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



// ActionListener是一个接口，用于处理事件
public class LoginUI extends JFrame implements ActionListener {
    private JTextField loginNameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    // define a static set to store the login user
    private static ArrayList<User> allUsers = new ArrayList<>() ;

    // initialize several users
    static {
        allUsers.add(new User("admin", "123456", "admin"));
        allUsers.add(new User("user", "123456", "user"));
    }

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
        loginNameField = new JTextField();
        loginNameField.setBounds(120, 70, 150, 30);
        loginNameField.setFont(font);
        panel.add(loginNameField);

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
        loginButton.addActionListener(this);

        // the register button
        registerButton = new JButton("Register");
        registerButton.setBounds(150, 150, 100, 30);
        registerButton.setFont(font);
        registerButton.setBackground(secondaryColor);
        registerButton.setForeground(Color.BLACK);
        panel.add(registerButton);
        registerButton.addActionListener(this);

        // add the panel to the frame
        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // judge which button is clicked, login or register
        JButton btn = (JButton) e.getSource(); // change the source to JButton forcely
        if (btn == loginButton) {
            System.out.println("Login button clicked");
            // independent method should be called
            login();
        }else{
            System.out.println("Register button clicked");
            register();
        }
    }
    private void login(){
        String loginName = loginNameField.getText();
        String password = new String(passwordField.getPassword());
        // find the user by loginName
        User user = getUserByLoginName(loginName);
        if (user != null){
            if (user.getPassword().equals(password)){
                System.out.println("Login successful");
                // open the employee manager ui
                new EmployeeManagerUI(user.getLoginName());
                this.dispose();
            }else{
                System.out.println("Login failed");
                JOptionPane.showMessageDialog(this, "Login failed");
            }
        }else{
            System.out.println("User not found");
        }
    }
    private User getUserByLoginName(String loginName){
        for (User user : allUsers) {
            if (user.getLoginName().equals(loginName)) {
                return user;
            }
        }
        return null;
    }
    private void register(){

    }

}