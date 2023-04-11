package com.example.hello;

import java.util.*;

import static com.example.hello.Etat.evaluerSolution;

public class BFS {
    static int feuilles = 0, noeudsGeneres = 0, noeudsExplores = 0;



    static int[] solve(int n) {
        int[] reines = new int[n];
        Arrays.fill(reines, -1);
        Queue < Etat > queue = new LinkedList < > ();
        int[] solution = null;
        queue.offer(new Etat (reines, 0));
        noeudsGeneres++;
        while (!queue.isEmpty() && solution == null) {
            noeudsExplores++;
          //  System.out.println("Nombre de noeuds explorées : " + noeudsExplores);
            Etat etat = queue.poll();
            int[] reinescur = etat.reines;
            int lignecur = etat.ligne;
            if (lignecur == n) {
                int nbPairesAttaquees = evaluerSolution(reinescur);
              //  feuilles++;
                if (nbPairesAttaquees == 0) {
                    solution = reinescur.clone();
                }
            } else {
                for (int i = 0; i < n ; i++) {
                    int[] nvreines = reinescur.clone();
                    nvreines[lignecur] = i;
                    queue.offer(new Etat(nvreines, lignecur + 1));
                    noeudsGeneres++;
                }
            }
        }
        return solution;
    }


    public static void setFeuilles() {
        feuilles=0;
    }

    public static void setNoeudsExplores() {
        noeudsExplores=0;
    }

    public static void setNoeudsGeneres() {
        noeudsGeneres=0;
    }

}
