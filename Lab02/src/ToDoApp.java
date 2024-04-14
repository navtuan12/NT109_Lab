import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
    private ArrayList<String> tasks;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public ToDoApp() {
        setTitle("To-Do App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Task input field and add button
        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        JTextField taskInput = new JTextField();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String newTask = taskInput.getText().trim();
            if (!newTask.isEmpty()) {
                addTask(newTask);
                taskInput.setText("");
            }
        });
        inputPanel.add(taskInput);
        inputPanel.add(addButton);

        // Task list and delete button
        JPanel listPanel = new JPanel(new BorderLayout(10, 10));
        JScrollPane scrollPane = new JScrollPane(taskList);
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                deleteTask(selectedIndex);
            }
        });
        listPanel.add(scrollPane, BorderLayout.CENTER);
        listPanel.add(deleteButton, BorderLayout.SOUTH);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(listPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
    }

    private void addTask(String task) {
        tasks.add(task);
        listModel.addElement(task);
    }

    private void deleteTask(int index) {
        tasks.remove(index);
        listModel.removeElementAt(index);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoApp().setVisible(true);
        });
    }
}