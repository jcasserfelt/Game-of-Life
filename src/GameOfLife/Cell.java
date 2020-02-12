package GameOfLife;


import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private boolean alive;

    // Constructor
    public Cell(boolean status) {
        this.alive = status;
    }

    public Cell(){

    }

    public boolean isAlive() {
        return this.alive;
    }

    public void setAlive() {
        this.alive = true;
        this.setBackground(Color.BLACK);
    }

    public void setDead() {
        this.alive = false;
        this.setBackground(Color.WHITE);
    }

    // Copy the damn cell
    public GameOfLife.Cell copyCell() {

        return new GameOfLife.Cell(this.alive);
    }
}
