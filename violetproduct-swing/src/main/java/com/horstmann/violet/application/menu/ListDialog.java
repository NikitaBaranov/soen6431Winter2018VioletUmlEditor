package com.horstmann.violet.application.menu;


import javax.swing.*;
import java.awt.*;

public class ListDialog extends JDialog {

    private JPanel listDialog;

    ListDialog(JFrame parent, String dialogTitle, String[][] tableToShow) {
        super(parent);

        this.setTitle(dialogTitle);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buildPanel(tableToShow), BorderLayout.CENTER);
        pack();
        setCenterLocation(parent);

    }

    private JPanel buildPanel(String[][] tableToShow) {
        if (listDialog == null) {
            listDialog = new JPanel(new BorderLayout());

            String[] columnNames = {"Class name", "Metric"};

            JTable table = new JTable(tableToShow, columnNames);
            table.setEnabled(false);
            table.setCellSelectionEnabled(false);
            table.setShowGrid(true);
            table.setGridColor(new Color(220, 220, 220));
            table.setRowHeight(30);
            table.setIntercellSpacing(new Dimension(15, 0));
            table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 14));

            JScrollPane scrollPane = new JScrollPane(table);
            listDialog.add(scrollPane, BorderLayout.CENTER);
        }
        return this.listDialog;
    }

    private void setCenterLocation(JFrame parent) {
        setLocation((parent.getWidth() - getWidth()) / 2, (parent.getHeight() - getHeight()) / 2);
    }
}
