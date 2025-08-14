import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TaskManagerApp {
    public static void main(String[] args) {
        new TaskFrame();
    }
}

class TaskFrame extends JFrame {
    private JTextField entry;
    private DefaultListModel<String> dataList;
    private JList<String> display;
    private JButton addBtn, delBtn;

    public TaskFrame() {
        setTitle("Task Panel");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        entry = new JTextField();
        dataList = new DefaultListModel<>();
        display = new JList<>(dataList);
        addBtn = new JButton("Add");
        delBtn = new JButton("Delete");

        JPanel top = new JPanel(new BorderLayout());
        top.add(entry, BorderLayout.CENTER);
        top.add(addBtn, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(display), BorderLayout.CENTER);
        add(delBtn, BorderLayout.SOUTH);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String txt = entry.getText().trim();
                if (!txt.isEmpty()) {
                    dataList.addElement(txt);
                    entry.setText("");
                }
            }
        });

        delBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selected = display.getSelectedIndex();
                if (selected != -1) {
                    dataList.remove(selected);
                }
            }
        });

        setVisible(true);
    }
}
