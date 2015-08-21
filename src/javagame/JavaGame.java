/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Basil
 */
public class JavaGame{
    
    public static void main(String[] args) {
        
        JFrame window = new JFrame();
        JPanel main = new JPanel();
        window.add(main);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setSize(640, 480);
        main.setLayout(new BorderLayout());
        board playArea = new board();
        playArea.setFocusable(true);
        playArea.setBoard();
        JPanel control = new JPanel();
        main.add(playArea, BorderLayout.CENTER);
        /*JButton leftBtn = new JButton();
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
                    playArea.setLeft();
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
                    playArea.setRight();
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
                    playArea.setUp();
                    if(!downBtn.isEnabled()){
                        downBtn.setEnabled(true);
                    }
                    if(playArea.getSelectedY()<0){
                        upBtn.setEnabled(false);
                    }
                }
            }
        );
        
        downBtn.addActionListener(new ActionListener()  {
                public void actionPerformed(ActionEvent e) {
                    playArea.setDown();
                    if(!upBtn.isEnabled()){
                        upBtn.setEnabled(true);
                    }
                    if(playArea.getSelectedY()==playArea.getLengthY()-1){
                        downBtn.setEnabled(false);
                    }
                }
            }
        );*/
        
        playArea.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped( KeyEvent evt ) {
            }

            @Override
            public void keyPressed( KeyEvent evt ) {
                if(evt.getKeyCode() == KeyEvent.VK_DOWN){
                    playArea.setDown();
                    System.out.println("DOWN");
                }
                if(evt.getKeyCode() == KeyEvent.VK_UP){
                    playArea.setUp();
                    System.out.println("UP");
                }
                if(evt.getKeyCode() == KeyEvent.VK_LEFT){
                    playArea.setLeft();
                    System.out.println("LEFT");
                }
                if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
                    playArea.setRight();
                    System.out.println("RIGHT");
                }
            }

            @Override
            public void keyReleased( KeyEvent evt ) {
            }
        } );
        
        /*control.add(leftBtn);
        control.add(rightBtn);
        control.add(upBtn);
        control.add(downBtn);
        main.add(control, BorderLayout.SOUTH);*/
        window.setVisible(true);
    }  
}
