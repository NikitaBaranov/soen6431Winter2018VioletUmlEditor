package com.horstmann.violet.application.menu;

import com.horstmann.violet.application.gui.MainFrame;
import com.horstmann.violet.application.help.ShortcutDialog;
import com.horstmann.violet.framework.injection.resources.ResourceBundleInjector;
import com.horstmann.violet.framework.injection.resources.annotation.ResourceBundleBean;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@ResourceBundleBean(resourceReference = MenuFactory.class)
public class Soen6431Menu extends JMenu {

    @ResourceBundleBean(key = "Soen6431Menu")
    public Soen6431Menu(MainFrame mainFrame)
    {
        ResourceBundleInjector.getInjector().inject(this);
        this.mainFrame = mainFrame;
        this.createMenu();
    }

    private void createMenu()
    {
        feature1Item.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ShortcutDialog dialog = new ShortcutDialog(mainFrame);
                dialog.setVisible(true);
            }
        });
        this.add(feature1Item);

        feature2Item.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ShortcutDialog dialog = new ShortcutDialog(mainFrame);
                dialog.setVisible(true);
            }
        });
        this.add(feature2Item);

        feature3Item.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ShortcutDialog dialog = new ShortcutDialog(mainFrame);
                dialog.setVisible(true);
            }
        });
        this.add(feature3Item);
    }

    /**
     * Main app frame where this menu is attached to
     */
    private JFrame mainFrame;

    @ResourceBundleBean(key = "Soen6431Menu.feature1")
    private JMenuItem feature1Item;

    @ResourceBundleBean(key = "Soen6431Menu.feature2")
    private JMenuItem feature2Item;

    @ResourceBundleBean(key = "Soen6431Menu.feature3")
    private JMenuItem feature3Item;
}
