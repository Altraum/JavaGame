/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Basil
 */
public class JavaGame {
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        JPanel main = new JPanel();
        window.add(main);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setSize(640, 480);
        main.setLayout(new BorderLayout());
        board playArea = new board();
        playArea.setBoard();
        JPanel control = new JPanel();
        main.add(playArea, BorderLayout.CENTER);
        JButton leftBtn = new JButton();
        leftBtn.setText("Left");
        JButton rightBtn = new JButton();
        rightBtn.setText("Right");
        JButton upBtn = new JButton();
        upBtn.setText("Up");    
        JButton downBtn = new JButton();
        downBtn.setText("Down");    
        leftBtn.addActionListener(new ActionListener()  
            {
                public void actionPerformed(ActionEvent e) {
                    playArea.moveLeft();
                    if(!rightBtn.isEnabled()){
                        rightBtn.setEnabled(true);
                    }
                    if(playArea.getSelectedX()==0){
                        leftBtn.setEnabled(false);
                    }
                }
            }
        );

        rightBtn.addActionListener(new ActionListener()  {
                public void actionPerformed(ActionEvent e) {
                    playArea.moveRight();
                    if(!leftBtn.isEnabled()){
                        leftBtn.setEnabled(true);
                    }
                    if(playArea.getSelectedX()==playArea.getLengthX()-1){
                        rightBtn.setEnabled(false);
                    }
                }
            }
        );
        
        upBtn.addActionListener(new ActionListener()  {
                public void actionPerformed(ActionEvent e) {
                    playArea.moveUp();
                    if(!downBtn.isEnabled()){
                        downBtn.setEnabled(true);
                    }
                    if(playArea.getSelectedY()==0){
                        upBtn.setEnabled(false);
                    }
                }
            }
        );
        
        downBtn.addActionListener(new ActionListener()  {
                public void actionPerformed(ActionEvent e) {
                    playArea.moveDown();
                    if(!upBtn.isEnabled()){
                        upBtn.setEnabled(true);
                    }
                    if(playArea.getSelectedY()==playArea.getLengthY()-1){
                        downBtn.setEnabled(false);
                    }
                }
            }
        );
        control.add(leftBtn);
        control.add(rightBtn);
        control.add(upBtn);
        control.add(downBtn);
        main.add(control, BorderLayout.SOUTH);
        window.setVisible(true);
    }
}
