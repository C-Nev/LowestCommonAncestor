package DirectedAcyclicGraph;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DirectedAcyclicGraphTest {

	/*
	 * Constructor
	 * addEdge
	 * removeEdge
	 * getOutEdges
	 * getWeight
	 * getListOfAdjacenylist
	 * getinEdgesCount
	 * printGraph
	 * 
	 */
	@Test
	public void testConstructor() {
		DirectedAcyclicGraph DAG= new DirectedAcyclicGraph(10);
		assertEquals(10, DAG.noOfVertices);
		DirectedAcyclicGraph DAG2= new DirectedAcyclicGraph(-1);
		assertEquals(0, DAG2.noOfVertices);
		//Class does not support max int:
		//DirectedAcyclicGraph DAG3= new DirectedAcyclicGraph(Integer.MAX_VALUE);
		//assertEquals(Integer.MAX_VALUE, DAG2.noOfVertices);
		DirectedAcyclicGraph DAG3= new DirectedAcyclicGraph(1000000);
		assertEquals(1000000, DAG3.noOfVertices);
	}

}
