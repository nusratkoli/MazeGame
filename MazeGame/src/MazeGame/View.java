  package MazeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class View extends JFrame{
	
	private int[][] maze={
			 {1,1,1,1,1,1,1,1,1,1,1,1,1},
				  {1,0,1,0,1,0,1,0,0,0,0,0,1},
				  {1,0,1,0,0,0,1,0,1,1,1,0,1},
				  {1,0,0,0,1,1,1,0,0,0,0,0,1},
				  {1,0,1,0,0,0,0,0,1,1,1,0,1},
				  {1,0,1,0,1,1,1,0,1,0,0,0,1},
				  {1,0,1,0,1,0,0,0,1,1,1,0,1},
				  {1,0,1,0,1,1,1,0,1,0,1,0,1},
				  {1,0,0,0,0,0,0,0,0,0,1,9,1},
				  {1,1,1,1,1,1,1,1,1,1,1,1,1}

				};
	private final List<Integer>path = new ArrayList<Integer>();
	private int pathIndex;
	
	
	
	
  public View() {
	  setTitle("MazeGame");
	  setSize(640,480);
	  setLocationRelativeTo(null);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  DepthFirst.searchPath(maze, 1, 1, path);
	  pathIndex=path.size() -2;
	  System.out.println(path);
	  
	  
  }
  public void paint (Graphics g) {
	  super.paint(g);
	  
	  g.translate(50, 50);
	  
	  for (int row = 0 ; row < maze.length; row++) {
		  for (int col= 0 ; col < maze[0].length;col++) {
			  Color color;
			  switch (maze[row][col]) {
			  case 1 : color=Color.BLACK; break;
			  case 9 : color=Color.RED; break;
			  default: color=Color.WHITE;
			  }
			  g.setColor(color);
			  g.fillRect(15 * col, 15 * row, 15,15);
			  g.setColor(Color.BLACK);
			  g.drawRect(15 * col, 15 * row, 15,15);
			  
		  }
	  }
	  
	  for (int p = 0 ; p < path.size(); p += 2) {
		  int pathX =path.get(p);
		  int pathY =path.get(p+1);
		  g.setColor(Color.GREEN);
		  g.fillRect(pathX * 15, pathY * 15, 15, 15);
	  }
	  
	  int pathX = path.get(pathIndex);
	  int pathY = path.get(pathIndex +1);
	  g.setColor(Color.RED);
	  g.fillOval(pathX*15, pathY*15, 15, 15);
	  
	  
  }
  protected void processKeyEvent(KeyEvent ke) {
	  if (ke.getID() != KeyEvent.KEY_PRESSED) {
		  return;
	  }
	  if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
		  pathIndex -= 2;
		  if (pathIndex < 0) {
			  pathIndex = 0;
		  }
		  
	   }
	      else if (ke.getKeyCode()== KeyEvent.VK_LEFT) {
		  pathIndex +=2;
		  if (pathIndex > path.size() - 2) {
			  pathIndex = path.size() - 2;
		  }
	  }
	  repaint();
	  }
  
  
  
  
  public static void main(String[]args) {
	  SwingUtilities.invokeLater(new Runnable(){
		  public void run() {
			  View view = new View();
			  View view2 = new View();
			view2.setVisible(true);
		  }
	  });
  }
  
}
