package GameOfLife;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import GameOfLife.Cell;


public class NewOutLooks extends JFrame {
    int SIZE = 150;
    JButton knapp1 = new JButton("1");
    JButton knapp2 = new JButton("10");
    JButton knapp3 = new JButton("100");
    JButton knapp4 = new JButton("500");

    //JPanel[][] board = new JPanel[SIZE][SIZE];
    JPanel gamePanel = new JPanel();
    JPanel knappPanel = new JPanel();

    double StartAliveChanse = 0.97;
    private Cell[][] board = new Cell[SIZE][SIZE];


    public NewOutLooks() {
        setLayput();
        initiateBoard();
        addButtons();
        setVisible(true);


    }

    public void setLayput() {
        setTitle("Fifteen Puzzle Game");
        setSize(600, 600);
        setResizable(true);
        gamePanel.setLayout(new GridLayout(SIZE, SIZE));
        knappPanel.setLayout(new FlowLayout());
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gamePanel.setSize(500, 500);
        knappPanel.setSize(500, 100);
        add(gamePanel, BorderLayout.CENTER);
        add(knappPanel, BorderLayout.SOUTH);


    }

    public void addButtons() {
        knappPanel.add(knapp1).addMouseListener(m1);
        knappPanel.add(knapp2).addMouseListener(m1);
        knappPanel.add(knapp3).addMouseListener(m1);
        knappPanel.add(knapp4).addMouseListener(m1);


    }


    private void initiateBoard() {

        int counter = 0;
        int lifeCounter = 0;
        double fiskeKvot;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
                gamePanel.add(board[i][j]);
                if (Math.random() < StartAliveChanse) {
                    board[i][j].setAlive();

                }
                counter++;
                if (board[i][j].isAlive()) lifeCounter++;

            }
        }
        // fiskeKvot = (double) lifeCounter/counter;
        System.out.println("Counter: " + counter);
        System.out.printf("lifeCounter: %d\n", lifeCounter);
        //System.out.println("fiskekvot: " + (double) lifeCounter/counter); // mkt bra
    }

    public int neighborCount(int row, int col) {

        int count = 0;

        if (row - 1 >= 0 && col - 1 >= 0 && board[row - 1][col - 1].isAlive())
            count++;
        if (row - 1 >= 0 && col + 1 < board[0].length && board[row - 1][col + 1].isAlive())
            count++;
        if (row - 1 >= 0 && board[row - 1][col].isAlive())
            count++;
        if (col - 1 >= 0 && board[row][col - 1].isAlive())
            count++;
        if (col + 1 < board[0].length && board[row][col + 1].isAlive())
            count++;
        if (row + 1 < board.length && col - 1 >= 0 && board[row + 1][col - 1].isAlive())
            count++;
        if (row + 1 < board.length && col + 1 < board[0].length && board[row + 1][col + 1].isAlive())
            count++;
        if (row + 1 < board.length && board[row + 1][col].isAlive())
            count++;

        return count;
    }

    private int killOrSpare() {
        int counter = 0;
        for (int i = 0; i < SIZE; i++) {
            gamePanel.repaint();
            for (int j = 0; j < SIZE; j++) {

                if (!board[i][j].isAlive()) {
                    if (neighborCount(i, j) == 3) {
                        board[i][j].setAlive();
                    }
                }
                if (board[i][j].isAlive()) {
                    if (neighborCount(i, j) < 2 || neighborCount(i, j) > 3) {
                        board[i][j].setDead();
                    }
                }
                if (board[i][j].isAlive()) {
                    counter++;
                }

            }
        }
        System.out.println("lifeCount after killOrSpare" + counter);
        return counter;
    }

    MouseAdapter m1 = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            if (e.getComponent() == knapp1) {
                try {
                    for (int i = 0; i < 1; i++) {
                        Thread.sleep(100);
                        repaint();
                        killOrSpare();
                        System.out.println("knapp1");
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if (e.getComponent() == knapp2) {

                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(100);
                        killOrSpare();
                        repaint();
                        System.out.println("knapp2");
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            if (e.getComponent() == knapp3) {
                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(100);
                        killOrSpare();
                        repaint();
                        System.out.println("knapp3");
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            if (e.getComponent() == knapp4) {
                try {
                    for (int i = 0; i < 500; i++) {
                        Thread.sleep(100);
                        killOrSpare();
                        repaint();
                        System.out.println("knapp4");
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }


    };

    public static void main(String[] args) throws InterruptedException {
        GameOfLife.NewOutLooks hd = new GameOfLife.NewOutLooks();
        Thread.sleep(3000);
        hd.killOrSpare();
        Thread.sleep(3000);
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(17);
            hd.killOrSpare();
        }
    }
}









