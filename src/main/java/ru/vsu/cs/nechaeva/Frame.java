package ru.vsu.cs.nechaeva;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame {

    private JMenuBar menuBar;
    private JMenu menuGame;
    private JMenuItem itemStartRast;
    private JMenuItem itemExit;

    Frame() {
        super("Sea Fight");
        Panel pole = new Panel();
        menuBar = new JMenuBar();

        menuGame = new JMenu("Игра");

        itemStartRast = new JMenuItem("Расставить корабли");
        itemStartRast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pole.startRasstanovka();
            }
        });

        itemExit = new JMenuItem("Выход");
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuGame.add(itemStartRast);
        menuGame.addSeparator();
        menuGame.add(itemExit);

        menuBar.add(menuGame);

        setJMenuBar(menuBar);
        add(pole);
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}