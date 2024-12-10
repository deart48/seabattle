package ru.vsu.cs.nechaeva;


import javax.swing.*;

import java.awt.*;


class Panel extends JPanel {
    private final int DXY = 60;
    private final int H = 23;
    private String number[] = {"А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "К"};
    private int p1, p2, p3, p4;
    public boolean vert = true;
    public static boolean rasstanovka;

    public Panel() {
        setSize(800, 520);
        p1 = 4;
        p2 = 3;
        p3 = 2;
        p4 = 1;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(248, 248, 255));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setFont(new Font("Times New Roman", 0, H - 5));
        g.setColor(new Color(330099));
        drawGameBoard(g);
    }

    private void drawGameBoard(Graphics g) {
        for (int i = 1; i <= 10; i++) {
            g.drawString(String.valueOf(i), DXY - H, DXY + i * H - (H / 4));
            g.drawString(number[i - 1], DXY + (i - 1) * H + (H / 4), DXY - 3);
        }

        for (int i = DXY; i <= DXY + 10 * H; i += H) {
            g.drawLine(DXY, i, DXY + 10 * H, i);
            g.drawLine(i, DXY, i, DXY + 10 * H);
        }

        g.setFont(new Font("Times New Roman", 0, H));
        g.setColor(new Color(330099));
        g.drawString("Расставьте корабли", DXY + 24 * H, DXY - H);

        drawShipCount(g);
    }

    private void drawShipCount(Graphics g) {
        g.drawRect(DXY, DXY + 11 * H, 4 * H, H);
        g.drawString(String.valueOf(1 - p4), DXY + 5 * H, DXY + 12 * H - (H / 4));
        g.drawRect(DXY, DXY + 12 * H + 10, 3 * H, H);
        g.drawString(String.valueOf(2 - p3), DXY + 4 * H, DXY + 13 * H + 10);
        g.drawRect(DXY, DXY + 13 * H + 20, 2 * H, H);
        g.drawString(String.valueOf(3 - p2), DXY + 3 * H, DXY + 14 * H + 20);
        g.drawRect(DXY, DXY + 14 * H + 30, H, H);
        g.drawString(String.valueOf(4 - p1), DXY + 2 * H, DXY + 15 * H + 30);
    }

    public void startRasstanovka() {
        rasstanovka = true;
        // Reset ship counts for placement
        p1 = 4;
        p2 = 3;
        p3 = 2;
        p4 = 1;
        repaint();
    }
}
