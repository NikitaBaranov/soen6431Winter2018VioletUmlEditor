package com.horstmann.violet.application.menu;


import com.horstmann.violet.product.diagram.abstracts.IGraph;
import com.horstmann.violet.product.diagram.abstracts.edge.IEdge;
import com.horstmann.violet.product.diagram.abstracts.node.INode;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;

import java.util.ArrayList;
import java.util.Collection;

public class Soen6431 {
	public static boolean feature1 (IGraph iGraph){
		boolean fea1 = false;
		Collection<INode> allActiveNodes =(iGraph.getAllNodes()); ;
		for (INode currNode : allActiveNodes) {
            Collection<IEdge> allActiveEdgeForSpecificNode = currNode.getGraph().getAllEdges();
            int count = 0;
            for (IEdge currEdge : allActiveEdgeForSpecificNode) {
                if (currEdge.getStartNode().equals(currNode) && currEdge.getEndNode().equals(currNode)) {
                    {
                        count++;
                        if (count > 1) {
                         fea1 = true;
                          
                        }
                    }
                }
            }
        }
		  return fea1;
	}
    
	
	public static boolean feature2 (IGraph iGraph){
		boolean testexpectedvalue = false;
		 ArrayList<IEdge> temp_arraylist = new ArrayList(iGraph.getAllEdges());
         for (int i = 0; i < temp_arraylist.size(); i++) {
             for (int j = 0; j < temp_arraylist.size(); j++) {
                 IEdge itemp = temp_arraylist.get(i);
                 IEdge jtemp = temp_arraylist.get(j);
                 if (itemp.getStartNode().equals(itemp.getEndNode())) continue;
                 if (jtemp.getStartNode().equals(jtemp.getEndNode())) continue;
                 if (itemp.getStartNode().equals(jtemp.getEndNode()) &&
                         itemp.getEndNode().equals(jtemp.getStartNode())) {
                      testexpectedvalue=true;
                 }
             }
         }
         return testexpectedvalue;

	}

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
