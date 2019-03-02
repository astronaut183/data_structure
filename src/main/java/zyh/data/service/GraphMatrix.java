package zyh.data.service;

public interface GraphMatrix {
    void addBrim(int firstNode, int SecondNode, int value);
    void deleteBrim(int firstNode, int secondNode, int value);
    void display();
    void dfsGraph();
    void bfsGraph();
    void TopologicalGraph();
}
