package zyh.data.main;

import zyh.data.service.GraphMatrix;

import java.util.ArrayDeque;

public class GraphMatrixImpl implements GraphMatrix {
    private int nodeNumbers;
    private int[][] graphMatrix;
    private int[] visit;

    public GraphMatrixImpl(int nodeNumbers) {
        graphMatrix = new int[nodeNumbers][nodeNumbers];
        this.nodeNumbers = nodeNumbers;
    }

    @Override
    public void addBrim(int firstNode, int secondNode, int value) {
        if (firstNode >= nodeNumbers && secondNode >= nodeNumbers) return;
        graphMatrix[firstNode][secondNode] = value;
        //graphMatrix[secondNode][firstNode] = value;
    }

    @Override
    public void deleteBrim(int firstNode, int secondNode, int value) {
        if (firstNode >= nodeNumbers && secondNode >= nodeNumbers) return;
        graphMatrix[firstNode][secondNode] = 0;
        graphMatrix[secondNode][firstNode] = 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < nodeNumbers; i++) {
            for (int j = 0; j < nodeNumbers; j++) {
                System.out.print(graphMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * 深度遍历
     */
    @Override
    public void dfsGraph() {
        visit = new int[nodeNumbers];
        for (int i = 0; i < nodeNumbers; i++) {
            visit[i] = 0;
        }
        for (int i = 0; i < nodeNumbers; i++) {
            if (visit[i] != 1)
                dfs(i);
        }
    }

    public void dfs(int i) {
        visit[i] = 1;
        System.out.println(i);
        for (int j = 0; j < nodeNumbers; j++) {
            if (graphMatrix[i][j] != 0 && visit[j] != 1) {
                dfs(j);
            }
        }
    }

    /**
     * 广度优先遍历
     */
    @Override
    public void bfsGraph() {
        ArrayDeque<Integer> bfs = new ArrayDeque<>();
        visit = new int[nodeNumbers];
        for (int i = 0; i < nodeNumbers; i++) {
            visit[i] = 0;
        }
        for (int i = 0; i < nodeNumbers; i++) {
            if (visit[i] == 0) {
                bfs.addFirst(i);
                visit[i] = 1;
                while (!bfs.isEmpty()) {
                    int j = bfs.removeLast();

                    System.out.println(j);
                    for (int m = 0; m < nodeNumbers; m++) {
                        if (visit[m] != 1 && graphMatrix[j][m] != 0) {
                            bfs.addFirst(m);
                            visit[m] = 1;
                        }
                    }
                }
            }
        }


    }


    /**
     * 拓扑排序
     */
    @Override
    public void TopologicalGraph() {
        visit = new int[nodeNumbers];

        for (int i = 0; i < nodeNumbers; i++) {
            visit[i] = 0;
        }
        for (int n = 0; n < nodeNumbers; n++) {

            for (int i = 0; i < nodeNumbers; i++) {
                boolean haveOut = true;
                for (int j = 0; j < nodeNumbers; j++) {
                    if (graphMatrix[j][i] != 0) {
                        haveOut = false;
                        break;
                    }
                }
                if (visit[i] == 0 && haveOut) {
                    visit[i] = 1;
                    System.out.println(i);
                    for (int m = 0; m < nodeNumbers; m++) {
                        graphMatrix[i][m] = 0;
                        graphMatrix[m][i] = 0;
                    }
                    break;
                }
            }
        }

    }
}
