package com.horstmann.violet.application.menu;

import com.horstmann.violet.product.diagram.classes.ClassDiagramGraph;
import com.horstmann.violet.product.diagram.classes.edge.DependencyEdge;
import com.horstmann.violet.product.diagram.classes.node.ClassNode;
import com.horstmann.violet.product.diagram.property.text.SingleLineText;
import org.junit.Test;

import java.awt.geom.Point2D;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Soen6431Test {

    @Test
    public void feature1_validNdes_correctmessage() {
        ClassNode node1 = new ClassNode();
        SingleLineText name1 = new SingleLineText();
        name1.setText("Node 1");
        node1.setName(name1);

        ClassNode node2 = new ClassNode();
        SingleLineText name2 = new SingleLineText();
        name2.setText("Node 2");
        node2.setName(name2);

        ClassNode node3 = new ClassNode();
        SingleLineText name3 = new SingleLineText();
        name3.setText("Node 3");
        node3.setName(name3);

        DependencyEdge dependencyEdge1 = new DependencyEdge();
        DependencyEdge dependencyEdge2 = new DependencyEdge();
        DependencyEdge dependencyEdge3 = new DependencyEdge();
        DependencyEdge dependencyEdge4 = new DependencyEdge();
        DependencyEdge dependencyEdge5 = new DependencyEdge();

        ClassDiagramGraph classDiagramGraph1 = new ClassDiagramGraph();
        classDiagramGraph1.addNode(node1, new Point2D.Double(100, 100));
        classDiagramGraph1.addNode(node2, new Point2D.Double(100, 400));
        classDiagramGraph1.addNode(node3, new Point2D.Double(400, 100));

        classDiagramGraph1.connect(dependencyEdge1, node1, new Point2D.Double(100, 100), node1, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph1.connect(dependencyEdge4, node1, new Point2D.Double(100, 100), node1, new Point2D.Double(100, 100), new Point2D[]{});
        classDiagramGraph1.connect(dependencyEdge4, node1, new Point2D.Double(400, 100), node1, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph1.connect(dependencyEdge5, node2, new Point2D.Double(400, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph1.connect(dependencyEdge5, node2, new Point2D.Double(400, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});
        
        assertTrue(Soen6431.feature1(classDiagramGraph1));//test case 1

        ClassDiagramGraph classDiagramGraph2 = new ClassDiagramGraph();
        classDiagramGraph2.addNode(node1, new Point2D.Double(100, 100));
        classDiagramGraph2.addNode(node2, new Point2D.Double(100, 400));
        classDiagramGraph2.addNode(node3, new Point2D.Double(400, 100));

        classDiagramGraph2.connect(dependencyEdge1, node1, new Point2D.Double(100, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph2.connect(dependencyEdge2, node2, new Point2D.Double(100, 400), node3, new Point2D.Double(400, 100), new Point2D[]{});
        classDiagramGraph2.connect(dependencyEdge3, node3, new Point2D.Double(400, 100), node1, new Point2D.Double(100, 400), new Point2D[]{});

        assertFalse(Soen6431.feature1(classDiagramGraph2));//test case 2
    }

    @Test
    public void feature2_validNdes_correctmessage() {
        ClassNode node1 = new ClassNode();
        SingleLineText name1 = new SingleLineText();
        name1.setText("Node 1");
        node1.setName(name1);

        ClassNode node2 = new ClassNode();
        SingleLineText name2 = new SingleLineText();
        name2.setText("Node 2");
        node2.setName(name2);

        ClassNode node3 = new ClassNode();
        SingleLineText name3 = new SingleLineText();
        name3.setText("Node 3");
        node3.setName(name3);

        DependencyEdge dependencyEdge1 = new DependencyEdge();
        DependencyEdge dependencyEdge2 = new DependencyEdge();
        DependencyEdge dependencyEdge3 = new DependencyEdge();
        DependencyEdge dependencyEdge4 = new DependencyEdge();
        DependencyEdge dependencyEdge5 = new DependencyEdge();

        ClassDiagramGraph classDiagramGraph1 = new ClassDiagramGraph();
        classDiagramGraph1.addNode(node1, new Point2D.Double(100, 100));
        classDiagramGraph1.addNode(node2, new Point2D.Double(100, 400));
        classDiagramGraph1.addNode(node3, new Point2D.Double(400, 100));

        classDiagramGraph1.connect(dependencyEdge1, node1, new Point2D.Double(100, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph1.connect(dependencyEdge2, node2, new Point2D.Double(100, 400), node1, new Point2D.Double(400, 100), new Point2D[]{});
        classDiagramGraph1.connect(dependencyEdge3, node2, new Point2D.Double(400, 100), node1, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph1.connect(dependencyEdge4, node1, new Point2D.Double(400, 100), node1, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph1.connect(dependencyEdge5, node2, new Point2D.Double(400, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});

        assertTrue(Soen6431.feature2(classDiagramGraph1));//test case 1

        ClassDiagramGraph classDiagramGraph2 = new ClassDiagramGraph();
        classDiagramGraph2.addNode(node1, new Point2D.Double(100, 100));
        classDiagramGraph2.addNode(node2, new Point2D.Double(100, 400));
        classDiagramGraph2.addNode(node3, new Point2D.Double(400, 100));

        classDiagramGraph2.connect(dependencyEdge1, node1, new Point2D.Double(100, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph2.connect(dependencyEdge2, node2, new Point2D.Double(100, 400), node3, new Point2D.Double(400, 100), new Point2D[]{});
        classDiagramGraph2.connect(dependencyEdge3, node3, new Point2D.Double(400, 100), node1, new Point2D.Double(100, 400), new Point2D[]{});

        assertFalse(Soen6431.feature2(classDiagramGraph2));//test case 2
    }

    @Test
    public void feature3_validNdes_correctList() {
        ClassNode node1 = new ClassNode();
        SingleLineText name1 = new SingleLineText();
        name1.setText("Node 1");
        node1.setName(name1);

        ClassNode node2 = new ClassNode();
        SingleLineText name2 = new SingleLineText();
        name2.setText("Node 2");
        node2.setName(name2);

        ClassNode node3 = new ClassNode();
        SingleLineText name3 = new SingleLineText();
        name3.setText("Node 3");
        node3.setName(name3);

        ClassNode node4 = new ClassNode();

        DependencyEdge dependencyEdge1 = new DependencyEdge();
        DependencyEdge dependencyEdge2 = new DependencyEdge();
        DependencyEdge dependencyEdge3 = new DependencyEdge();

        ClassDiagramGraph classDiagramGraph = new ClassDiagramGraph();
        classDiagramGraph.addNode(node1, new Point2D.Double(100, 100));
        classDiagramGraph.addNode(node2, new Point2D.Double(100, 400));
        classDiagramGraph.addNode(node3, new Point2D.Double(400, 100));
        classDiagramGraph.addNode(node4, new Point2D.Double(400, 400));

        classDiagramGraph.connect(dependencyEdge1, node1, new Point2D.Double(100, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});
        classDiagramGraph.connect(dependencyEdge2, node2, new Point2D.Double(100, 400), node3, new Point2D.Double(400, 100), new Point2D[]{});
        classDiagramGraph.connect(dependencyEdge3, node3, new Point2D.Double(400, 100), node2, new Point2D.Double(100, 400), new Point2D[]{});

        String[][] actual = Soen6431.feature3(classDiagramGraph);

        assertThat(actual, hasItemInArray(new String[]{"Node 1", "1"}));
        assertThat(actual, hasItemInArray(new String[]{"Node 2", "3"}));
        assertThat(actual, hasItemInArray(new String[]{"Node 3", "2"}));
        assertThat(actual, hasItemInArray(new String[]{"NoNameClass 1", "0"}));
    }
}
