package swing;

import dao.MyTableDAO;
import entity.MyTable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JTableUI extends JFrame {
    private JTable table1;
    private JPanel panel1;
    private MyTableDAO myTableDAO;

    public JTableUI() {
        add(panel1);
        setTitle("DB and JList");

        createTableFromDatabase();

        //Görsel Özellikler
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void createTableFromDatabase() {
        myTableDAO = new MyTableDAO();
        List<MyTable> myTableList = myTableDAO.list();

        String[] columns = new String[]{
                "NameSurname", "Phone", "Age"
        };

        Object[][] data = new Object[myTableList.size()][columns.length];
        for (int i = 0; i < myTableList.size(); i++) {
            data[i][0] = myTableList.get(i).getNameSurname();
            data[i][1] = myTableList.get(i).getPhone();
            data[i][2] = myTableList.get(i).getAge();
        }
        table1 = new JTable(data, columns);

        JScrollPane scrollPane = new JScrollPane(table1);
        panel1.setLayout(new BorderLayout());
        panel1.add(scrollPane, BorderLayout.CENTER);
    }
}