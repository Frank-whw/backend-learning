package ui;

import bean.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class EmployeeManagerUI extends JFrame{
    private JTextField searchField; // 搜索框
    private JButton searchButton;
    private JButton addButton;
    private JTable employeeTable; // 表格
    private DefaultTableModel tableModel;

    // use a static set to store all employees
    private static ArrayList<Employee> allEmployees = new ArrayList<>();

    // 定义列名
    private String[] columnNames = {"ID", "姓名", "部门", "职位", "薪资"};

    public EmployeeManagerUI(String UserName) {
        initializeComponents(); // 初始化组件
        setupLayout(); // 设置布局
        setupEventListeners(); // 设置事件监听器
        populateSampleData(); // 填充示例数据
        setFrameProperties(); // 设置窗体属性
        super.setTitle("Welcome," + UserName);
        this.setVisible( true);

    }

    private void initializeComponents() {
        searchField = new JTextField(20);
        searchButton = new JButton("搜索");
        addButton = new JButton("添加");

        // 初始化表格模型
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 表格不可直接编辑
            }
        };

        employeeTable = new JTable(tableModel);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeTable.setRowHeight(25);
        employeeTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        
        // 设置表头样式
        employeeTable.getTableHeader().setFont(new Font("微软雅黑", Font.BOLD, 14));
        employeeTable.getTableHeader().setReorderingAllowed(false);
    }

    private void setupLayout() {
        // 顶部面板 - 搜索和添加按钮
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel searchLabel = new JLabel("搜索:");
        searchLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        searchField.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        searchField.setPreferredSize(new Dimension(150, 30));
        searchButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        searchButton.setPreferredSize(new Dimension(80, 30));
        addButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        addButton.setPreferredSize(new Dimension(80, 30));
        
        topPanel.add(searchLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(addButton);

        // 中间面板 - 表格
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // 主面板
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(mainPanel);
    }

    private void setupEventListeners() {
        // 添加按钮事件
        addButton.addActionListener(e -> {
            // add employee
            new AddEmployeeUI(this);
            // pop up add employee dialog
            JOptionPane.showMessageDialog(this, "添加成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        });


        // 右键菜单
        employeeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                handleTableMouseEvent(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                handleTableMouseEvent(e);
            }
        });


    }

    private void handleTableMouseEvent(MouseEvent e) {
        int row = employeeTable.rowAtPoint(e.getPoint());
        if (row >= 0 && row < employeeTable.getRowCount()) {
            employeeTable.setRowSelectionInterval(row, row);
            
            // 显示右键菜单
            if (SwingUtilities.isRightMouseButton(e)) {
                showPopupMenu(e.getComponent(), e.getX(), e.getY(), row);
            }
        }
    }

    private void showPopupMenu(Component component, int x, int y, int row) {
        JPopupMenu popupMenu = new JPopupMenu();
        
        JMenuItem editItem = new JMenuItem("修改");
        JMenuItem deleteItem = new JMenuItem("删除");
        
        editItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEditEmployeeDialog(row);
            }
        });
        
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee(row);
            }
        });
        
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);
        
        popupMenu.show(component, x, y);
    }

    private void populateSampleData() {
        // 清空现有数据
        tableModel.setRowCount(0);
        
        // 添加20个示例员工
        for (int i = 1; i <= 2; i++) {
            Vector<String> rowData = new Vector<>();
            rowData.add(String.valueOf(i));
            rowData.add("员工" + i);
            rowData.add(i % 3 == 0 ? "技术部" : i % 3 == 1 ? "销售部" : "人事部");
            rowData.add(i % 4 == 0 ? "经理" : i % 4 == 1 ? "主管" : i % 4 == 2 ? "专员" : "助理");
            rowData.add(String.valueOf(5000 + (i * 500)));
            
            tableModel.addRow(rowData);
        }
    }

    private void performSearch() {
        String keyword = searchField.getText().trim();
        if (keyword.isEmpty()) {
            // 如果搜索关键字为空，则显示所有数据
            populateSampleData();
            return;
        }
        
        // 在实际应用中，这里应该查询数据库或过滤现有数据
        // 目前我们只是简单地演示过滤功能
        tableModel.setRowCount(0);
        for (int i = 1; i <= 20; i++) {
            String employeeName = "员工" + i;
            if (employeeName.contains(keyword)) {
                Vector<String> rowData = new Vector<>();
                rowData.add(String.valueOf(i));
                rowData.add(employeeName);
                rowData.add(i % 3 == 0 ? "技术部" : i % 3 == 1 ? "销售部" : "人事部");
                rowData.add(i % 4 == 0 ? "经理" : i % 4 == 1 ? "主管" : i % 4 == 2 ? "专员" : "助理");
                rowData.add(String.valueOf(5000 + (i * 500)));
                
                tableModel.addRow(rowData);
            }
        }
    }

    private void showAddEmployeeDialog() {
        JDialog dialog = new JDialog(this, "添加员工", true);
        dialog.setLayout(new GridLayout(5, 2, 10, 10));
        dialog.setSize(300, 250);
        dialog.setLocationRelativeTo(this);

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField departmentField = new JTextField();
        JTextField positionField = new JTextField();
        JTextField salaryField = new JTextField();

        dialog.add(new JLabel("ID:"));
        dialog.add(idField);
        dialog.add(new JLabel("姓名:"));
        dialog.add(nameField);
        dialog.add(new JLabel("部门:"));
        dialog.add(departmentField);
        dialog.add(new JLabel("职位:"));
        dialog.add(positionField);
        dialog.add(new JLabel("薪资:"));
        dialog.add(salaryField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton confirmButton = new JButton("确定");
        JButton cancelButton = new JButton("取消");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取输入值
                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                String department = departmentField.getText().trim();
                String position = positionField.getText().trim();
                String salary = salaryField.getText().trim();

                // 简单验证
                if (id.isEmpty() || name.isEmpty() || department.isEmpty() || position.isEmpty() || salary.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "请填写所有字段", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // 添加到表格
                Vector<String> rowData = new Vector<>();
                rowData.add(id);
                rowData.add(name);
                rowData.add(department);
                rowData.add(position);
                rowData.add(salary);
                tableModel.addRow(rowData);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        dialog.add(buttonPanel);

        dialog.setVisible(true);
    }

    private void showEditEmployeeDialog(int row) {
        JDialog dialog = new JDialog(this, "修改员工信息", true);
        dialog.setLayout(new GridLayout(5, 2, 10, 10));
        dialog.setSize(300, 250);
        dialog.setLocationRelativeTo(this);

        // 获取当前行的数据
        String id = (String) tableModel.getValueAt(row, 0);
        String name = (String) tableModel.getValueAt(row, 1);
        String department = (String) tableModel.getValueAt(row, 2);
        String position = (String) tableModel.getValueAt(row, 3);
        String salary = (String) tableModel.getValueAt(row, 4);

        JTextField idField = new JTextField(id);
        JTextField nameField = new JTextField(name);
        JTextField departmentField = new JTextField(department);
        JTextField positionField = new JTextField(position);
        JTextField salaryField = new JTextField(salary);

        dialog.add(new JLabel("ID:"));
        dialog.add(idField);
        dialog.add(new JLabel("姓名:"));
        dialog.add(nameField);
        dialog.add(new JLabel("部门:"));
        dialog.add(departmentField);
        dialog.add(new JLabel("职位:"));
        dialog.add(positionField);
        dialog.add(new JLabel("薪资:"));
        dialog.add(salaryField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton confirmButton = new JButton("确定");
        JButton cancelButton = new JButton("取消");


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);
        dialog.add(buttonPanel);

        dialog.setVisible(true);
    }

    private void deleteEmployee(int row) {
        int option = JOptionPane.showConfirmDialog(this, "确定要删除该员工吗？", "确认删除", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            tableModel.removeRow(row);
        }
    }

    private void setFrameProperties() {
        setTitle("员工信息管理系统");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // 居中显示
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                new EmployeeManagerUI().setVisible(true);
            }
        });
    }

    public void addEmployee(Employee  employee) {
        // add employee to set
        allEmployees.add(employee);
        // add one row to table
        tableModel.addRow(new Object[]{employee.getId(), employee.getName(), employee.getDepartment(), employee.getPosition(), employee.getSalary()});
    }
}