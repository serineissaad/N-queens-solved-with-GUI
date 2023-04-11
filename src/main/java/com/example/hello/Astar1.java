package com.example.hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Astar1 {
    private final int n;
    private static int generatedNodes;
    private static int exploredNodes;
    private static int leaves;

    public Astar1(int n) {
        this.n = n;
        generatedNodes = 0;
        exploredNodes = 0;
        leaves = 0;
    }

    public static int getLeaves() {
        return leaves;
    }

    public static int getGeneratedNodes() {
        return generatedNodes;
    }

    public static int getExploredNodes() {
        return exploredNodes;
    }

    public static void setFeuilles() {
        leaves=0;
    }

    public static void setNoeudsExplores() {
        exploredNodes=0;
    }

    public static void setNoeudsGeneres() {
        generatedNodes=0;
    }

    public int[] solve() {
        PriorityQueue<EtatA> queue = new PriorityQueue<>(Comparator.comparingInt(EtatA::getF));
        queue.add(new EtatA(new int[n], 0));
        while (!queue.isEmpty()) {
            EtatA state = queue.poll();
            exploredNodes++;
            if (state.isGoal()) {
            //    System.out.println("solu : " + Arrays.toString(state.getReines()));
                return state.getReines();
            }
            for (EtatA child : state.getChildren()) {
                generatedNodes++;
                queue.add(child);
            }
            if (queue.size() > leaves) {
                leaves = queue.size();
            }
        }
        return null;
    }

    class EtatA extends Etat{
        private final int h;
        public EtatA(int[] reines, int ligne) {
            super(reines, ligne);
            this.h = calculHeuristique();
        }
        public int getF() {
            return h;
        }
        public ArrayList<Astar1.EtatA> getChildren() {
            ArrayList<Astar1.EtatA> children = new ArrayList<>();
            for (int col = 0; col < n; col++) {
                if (isValidMove(ligne, col)) {
                    int[] nvreines = reines.clone();
                    nvreines[ligne] = col;
                    children.add(new Astar1.EtatA(nvreines, ligne + 1));
                }
            }return children;
        }
        public boolean isGoal() {
            return ligne == n;
        }
        public int[] getReines() {
            return reines;
        }
}}