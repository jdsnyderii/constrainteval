package org.jim;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.io.IoCore;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerGraph;
import org.apache.tinkerpop.gremlin.util.iterator.IteratorUtils;
import org.junit.Test;

import java.util.Iterator;
import java.util.Objects;

public class TinkerpopTest {

  @Test
  public void test() throws Exception {
    BaseConfiguration conf = new BaseConfiguration();
    conf.setProperty(TinkerGraph.GREMLIN_TINKERGRAPH_GRAPH_FORMAT, "graphml");
    conf.setProperty(TinkerGraph.GREMLIN_TINKERGRAPH_GRAPH_LOCATION, "test.graphml");
    TinkerGraph graph = TinkerGraph.open(conf);

    String fileName = Objects.requireNonNull(this.getClass().getClassLoader().getResource("test.graphml")).getFile();
    graph.io(IoCore.graphml()).readGraph(fileName);
    System.out.println("Vertices count is " + IteratorUtils.count(graph.vertices()));
    System.out.println("Edge count is " + IteratorUtils.count(graph.edges()));
    printOutput(graph.vertices());

    printOutput(graph.traversal().V("n2").in());
  }

  private void printOutput(Iterator<Vertex> iter) {
    System.out.println("Traversal Output");
    iter.forEachRemaining(v -> System.out.printf("v is %s : { %s } %n", v.id(), IteratorUtils.list(v.properties()).toString()));
  }
}
