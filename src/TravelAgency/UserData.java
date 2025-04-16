package TravelAgency;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.nio.file.*;

public class UserData extends JFrame {
    
    private ImageIcon icon;
    private JLabel label1;
    private Font f1, f2, f3;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JButton btn1, btn2, btn3, btn4, btn5;
    private String file = "user_data.txt"; 
    private String temp = "temp_user_data.txt"; 

    private String[] column = { "User Name", "Password", "Email", "Security Question", "Answer", "Date and Time" };

    UserData() {
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Travel Agency");
        this.setSize(1536, 864);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null); 
        
        f1 = new Font("Segoe UI Black", Font.BOLD, 60);
        f2 = new Font("Segoe UI Black", Font.PLAIN, 25);
        f3 = new Font("Segoe UI", Font.PLAIN, 20);

        label1 = new JLabel("User Data");
        label1.setBounds(600, 10, 400, 80);
        label1.setFont(f1);
        add(label1); 
        
        btn1 = createButton("Refresh", 400, 600);
        btn2 = createButton("Delete", 700, 600);
        btn3 = createButton("Add", 1300, 600);
        btn4 = createButton("Exit", 100, 600, Color.decode("#C00000"));
        btn5 = createButton("Back", 1000, 600);

        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(f3);
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        setTableColumnWidths();

        scroll = new JScrollPane(table);
        scroll.setBounds(159, 96, 1121, 442);
        add(scroll); 
        loadData();
        setupButtonActions();
    }

    private JButton createButton(String text, int x, int y) {
        return createButton(text, x, y, Color.decode("#2E75B6"));
    }

    private JButton createButton(String text, int x, int y, Color background) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 184, 50);
        button.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
        button.setForeground(Color.WHITE);
        button.setBackground(background);
        add(button); 
        return button;
    }

    private void setTableColumnWidths() {
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(220);
    }

    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User Name")) {
                    String[] userData = new String[6];
                    userData[0] = line.split(":")[1].trim(); // User Name
                    userData[1] = reader.readLine().split(":")[1].trim(); // Password
                    userData[2] = reader.readLine().split(":")[1].trim(); // Email
                    userData[3] = reader.readLine().split(":")[1].trim(); // Security Question
                    userData[4] = reader.readLine().split(":")[1].trim(); // Answer
                    userData[5] = reader.readLine().split(":")[1].trim(); // Date and Time
                    model.addRow(userData);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error reading user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setupButtonActions() {
        btn1.addActionListener(e -> refreshData());
        btn2.addActionListener(e -> deleteUser());
        btn3.addActionListener(e -> addUser());
        btn4.addActionListener(e -> System.exit(0));
        btn5.addActionListener(e -> goBack());
    }

    private void refreshData() {
        model.setRowCount(0); 
        loadData();
    }

    private void deleteUser() {
        if (table.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
            deleteUserData(removeUser);
        }
    }

    private void deleteUserData(String removeUser) {
        File oldFile = new File(file);
        File newFile = new File(temp);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(newFile)))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("User Name")) {
                    String userName = line.split(":")[1].trim();
                    if (userName.equals(removeUser)) {
                        reader.readLine(); 
                        reader.readLine(); 
                        reader.readLine();
                        reader.readLine();
                        reader.readLine(); 
                        writer.println("#Removed! " + userName); 
                    } else {
                        writer.println(line);
                        for (int i = 0; i < 5; i++) {
                            writer.println(reader.readLine()); 
                        }
                    }
                } else {
                    writer.println(line);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error deleting user data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        oldFile.delete();
        new File(temp).renameTo(oldFile); 
        refreshData(); 
    }

    private void addUser() {
        setVisible(false);
        new AdminAdd().setVisible(true);
    }

    private void goBack() {
        setVisible(false);
        new Admin().setVisible(true);
    }

    public static void main(String[] args) {
        UserData frame = new UserData();
        frame.setVisible(true);
    }
}
