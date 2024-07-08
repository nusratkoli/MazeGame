package MazeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements AdjustmentListener{
	
	private Timer timer;
	public Board() {
		timer =new Timer(25,(ActionListener) this);
		timer.start();
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		repaint();
	} 
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.red);
		g.fillRect(45, 60, 15, 15);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
