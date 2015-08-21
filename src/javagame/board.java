/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.*;

public class board extends JPanel{
    int selectedY;
    int selectedX;
    int boardSize = 9;
    int direction;
    int score;
    double speed = 550;
    moveDirection moveDirection = new moveDirection();
    Timer cycle = new Timer( (int)speed, moveDirection);
    ArrayList trailX = new ArrayList(1);
    ArrayList trailY = new ArrayList(1);
    JPanel[][] spaces = new JPanel[boardSize][boardSize];
    
    class moveDirection implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
            if(direction == 1){
                moveUp();
            }
            if(direction == 2){
                moveRight();
            }
            if(direction == 3){
                moveDown();
            }
            if(direction == 4){
                moveLeft();
            }
        }
    }
    
    public void trail(){
        spaces[(int)trailY.get(0)][(int)trailX.get(0)].setBackground(Color.WHITE);
        trailX.remove(0);
        trailY.remove(0);
    }
    
    public void collision(){
        if(selectedX<0 || selectedX>=getLengthX() || selectedY<0 || selectedY>=getLengthY()|| spaces[selectedY][selectedX].getBackground()==Color.RED){
            cycle.stop();
            this.removeAll();
            this.setLayout(new FlowLayout());
            this.add(getScore());
            JButton restartBtn = new JButton("Restart");
            restartBtn.addActionListener(new ActionListener()  
                {
                    public void actionPerformed(ActionEvent e) {
                        setBoard();
                    }
                }
            );
            this.add(restartBtn);
            this.repaint();
            this.revalidate();
        }
        else{
            if(spaces[selectedY][selectedX].getBackground()==Color.BLUE){
                spaces[selectedY][selectedX].setBackground(Color.RED);
                spawnFood();
                trailX.add(selectedX);
                trailY.add(selectedY);
                cycle.setDelay((int)speed);
            }
            
            else{
                spaces[selectedY][selectedX].setBackground(Color.RED);
                trail();
                trailX.add(selectedX);
                trailY.add(selectedY);
            }
        }
    }
    
    public void makeWall(JPanel jp){
        this.setBackground(Color.GRAY);
        
    }
    
    public void setBoard(){
        this.removeAll();
        this.setLayout(new GridLayout(boardSize,boardSize));
        for(int i = 0; i < boardSize; i++){
            for(int ii = 0; ii < boardSize; ii++){
                spaces[i][ii] = new JPanel();
                spaces[i][ii].setBackground(Color.WHITE);
                spaces[i][ii].setBorder(BorderFactory.createLineBorder(Color.black));
                this.add(spaces[i][ii]);
            }
        }
        selectedY = 8;
        selectedX = 4;
        score = -1;
        speed = 550;
        direction = 1;
        trailX.removeAll(trailX);
        trailY.removeAll(trailY);
        trailX.add(selectedX);
        trailY.add(selectedY);
        spaces[selectedY][selectedX].setBackground(Color.RED);
        spawnFood();
        this.revalidate();
        cycle.setDelay((int)speed);
        cycle.start();
    }
    
    public void spawnFood(){
        Random randomX = new Random();
        int x = randomX.nextInt(boardSize);
        Random randomY = new Random();
        int y = randomY.nextInt(boardSize);
        while(spaces[y][x].getBackground()==Color.RED){
            x = randomX.nextInt(boardSize);
            y = randomY.nextInt(boardSize);
        }
        spaces[y][x].setBackground(Color.BLUE);
        speed = speed/1.1;
        System.out.println(speed);
        score++;
    }
    
    public JLabel getScore(){
        JLabel finalScore = new JLabel("Score: " + score);
        return finalScore;
    }
    
    public void moveLeft(){
        selectedX--;
        collision();
    }
    
    public void setLeft(){
        direction = 4;
    }
    
    public void moveRight(){
        selectedX++;
        collision();
    }
    
    public void setRight(){
        direction = 2;
    }
    
    public void moveUp(){
        selectedY--;
        collision();
    }
    
    public void setUp(){
        direction = 1;
    }
    
    public void moveDown(){
        selectedY++;
        collision();
    }
    
    public void setDown(){
        direction = 3;
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