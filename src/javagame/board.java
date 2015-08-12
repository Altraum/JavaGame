/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class board extends JPanel{
    int selectedY = 1;
    int selectedX = 1;
    int boardSize = 5;
    JPanel[][] spaces = new JPanel[boardSize][boardSize];
    public void setBoard(){
        this.setLayout(new GridLayout(boardSize,boardSize));
        for(int i = 0; i < boardSize; i++){
            for(int ii = 0; ii < boardSize; ii++){
                spaces[i][ii] = new JPanel();
                spaces[i][ii].setBackground(Color.WHITE);
                this.add(spaces[i][ii]);
            }
        }
        spaces[selectedY][selectedX].setBackground(Color.RED);
    }
    
    public void moveLeft(){
        spaces[selectedY][selectedX].setBackground(Color.WHITE);
        spaces[selectedY][selectedX-1].setBackground(Color.RED);
        selectedX--;
    }
    
    public void moveRight(){
        spaces[selectedY][selectedX].setBackground(Color.WHITE);
        spaces[selectedY][selectedX+1].setBackground(Color.RED);
        selectedX++;
    }
    
    public void moveUp(){
        spaces[selectedY][selectedX].setBackground(Color.WHITE);
        spaces[selectedY-1][selectedX].setBackground(Color.RED);
        selectedY--;
    }
    
    public void moveDown(){
        spaces[selectedY][selectedX].setBackground(Color.WHITE);
        spaces[selectedY+1][selectedX].setBackground(Color.RED);
        selectedY++;
    }
    
    public int getSelectedX(){
        return selectedX;
    }
    
    public int getSelectedY(){
        return selectedY;
        
    }
    
    public int getLengthX(){
        return spaces[0].length;
    }
    
    public int getLengthY(){
        return spaces.length;
    }
}
    
