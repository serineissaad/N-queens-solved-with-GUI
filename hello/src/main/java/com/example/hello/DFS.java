package com.example.hello;

import static com.example.hello.Etat.evaluerSolution;

public class DFS {


    static Solution solve(int[] board, int col, Solution sol) {
    	int n = board.length;
        	if (evaluerSolution(board) == 0) {
                sol.setT1(board);
                sol.setDone(1);
                return sol;
            }
        for (int row = 0; row < n && col<n; row++) {
                board[col] = row; // place the queen
                sol=solve(board, col + 1,sol);
                if(col!=3 && row!=3 && sol.getDone()!=1) {
                	sol.setDev(sol.getDev()+1);
                }
                if(sol.getDone()==1)
                	return sol;
                else
                	{sol.setNb(sol.getNb()+1);}
        }
        return sol;
    }
    





    
}

