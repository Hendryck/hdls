import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.swing.event.*;

public class pong implements ActionListener, KeyListener, MouseListener, MouseMotionListener{ 
  //Properties
  JFrame theframe;
  PongAnimation thepanel;
  Timer thetimer;
  
  JLabel title;
  
  boolean blnapressed = false;
  boolean blndpressed = false;
  
  boolean blnleftpressed = false;
  boolean blnrightpressed = false;
  
  JLabel welcomeMessage;
  
  JLabel redWins;
  JLabel blueWins;
  
  int intRedWins = 0;
  int intBlueWins = 0;
  
  int intClickState = 0;
  
  
  
  //Methods
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource() == thetimer){
      //System.out.println(thepanel.intGameEnd);
      if(blnapressed){
        thepanel.intRY = thepanel.intRY - 8;
        
        Ellipse2D.Double red = new Ellipse2D.Double(thepanel.intRX, thepanel.intRY, 10, 60);
        Rectangle2D.Double screen = new Rectangle2D.Double(0,0,1200, 800);
        
        if(!screen.contains(red.getBounds2D()) || !screen.contains(red.getBounds2D())){
          thepanel.intRY = thepanel.intRY + 8; 
        }
        
      }
      
      if(blndpressed){
        thepanel.intRY = thepanel.intRY + 8; 
        
        Ellipse2D.Double red = new Ellipse2D.Double(thepanel.intRX, thepanel.intRY, 10, 60);
        Rectangle2D.Double screen = new Rectangle2D.Double(0,0,1200, 800);
        
        if(!screen.contains(red.getBounds2D()) || !screen.contains(red.getBounds2D())){
          thepanel.intRY = thepanel.intRY - 8; 
        }
        
      }
      
      if(blnleftpressed){
        thepanel.intBY = thepanel.intBY - 8;
        
        Ellipse2D.Double blue = new Ellipse2D.Double(thepanel.intBX, thepanel.intBY, 10, 60);
        Rectangle2D.Double screen = new Rectangle2D.Double(0,0,1200, 800);
        
        if(!screen.contains(blue.getBounds2D()) || !screen.contains(blue.getBounds2D())){
          thepanel.intBY = thepanel.intBY + 8; 
        }
        
      }
      if(blnrightpressed){
        thepanel.intBY = thepanel.intBY + 8;
        
        
        Ellipse2D.Double blue = new Ellipse2D.Double(thepanel.intBX, thepanel.intBY, 10, 60);
        Rectangle2D.Double screen = new Rectangle2D.Double(0,0,1200, 800);
        
        if(!screen.contains(blue.getBounds2D()) || !screen.contains(blue.getBounds2D())){
          thepanel.intBY = thepanel.intBY - 8; 
        }
        
       
      }
      
      if(thepanel.intGameEnd == 10){
       thepanel.intXDelta = 0;
       thepanel.intYDelta = 0;
       
       if(thepanel.intBallX < 0 && thepanel.intGameEnd == 10){
         thepanel.intBallX = 600;
         thepanel.intBallY = 420;
         welcomeMessage.setForeground(Color.BLUE);
         welcomeMessage.setLocation(1200/2 - 120,300);
         welcomeMessage.setText("BLUE WINS - PRESS SPACE FOR NEW GAME");
         intBlueWins = intBlueWins + 1;
         blueWins.setText(String.valueOf(intBlueWins));
         thepanel.intGameEnd = 0;
        //System.out.println("Blue Wins"); 
      
       }else if(thepanel.intBallX > 500 && thepanel.intGameEnd == 10){
         thepanel.intBallX = 600;
         thepanel.intBallY = 420;
         welcomeMessage.setForeground(Color.RED);
         welcomeMessage.setLocation(1200/2 - 120,300);
         welcomeMessage.setText("RED WINS - PRESS SPACE FOR NEW GAME");
         intRedWins = intRedWins + 1;
         redWins.setText(String.valueOf(intRedWins));
         thepanel.intGameEnd = 0;
         //System.out.println("Red Wins");
       }
       
       
      }
      
      
      thepanel.repaint(); 
    }
  }
  
  public void mouseExited(MouseEvent evt){
    // System.out.println("Mouse Exited");
  }
  
  public void mouseEntered(MouseEvent evt){
    //System.out.println("Mouse Entered");
  }
  
  public void mouseReleased(MouseEvent evt){
    
    if(intClickState == 0 || intClickState == 5){
    thepanel.intXDelta = 10;
    thepanel.intYDelta = 5;
    welcomeMessage.setText(" ");
    intClickState = 1;
    }
    
    //System.out.println("Mouse Let Go");
  }
  
  public void mousePressed(MouseEvent evt){
    // System.out.println(evt.getButton());
  }
  
  public void mouseClicked(MouseEvent evt){
    //System.out.println("Mouse Pressed");
  }
  
  public void mouseMoved(MouseEvent evt){
    
  }
  
  public void mouseDragged(MouseEvent evt){
    
  }
  
  
  
  
  public void keyReleased(KeyEvent evt){
    //System.out.println(evt.getKeyCode());
    if(evt.getKeyChar() == 'a'){
      blnapressed = false; 
    }if(evt.getKeyChar() == 'd'){
      blndpressed = false; 
    }if(evt.getKeyCode() == 37){
      blnleftpressed = false;
    }if(evt.getKeyCode() == 39){
      blnrightpressed = false;
    }
    
  }
  
  
  public void keyPressed(KeyEvent evt){
    
    if(evt.getKeyChar() == 'a'){
      blnapressed = true; 
    }else if(evt.getKeyChar() == 'd'){
      blndpressed = true; 
    }else if(evt.getKeyCode() == 37){
      blnleftpressed = true;
    }else if(evt.getKeyCode() == 39){
      blnrightpressed = true; 
    }
    
    if(evt.getKeyChar() == 32){
     intClickState = 0; 
     
     if(intClickState == 0){
       thepanel.intGameEnd = 0;
    thepanel.intBallX = 600; 
    thepanel.intBallY = 420;
    thepanel.intXDelta = 0;
    thepanel.intYDelta = 0;
    
    
    welcomeMessage.setText("PONG - CLICK ANYWHERE TO START");
    welcomeMessage.setForeground(Color.cyan);
    welcomeMessage.setSize(500,200);
    welcomeMessage.setLocation(500,300);
    
    intClickState = 5;
    }
     
    }
    
  }
  public void keyTyped(KeyEvent evt){
    
  }
  
  //Constructor
  public pong(){
    thepanel = new PongAnimation();
    thepanel.setLayout(null);
    thepanel.setPreferredSize(new Dimension(1200, 800));
    thepanel.addMouseListener(this);
    thepanel.addMouseMotionListener(this);
    
    welcomeMessage = new JLabel("PONG - CLICK ANYWHERE TO START");
    welcomeMessage.setForeground(Color.cyan);
    welcomeMessage.setSize(500,200);
    welcomeMessage.setLocation(500,300);
    thepanel.add(welcomeMessage, "push, align center" );
    
    redWins = new JLabel(String.valueOf(intRedWins));
    redWins.setForeground(Color.red);
    redWins.setLocation(10, 10);
    redWins.setSize(30,30);
    thepanel.add(redWins);
    
    blueWins = new JLabel(String.valueOf(intBlueWins));
    blueWins.setForeground(Color.blue);
    blueWins.setLocation(1180, 10);
    blueWins.setSize(30,30);
    thepanel.add(blueWins);
    
//    thepanel.addMouseListener(this);
//    thepanel.addMouseMotionListener(this);
    
    theframe = new JFrame("Pong - Hendryck"); 
    theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    theframe.setContentPane(thepanel);
    theframe.pack();
    theframe.setVisible(true);
    theframe.addKeyListener(this);
    
    thetimer = new Timer(1000/60, this);
    thetimer.start();
    
  }
  //Main Method
  public static void main(String [] args){
    new pong();
  }
  
  
  
  
  
}


