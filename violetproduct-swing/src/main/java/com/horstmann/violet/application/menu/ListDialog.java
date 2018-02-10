package com.horstmann.violet.application.menu;

import com.horstmann.violet.framework.injection.resources.ResourceBundleInjector;
import com.horstmann.violet.framework.injection.resources.ResourceShortcutProvider;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ListDialog extends JDialog {

    private JPanel listDialog;

    ListDialog(JFrame parent, String dialogTitle, Map<String, String> mapToShow ){
        super(parent);

        this.setTitle(dialogTitle);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buildPanel(mapToShow), BorderLayout.CENTER);
        pack();
        setCenterLocation(parent);

    }

    private JPanel buildPanel(Map<String, String> mapToShow)
    {
        if(listDialog == null)
        {
            listDialog = new JPanel(new BorderLayout());

            String[] columnNames = {"Class name", "Metric"};

            JTable table = new JTable(prepareDataForTable(mapToShow), columnNames);
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

    private String[][] prepareDataForTable(Map<String, String> mapToShow)
    {
        String[][] tableToShow = new String[mapToShow.size()][2];

        int i = 0;
        for(Map.Entry<String, String> el : mapToShow.entrySet()){
            tableToShow[i][0] = el.getKey();
            tableToShow[i][1] = el.getValue();
            i++;
        }
        return tableToShow;
    }

    private void setCenterLocation(JFrame parent)
    {
        setLocation((parent.getWidth() - getWidth()) / 2, (parent.getHeight() - getHeight()) / 2);
    }
}
