package com.horstmann.violet.application.menu;

import com.horstmann.violet.product.diagram.abstracts.IGraph;
import com.horstmann.violet.product.diagram.abstracts.node.INode;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;

public class Soen6431 {

    public static String[][] feature3 (IGraph iGraph){
        String[][] tableToShow = new String[iGraph.getAllNodes().size()][2];
        int line = 0;
        int noNameIndex = 1;
        for (INode node : iGraph.getAllNodes()) {
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
        return tableToShow;
    }
}
