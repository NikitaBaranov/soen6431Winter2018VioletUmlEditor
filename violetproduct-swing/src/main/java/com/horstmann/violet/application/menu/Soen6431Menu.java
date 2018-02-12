package com.horstmann.violet.application.menu;

import com.horstmann.violet.application.gui.MainFrame;
import com.horstmann.violet.framework.injection.resources.ResourceBundleInjector;
import com.horstmann.violet.framework.injection.resources.annotation.ResourceBundleBean;
import com.horstmann.violet.product.diagram.abstracts.edge.IEdge;
import com.horstmann.violet.product.diagram.abstracts.node.INode;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

@ResourceBundleBean(resourceReference = MenuFactory.class)
public class Soen6431Menu extends JMenu {

    /**
     * Main app frame where this menu is attached to
     */
    private MainFrame mainFrame;
    @ResourceBundleBean(key = "Soen6431Menu.feature1")
    private JMenuItem feature1Item;
    @ResourceBundleBean(key = "Soen6431Menu.feature2")
    private JMenuItem feature2Item;
    @ResourceBundleBean(key = "Soen6431Menu.feature3")
    private JMenuItem feature3Item;

    @ResourceBundleBean(key = "Soen6431Menu")
    public Soen6431Menu(MainFrame mainFrame) {
        ResourceBundleInjector.getInjector().inject(this);
        this.mainFrame = mainFrame;
        this.createMenu();
    }

    private void createMenu() {
        //  feature1Item.addActionListener(new ActionListener()
        //  {
        //  	 @Override
        //     public void actionPerformed(ActionEvent e)
        //     {
        //         Collection<IEdge> temp2 = mainFrame.getActiveWorkspace().getGraphFile().getGraph().getAllEdges();
        //          ArrayList<IEdge> temp_arraylist2 = new ArrayList<IEdge>(temp2);
        //          for(int i=0;i<temp_arraylist2.size();i++) {
        //               IEdge itemp2 = temp_arraylist2.get(i);


        //             if (itemp2.getStartNode().equals(itemp2.getEndNode())) {
        //                  System.out.println("Class showes relation to itself");
        //                  mainFrame.getDialogFactory().showErrorDialog("Class showes relation to itself");
        //                  return;
        //                }
        //          }
        //      }
        //  });
        feature1Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collection<INode> allActiveNodes = mainFrame.getActiveWorkspace().getGraphFile().getGraph().getAllNodes();
                for (INode currNode : allActiveNodes) {
                    Collection<IEdge> allActiveEdgeForSpecificNode = currNode.getGraph().getAllEdges();
                    int count = 0;
                    for (IEdge currEdge : allActiveEdgeForSpecificNode) {
                        if (currEdge.getStartNode().equals(currNode) && currEdge.getEndNode().equals(currNode)) {
                            {
                                count++;
                                if (count > 1) {
                                    mainFrame.getDialogFactory().showErrorDialog("Multi realation to itself Occured");
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        });
        this.add(feature1Item);

        feature2Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collection<IEdge> temp = mainFrame.getActiveWorkspace().getGraphFile().getGraph().getAllEdges();
                ArrayList<IEdge> temp_arraylist = new ArrayList(temp);
                for (int i = 0; i < temp_arraylist.size(); i++) {
                    for (int j = 0; j < temp_arraylist.size(); j++) {
                        IEdge itemp = temp_arraylist.get(i);
                        IEdge jtemp = temp_arraylist.get(j);

                        if (itemp.getStartNode().equals(jtemp.getEndNode()) &&
                                itemp.getEndNode().equals(jtemp.getStartNode())) {
                            // System.out.println("Bidirection occuring");
                            mainFrame.getDialogFactory().showErrorDialog("BidirectionalOccuring");
                            return;
                        }
                    }
                }
            }

        });

        this.add(feature2Item);

        feature3Item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collection<INode> iNodes = mainFrame.getActiveWorkspace().getGraphFile().getGraph().getAllNodes();
                String[][] tableToShow = new String[iNodes.size()][2];
                int line = 0;
                int noNameIndex = 1;
                for (INode node : iNodes) {
                    ClassNode classNode = (ClassNode) node;
                    String NodeName = classNode.getName().toEdit();
                    if (NodeName.length() == 0) {
                        NodeName = "NoNameClass " + noNameIndex;
                        noNameIndex++;
                    }
                    String EdgesNum = String.valueOf(classNode.getConnectedEdges().size());
                    tableToShow[line][0] = NodeName;
                    tableToShow[line][1] = EdgesNum;
                    line++;

                }
                ListDialog dialog = new ListDialog(mainFrame, "CBO measures", tableToShow);
                dialog.setVisible(true);
            }
        });
        this.add(feature3Item);
    }
}
