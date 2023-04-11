package com.example.hello;

import java.util.ArrayList;

public class Etat {
    int[] reines;
    int ligne;
    public Etat(int[] reines, int ligne) {
        this.reines = reines;
        this.ligne = ligne;
    }

    static int evaluerSolution(int[] solution) {
        int n = solution.length;
        int pairesAttaquees = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (solution[i] == solution[j] ||
                        solution[i] - i == solution[j] - j ||
                        solution[i] + i == solution[j] + j) {
                    pairesAttaquees++;
                }
            }
        }
        return pairesAttaquees;
    }


    boolean isValidMove(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (reines[i] == col || Math.abs(reines[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    int calculHeuristique() {
        int h = 0;
        for (int i = 0; i < ligne; i++) {
            for (int j = i + 1; j < ligne; j++) {
                if (reines[i] == reines[j] || Math.abs(reines[i] - reines[j]) == Math.abs(i - j)) {
                    h++;
                }
            }
        }
        return h;
    }

    public int heuristic() {
        int n = reines.length;
        int h = 0;

        // Parcours des colonnes
        for (int i = 0; i < n; i++) {
            int queenRow = reines[i];

            // Calcul de la distance de Manhattan pour chaque reine
            for (int j = i + 1; j < n; j++) {
                int otherQueenRow = reines[j];
                int distance = Math.abs(queenRow - otherQueenRow) + Math.abs(i - j);
                h += distance;
            }
        }

        return h;}




}
