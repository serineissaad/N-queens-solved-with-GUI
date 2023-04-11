package com.example.hello;

public class Solution{
    private int nb;
    int[] sol;
    private int done;
    private int dev;

    public Solution(int[] t1) {
        this.nb = 0;
        this.sol = t1;
        this.done=0;
        this.dev=0;
    }
    public int getNb() {
        return nb;
    }
    public void setNb(int nb) {
        this.nb = nb;
    }
    public int getDev() {
        return dev;
    }
    public void setDev(int nb) {
        this.dev = nb;
    }
    public void setT1(int[] t1) {
        this.sol = t1;
    }
    public int getDone() {
        return done;
    }
    public void setDone(int nb) {
        this.done = nb;
    }
}
