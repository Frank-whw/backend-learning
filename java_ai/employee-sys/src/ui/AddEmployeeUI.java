package ui;

import bean.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeUI extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JTextField departmentField;
    private JTextField positionField;
    private JTextField salaryField;
    private JButton confirmButton;
    private JButton cancelButton;
    private EmployeeManagerUI employeeManagerUI;
    public AddEmployeeUI(EmployeeManagerUI employeeManagerUI) {
        initializeComponents();
        this.employeeManagerUI = employeeManagerUI;
        setupLayout();
        setupEventListeners();
        setFrameProperties();
        this.setVisible(true);
    }

    private void initializeComponents() {
        idField = new JTextField(20);
        nameField = new JTextField(20);
        departmentField = new JTextField(20);
        positionField = new JTextField(20);
        salaryField = new JTextField(20);
        confirmButton = new JButton("确认");
        cancelButton = new JButton("取消");
    }

    private void setupLayout() {
        // 创建主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 创建输入表单面板
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // ID 标签和输入框
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(idLabel, gbc);

        idField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        idField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 0;
        formPanel.add(idField, gbc);

        // 姓名 标签和输入框
        JLabel nameLabel = new JLabel("姓名:");
        nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(nameLabel, gbc);

        nameField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        nameField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        formPanel.add(nameField, gbc);

        // 部门 标签和输入框
        JLabel departmentLabel = new JLabel("部门:");
        departmentLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(departmentLabel, gbc);

        departmentField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        departmentField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(departmentField, gbc);

        // 职位 标签和输入框
        JLabel positionLabel = new JLabel("职位:");
        positionLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(positionLabel, gbc);

        positionField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        positionField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(positionField, gbc);

        // 薪资 标签和输入框
        JLabel salaryLabel = new JLabel("薪资:");
        salaryLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(salaryLabel, gbc);

        salaryField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        salaryField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 4;
        formPanel.add(salaryField, gbc);

        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        confirmButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        confirmButton.setPreferredSize(new Dimension(80, 35));
        cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        cancelButton.setPreferredSize(new Dimension(80, 35));
        
        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // 将表单面板和按钮面板添加到主面板
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void setupEventListeners() {
        // 确认按钮事件
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleConfirm();
            }
        });

        // 取消按钮事件
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClose();
            }
        });
    }

    private void handleConfirm() {
        // 获取输入值
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String department = departmentField.getText().trim();
        String position = positionField.getText().trim();
        String salary = salaryField.getText().trim();

        // 验证输入
        if (id.isEmpty() || name.isEmpty() || department.isEmpty() || position.isEmpty() || salary.isEmpty()) {
            JOptionPane.showMessageDialog(this, "请填写所有字段！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 验证薪资是否为数字
        try {
            Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "薪资必须为数字！", "提示", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id_Int = Integer.parseInt(idField.getText().trim());
        double salary_Double = Double.parseDouble(salaryField.getText().trim());
        employeeManagerUI.addEmployee(new Employee(id_Int, name, department, position, salary_Double));
        // 这里可以添加保存员工信息的逻辑
        JOptionPane.showMessageDialog(this, "员工信息已保存！\nID: " + id + "\n姓名: " + name + 
                                      "\n部门: " + department + "\n职位: " + position + 
                                      "\n薪资: " + salary, "成功", JOptionPane.INFORMATION_MESSAGE);
        
        // 关闭窗口
        dispose();
    }

    private void handleClose() {
        dispose();
    }

    private void setFrameProperties() {
        setTitle("添加员工");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    // 获取输入的员工信息
    public String[] getEmployeeInfo() {
        return new String[] {
            idField.getText().trim(),
            nameField.getText().trim(),
            departmentField.getText().trim(),
            positionField.getText().trim(),
            salaryField.getText().trim()
        };
    }
}