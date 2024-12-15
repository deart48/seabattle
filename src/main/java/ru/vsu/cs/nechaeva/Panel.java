package ru.vsu.cs.nechaeva;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Panel extends JPanel {
    private final int DXY = 60;
    private final int H = 23;
    private String number[] = {"А", "Б", "В", "Г", "В", "Е", "Ж", "З", "И", "К"};
    private Game game;
    private int mX, mY;
    private Timer timer;
    private BufferedImage ranen, boom, killed, paluba, mine, tralP;
    private BufferedImage ship4, ship3, ship2, ship1, tral, mina;
    private BufferedImage shipV4, shipV3, shipV1, shipV2, tralV;
    private int[] line5, line4, line3, line2, line1, line0;
    private Rectangle selectionArea0, selectionArea, selectionArea2, selectionArea3, selectionArea4, selectionArea5;
    private boolean isSelectP4 = false;
    private boolean isSelectP3 = false;
    private boolean isSelectP2 = false;
    private boolean isSelectP1 = false;
    private boolean isSelectT = false;
    private boolean isSelectM = false;
    private int p5, p4, p3, p2, p1, p0;
    public boolean vert = true;
    private JButton checkNapr;
    public static boolean rasstanovka;

    private JButton placeMineButton;
    private int minesPlaced = 0;


    public Panel() {
        addMouseListener(new Mouse());
        addMouseMotionListener(new Mouse());
        setFocusable(true);
        game = new Game();
        setSize(900, 600);
        try {
            ranen = ImageIO.read(getClass().getResource("/image/ranen.png"));
            boom = ImageIO.read(getClass().getResource("/image/boom.png"));
            killed = ImageIO.read(getClass().getResource("/image/killed.png"));
            paluba = ImageIO.read(getClass().getResource("/image/paluba.png"));
            mina = ImageIO.read(getClass().getResource("/image/ship/mine.png"));
            mine = ImageIO.read(getClass().getResource("/image/mina.png"));
            tralP = ImageIO.read(getClass().getResource("/image/tralP.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        setLayout(null);
        checkNapr = new JButton("Повернуть");
        checkNapr.setBackground(new Color(248, 248, 255));
        checkNapr.setBounds(DXY + 24 * H, DXY + 12 * H, 7 * H, H);
        checkNapr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vert) vert = false;
                else vert = true;
            }
        });
        add(checkNapr);
        checkNapr.setVisible(false);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        g.setColor(new Color(248, 248, 255));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setFont(new Font("Times New Roman", 0, H - 5));
        g.setColor(new Color(330099));
        try {
            ship4 = ImageIO.read(getClass().getResource("/image/ship/4.png"));
            shipV4 = ImageIO.read(getClass().getResource("/image/ship/4.png"));
            ship3 = ImageIO.read(getClass().getResource("/image/ship/3.png"));
            shipV3 = ImageIO.read(getClass().getResource("/image/ship/3.png"));
            ship2 = ImageIO.read(getClass().getResource("/image/ship/2.png"));
            shipV2 = ImageIO.read(getClass().getResource("/image/ship/2.png"));
            ship1 = ImageIO.read(getClass().getResource("/image/ship/1.png"));
            shipV1 = ImageIO.read(getClass().getResource("/image/ship/1.png"));
            tral = ImageIO.read(getClass().getResource("/image/ship/tral.png"));
            tralV = ImageIO.read(getClass().getResource("/image/ship/tral.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (rasstanovka) {
            g2.setStroke(new BasicStroke(2));

            if (vert) {
                line5 = new int[]{DXY + 24 * H, DXY + 10 * H, 1 * H, H};
                line4 = new int[]{DXY + 24 * H, DXY, 4 * H, H};
                line3 = new int[]{DXY + 24 * H, DXY + 2 * H, 3 * H, H};
                line2 = new int[]{DXY + 24 * H, DXY + 4 * H, 2 * H, H};
                line1 = new int[]{DXY + 24 * H, DXY + 6 * H, 1 * H, H};
                line0 = new int[]{DXY + 24 * H, DXY + 8 * H, 1 * H, H};
            } else {
                try {
                    ship4 = ImageIO.read(getClass().getResource("/image/ship/4v.png"));
                    ship3 = ImageIO.read(getClass().getResource("/image/ship/3v.png"));
                    ship2 = ImageIO.read(getClass().getResource("/image/ship/2v.png"));
                    ship1 = ImageIO.read(getClass().getResource("/image/ship/1v.png"));
                    tral = ImageIO.read(getClass().getResource("/image/ship/tralv.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line5 = new int[]{DXY + 34 * H, DXY, H, 1 * H};
                line4 = new int[]{DXY + 24 * H, DXY, H, 4 * H};
                line3 = new int[]{DXY + 26 * H, DXY, H, 3 * H};
                line2 = new int[]{DXY + 28 * H, DXY, H, 2 * H};
                line1 = new int[]{DXY + 30 * H, DXY, H, 1 * H};
                line0 = new int[]{DXY + 32 * H, DXY, H, 1 * H};
            }

            if (p5 != 0) g.drawImage(mina, line5[0], line5[1], line5[2], line5[3], null);
            selectionArea5 = new Rectangle(line5[0], line5[1], line5[2], line5[3]);
            if (p4 != 0) g.drawImage(ship4, line4[0], line4[1], line4[2], line4[3], null);
            selectionArea4 = new Rectangle(line4[0], line4[1], line4[2], line4[3]);
            if (p3 != 0) g.drawImage(ship3, line3[0], line3[1], line3[2], line3[3], null);
            selectionArea3 = new Rectangle(line3[0], line3[1], line3[2], line3[3]);
            if (p2 != 0) g.drawImage(ship2, line2[0], line2[1], line2[2], line2[3], null);
            selectionArea2 = new Rectangle(line2[0], line2[1], line2[2], line2[3]);
            if (p1 != 0) g.drawImage(ship1, line1[0], line1[1], line1[2], line1[3], null);
            selectionArea = new Rectangle(line1[0], line1[1], line1[2], line1[3]);
            if (p0 != 0) g.drawImage(tral, line0[0], line0[1], line0[2], line0[3], null);
            selectionArea0 = new Rectangle(line0[0], line0[1], line0[2], line0[3]);
            if ((p0 + p1 + p2 + p3 + p4) != 0) {
                g.drawString("Расставьте корабли", DXY + 24 * H, DXY - H);
                checkNapr.setVisible(true);
            } else {
                checkNapr.setVisible(false);
            }
        }
        g.drawString("Игрок", DXY + 4 * H, DXY - H);
        g.drawString("Компьютер", DXY + 16 * H, DXY - H);
        g.drawString("Ходов игрока: ", DXY + 23 * H, 30 + DXY + 13 * H - (H / 4));
        g.drawString(String.valueOf(game.kolHodPlay), DXY + 29 * H, 30 + DXY + 13 * H - (H / 4));
        g.drawString("Ходов комьютера: ", DXY + 23 * H, 30 + DXY + 14 * H - (H / 4));
        g.drawString(String.valueOf(game.kolHodComp), DXY + 30 * H + (H / 2), 30 + DXY + 14 * H - (H / 4));

        for (int i = 1; i <= 10; i++) {
            g.drawString(String.valueOf(i), DXY - H, DXY + i * H - (H / 4));
            g.drawString(String.valueOf(i), DXY + 12 * H, DXY + i * H - (H / 4));
            g.drawString(number[i - 1], DXY + (i - 1) * H + (H / 4), DXY - 3);
            g.drawString(number[i - 1], 13 * H + DXY + (i - 1) * H + (H / 4), DXY - 3);
        }

        for (int i = DXY; i <= DXY + 10 * H; i += H) {
            g2.setStroke(new BasicStroke(1));
            g.setColor(new Color(202, 202, 255));
            g.drawLine(DXY, i, DXY + 10 * H, i); // ----
            g.drawLine(i, DXY, i, DXY + 10 * H);
            g.drawLine(DXY + 13 * H, i, DXY + 23 * H, i); //бот ---
            g.drawLine(i + 13 * H, DXY, i + 13 * H, DXY + 10 * H);

            g2.setStroke(new BasicStroke(2));
            g.setColor(new Color(330099));
            g.drawRect(DXY, DXY, 10 * H, 10 * H);
            g.drawRect(DXY + 13 * H, DXY, 10 * H, 10 * H);
        }

        g.setFont(new Font("Times New Roman", 0, H));
        g.setColor(new Color(330099));

        g.drawImage(shipV4, DXY, DXY + 11 * H, 4 * H, H, null);
        g.drawString(String.valueOf(1 - game.C4), DXY + 5 * H, DXY + 12 * H - (H / 4));

        g.drawImage(shipV3, DXY, DXY + 12 * H + 10, 3 * H, H, null);
        g.drawString(String.valueOf(2 - game.C3), DXY + 4 * H, DXY + 13 * H + 10);

        g.drawImage(shipV2, DXY, DXY + 13 * H + 20, 2 * H, H, null);
        g.drawString(String.valueOf(3 - game.C2), DXY + 3 * H, DXY + 14 * H + 20);

        g.drawImage(shipV1, DXY, DXY + 14 * H + 30, H, H, null);
        g.drawString(String.valueOf(4 - game.C1), DXY + 2 * H, DXY + 15 * H + 30);

        g.drawImage(tralV, DXY, DXY + 15 * H + 40, H, H, null);
        g.drawString(String.valueOf(1 - game.CT), DXY + 2 * H, DXY + 16 * H + 40);

        g.drawImage(mina, DXY, DXY + 16 * H + 50, H, H, null);
        g.drawString(String.valueOf(3 - game.CM), DXY + 2 * H, DXY + 17 * H + 40);


        g.drawImage(shipV4, DXY + 13 * H, DXY + 11 * H, 4 * H, H, null);//4 палуб
        g.drawString(String.valueOf(1 - game.P4), DXY + 18 * H, DXY + 12 * H - (H / 4));

        g.drawImage(shipV3, DXY + 13 * H, DXY + 12 * H + 10, 3 * H, H, null);  //3
        g.drawString(String.valueOf(2 - game.P3), DXY + 17 * H, DXY + 13 * H + 10);

        g.drawImage(shipV2, DXY + 13 * H, DXY + 13 * H + 20, 2 * H, H, null);
        g.drawString(String.valueOf(3 - game.P2), DXY + 16 * H, DXY + 14 * H + 20);

        g.drawImage(shipV1, DXY + 13 * H, DXY + 14 * H + 30, 1 * H, H, null);
        g.drawString(String.valueOf(4 - game.P1), DXY + 15 * H, DXY + 15 * H + 30);

        g.drawImage(tralV, DXY + 13 * H, DXY + 15 * H + 40, H, H, null);
        g.drawString(String.valueOf(1 - game.PT), DXY + 15 * H, DXY + 16 * H + 40);

        g.drawImage(mina, DXY + 13 * H, DXY + 16 * H + 50, H, H, null);
        g.drawString(String.valueOf(3 - game.PM), DXY + 15 * H, DXY + 17 * H + 50);

        if (Game.endGame == 0 && (p1 + p2 + p3 + p4) == 0 && rasstanovka || Game.endGame == 0 && !rasstanovka) {
            g.setFont(new Font("Times New Roman", 0, H - 5));
            if (game.myHod) {
                g.setColor(Color.green);
                g.drawString("Ход игрока", DXY + 24 * H, DXY + 12 * H - (H / 4));
            } else {
                g.setColor(Color.red);
                g.drawString("Ходит компьютер", DXY + 24 * H, DXY + 12 * H - (H / 4));
            }
        }
        if (Game.endGame == 1) {
            timer.stop();

        }
        if (Game.endGame == 2) {
            timer.stop();
        }

    }

    public void start() {
        rasstanovka = false;
        Game.gamePkVsPk = false;
        checkNapr.setVisible(false);
        timer.start();
        game.start();
    }

    public void startRasstanovka() {
        rasstanovka = true;
        timer.start();
        game.start();
        p0 = 1;
        p1 = 4;
        p2 = 3;
        p3 = 2;
        p4 = 1;
        p5 = 3;
    }

    public void exit() {
        System.exit(0);
    }


    class Mouse implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if ((e.getButton() == 1) && (e.getClickCount() == 1)) {
                if (rasstanovka) {
                    if (selectionArea5.contains(e.getPoint())) {
                        isSelectP4 = false;
                        isSelectP3 = false;
                        isSelectP2 = false;
                        isSelectP1 = false;
                        isSelectT = false;
                        isSelectM = true;
                    }
                    if (selectionArea4.contains(e.getPoint())) {
                        isSelectP4 = true;
                        isSelectP3 = false;
                        isSelectP2 = false;
                        isSelectP1 = false;
                        isSelectT = false;
                        isSelectM = false;

                    }
                    if (selectionArea3.contains(e.getPoint())) {
                        isSelectP4 = false;
                        isSelectP3 = true;
                        isSelectP2 = false;
                        isSelectP1 = false;
                        isSelectT = false;
                        isSelectM = false;
                    }
                    if (selectionArea2.contains(e.getPoint())) {
                        isSelectP4 = false;
                        isSelectP3 = false;
                        isSelectP2 = true;
                        isSelectP1 = false;
                        isSelectT = false;
                        isSelectM = false;
                    }
                    if (selectionArea.contains(e.getPoint())) {
                        isSelectP4 = false;
                        isSelectP3 = false;
                        isSelectP2 = false;
                        isSelectP1 = true;
                        isSelectT = false;
                        isSelectM = false;
                    }
                    if (selectionArea0.contains(e.getPoint())) {
                        isSelectP4 = false;
                        isSelectP3 = false;
                        isSelectP2 = false;
                        isSelectP1 = false;
                        isSelectT = true;
                        isSelectM = false;
                    }
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (rasstanovka) {
                mX = e.getX();
                mY = e.getY();
                Graphics g = getGraphics();
                int i = (mX - (DXY)) / H;
                int j = (mY - DXY) / H;
                if (p5 != 0 && isSelectM && mX > (DXY) && mY > (DXY) && mX < (DXY + 10 * H) && mY < DXY + 10 * H) {
                    isSelectM = false;
                    g.drawImage(mina, line5[0], line5[1], line5[2], line5[3], null);
                    selectionArea4 = new Rectangle(line5[0], line5[1], line5[2], line5[3]);
                    if (game.setPaluba(i, j, 1, vert)) {
                        p5--;
                    }
                }
                if (p4 != 0 && isSelectP4 && mX > (DXY) && mY > (DXY) && mX < (DXY + 10 * H) && mY < DXY + 10 * H) {
                    isSelectP4 = false;
                    g.drawImage(ship4, line4[0], line4[1], line4[2], line4[3], null);
                    selectionArea4 = new Rectangle(line4[0], line4[1], line4[2], line4[3]);
                    if (game.setPaluba(i, j, 4, vert)) {
                        p4--;
                    }

                } else if (p3 != 0 && isSelectP3 && mX > (DXY) && mY > (DXY) && mX < (DXY + 10 * H) && mY < DXY + 10 * H) {
                    isSelectP3 = false;
                    g.drawImage(ship3, line3[0], line3[1], line3[2], line3[3], null);
                    if (game.setPaluba(i, j, 3, vert)) {
                        p3--;
                    }

                } else if (p2 != 0 && isSelectP2 && mX > (DXY) && mY > (DXY) && mX < (DXY + 10 * H) && mY < DXY + 10 * H) {
                    isSelectP2 = false;
                    g.drawImage(ship2, line2[0], line2[1], line2[2], line2[3], null);
                    if (game.setPaluba(i, j, 2, vert)) {
                        p2--;
                    }

                } else if (p1 != 0 && isSelectP1 && mX > (DXY) && mY > (DXY) && mX < (DXY + 10 * H) && mY < DXY + 10 * H) {
                    isSelectP1 = false;
                    g.drawImage(ship1, line1[0], line1[1], line1[2], line1[3], null);
                    if (game.setPaluba(i, j, 1, vert)) {
                        p1--;
                    }
                } else if (p0 != 0 && isSelectT && mX > (DXY) && mY > (DXY) && mX < (DXY + 10 * H) && mY < DXY + 10 * H) {
                    isSelectT = false;
                    g.drawImage(tral, line0[0], line0[1], line0[2], line0[3], null);
                    if (game.setPaluba(i, j, 5, vert)) {
                        p0--;
                    }
                }
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            mX = e.getX();
            mY = e.getY();
            int i = (mX - (DXY)) / H;
            int j = (mY - DXY) / H;
            Graphics g = getGraphics();
            Graphics2D g2 = (Graphics2D) g;
            if (isSelectM) {
                g.drawImage(mina, DXY + H * i, DXY + H * j, H, H, null);
            }
            if (isSelectP4) {
                if (vert) g.drawImage(ship4, DXY + H * i, DXY + H * j, H * 4, H, null);
                else g.drawImage(ship4, DXY + H * i, DXY + H * j, H, H * 4, null);
            }
            if (isSelectP3) {
                if (vert) g.drawImage(ship3, DXY + H * i, DXY + H * j, H * 3, H, null);
                else g.drawImage(ship3, DXY + H * i, DXY + H * j, H, H * 3, null);
            }
            if (isSelectP2) {
                if (vert) g.drawImage(ship2, DXY + H * i, DXY + H * j, H * 2, H, null);
                else g.drawImage(ship2, DXY + H * i, DXY + H * j, H, H * 2, null);
            }
            if (isSelectP1) {
                g.drawImage(ship1, DXY + H * i, DXY + H * j, H, H, null);
            }
            if (isSelectT) {
                g.drawImage(tral, DXY + H * i, DXY + H * j, H, H, null);
            }
        }


        @Override
        public void mouseMoved(MouseEvent e) {


        }
    }
}



