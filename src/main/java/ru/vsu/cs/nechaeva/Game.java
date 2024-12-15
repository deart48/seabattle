package ru.vsu.cs.nechaeva;

//работа с логикой игры


import javax.swing.JOptionPane;

public class Game {

    public int masPlay[][];
    public int masComp[][];


    public static int endGame = 3;
    public int P1, P2, P3, P4, PT, PM;
    public int C1, C2, C3, C4, CT, CM;
    public int kolHodPlay;
    public int kolHodComp;
    public static boolean gamePkVsPk;
    public final int pause = 500;
    public boolean myHod;
    public boolean compHod;
    Thread thread = new Thread();

    Game() {
        masPlay = new int[10][10];
        masComp = new int[10][10];
    }


    public void start() {

    }

    public void attack(int mas[][], int i, int j) {

    }


    public void testEndGame() {

    }

    public void kolUbitPk(int[][] mas) {

    }

    public void kolUbitPlayer(int[][] mas) {

    }

    private void testUbit(int mas[][], int i, int j) {

    }

    private void analizUbit(int[][] mas, int i, int j, int kolPalub) {

    }

    public void setOkrKilled(int mas[][], int i, int j) {

    }

    private void setOkrUbit(int[][] mas, int i, int j) {

    }

    boolean compHodit(int mas[][]) {
        return true;
    }


    private boolean testMasOut(int i, int j) {
        return true;
    }

    private void setOkr(int[][] mas, int i, int j, int val) {

    }


    private void okrBegin(int[][] mas, int i, int j, int val) {

    }


    public boolean setPaluba(int i, int j, int kolPal, boolean napr) {
        return true;
    }

    private boolean testNewPaluba(int[][] mas, int i, int j) {
        return true;
    }

    private void okrEnd(int[][] mas) {

    }


    private void setPalubaAuto(int[][] mas, int kolPal) {

    }

    private void setPalubaPlay() {

    }

    private void setPalubaComp() {

    }
}
