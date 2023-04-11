package com.example.hello;




import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Astar2 {
    private final int n;
    private static int ng;
    private static int ne;
    private static int le;

    public Astar2(int n) {
        this.n = n;
        ng = 0;
        ne = 0;
        le = 0;
    }

    public static int getLeaves() {
        return le;
    }

    public static int getGeneratedNodes() {
        return ng;
    }

    public static int getExploredNodes() {
        return ne;
    }

    public static void setFeuilles() {
        le=0;
    }

    public static void setNoeudsExplores() {
        ne=0;
    }

    public static void setNoeudsGeneres() {
        ng=0;
    }


    public int[] solve() {
        PriorityQueue<EtatAA> queue = new PriorityQueue<>(Comparator.comparingInt(EtatAA::getF));
        queue.add(new EtatAA(new int[n], 0));

        while (!queue.isEmpty()) {
            EtatAA state = queue.poll();
            ne++;

            if (state.isGoal()) {
                //    System.out.println("Generated nodes: " + this.generatedNodes);
                //    System.out.println("Explored nodes: " + this.exploredNodes);
                //    System.out.println("Leaves: " + this.leaves);
                return state.getBoard();
            }

            for (EtatAA child : state.getChildren()) {
                ng++;
                queue.add(child);
            }

            if (queue.size() > le) {
                le = queue.size();
            }
        }
        return null; // Return null if no solution was found
    }

    private class EtatAA extends Etat {

        private final int h;
        public EtatAA(int[] reines, int ligne) {
            super(reines, ligne);
            this.h = heuristic();
        }
        public int getF() {
            return h;
        }

        public ArrayList<EtatAA> getChildren() {
            ArrayList<EtatAA> children = new ArrayList<>();

            for (int col = 0; col < n; col++) {
                if (isValidMove(ligne, col)) {
                    int[] newBoard = reines.clone();
                    newBoard[ligne] = col;
                    children.add(new EtatAA(newBoard, ligne + 1));
                }
            }

            return children;
        }



        public boolean isGoal() {
            return ligne == n;
        }



        public int[] getBoard() {
            return reines;
        }



    }}
