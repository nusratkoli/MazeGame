package MazeGame;

import javax.swing.JFrame;

public class MazeGame {
	public static void main(String[]args) {
		new MazeGame();
	}
	public MazeGame() {
		JFrame f=new JFrame();
		f.setTitle("MazeGame");
		f.setSize(500,400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}
